package com.github.liao47.utils;

import com.github.liao47.utils.bo.DelayedTask;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * 延时任务处理器
 *
 * @author liao47
 * @date 2022/1/25 10:25
 */
@Slf4j
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Delays<T extends DelayedTask> {

    /**
     * 延迟队列集合
     */
    private static final Map<String, DelayQueue<? extends DelayedTask>> DELAYED_MAP = new HashMap<>();
    /**
     * 线程池集合
     */
    private static final Map<String, Executor> EXECUTOR_MAP = new HashMap<>();

    private final String key;
    private final DelayQueue<T> delayQueue;

    /**
     * 通过延时任务类型创建实例
     *
     * @param key
     * @return
     */
    public static <T extends DelayedTask> Delays<T> of(String key) {
        return new Delays<>(key, (DelayQueue<T>) DELAYED_MAP.computeIfAbsent(key, k -> new DelayQueue<T>()));
    }

    /**
     * 添加延迟任务
     *
     * @param task
     * @param <T>
     * @return
     */
    public Delays<T> offer(T task) {
        if (!delayQueue.contains(task)) {
            delayQueue.offer(task);
        }
        return this;
    }

    /**
     * 延时处理任务
     *
     * @param function 执行任务方法
     * @param <T>
     */
    public void execute(Function<T, Object> function) {
        this.execute(function, null);
    }

    /**
     * 延时处理任务
     *
     * @param function 执行任务方法
     * @param traceKey 日志流水号键
     * @param <T>
     */
    public void execute(Function<T, Object> function, String traceKey) {
        String trace = StringUtils.isEmpty(traceKey) ? null : MDC.get(traceKey);
        EXECUTOR_MAP.computeIfAbsent(key, k -> {
            Executors.newSingleThreadExecutor();
            return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<>(),
                    r -> {
                        Thread thread = Executors.defaultThreadFactory().newThread(r);
                        thread.setName("delay-thread-" + k.toLowerCase());
                        return thread;
                    }, new ThreadPoolExecutor.DiscardPolicy());
        }).execute(() -> {
            if (trace != null) {
                MDC.put(traceKey, trace);
            }
            while (!delayQueue.isEmpty()) {
                try {
                    function.apply(delayQueue.take());
                } catch (InterruptedException e) {
                    log.error("延时任务[{}]获取失败", key);
                    Thread.currentThread().interrupt();
                }
            }
        });
    }
}
