package com.github.liao47.utils.bo;

import lombok.Data;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延时任务
 * @author liao47
 * @date 2022/1/25 10:24
 */
@Data
public class DelayedTask implements Delayed {
    /**
     * id
     */
    private final Long id;
    /**
     * 任务时间
     */
    private final Date taskTime;

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(taskTime.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
    }
}
