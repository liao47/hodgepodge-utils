import com.github.liao47.leetcode.utils.ReadFileUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author liaoshiqing
 * @date 2021/12/1 10:08
 */
public class SqlTest {

    @Test
    public void inTest() {
        List<String> ids = ReadFileUtils.read("sqlInKeys").stream().distinct().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        String key = "id";
        for (int i = 0; i < ids.size(); i++) {
            if (i == 0) {
                sb.append(key).append(" IN(");
            } else if (i % 1000 == 0) {
                sb.append(")\nOR ").append(key).append(" IN(");
            } else {
                sb.append(",");
            }
            sb.append(ids.get(i).substring(1));
        }
        sb.append(")");
        ReadFileUtils.write(sb.toString(), "C:\\work\\export\\member20220104_4.txt");
    }

    @Test
    public void testGroup() {
        List<A> list = new ArrayList<>();
        list.add(A.of("D", 2));
        list.add(A.of("B", 3));
        list.add(A.of("D", 1));
        list.add(A.of("D", 3));
        list.add(A.of("B", 2));
        list.add(A.of("C", 1));
        Map<String, List<A>> map = list.stream().collect(Collectors.groupingBy(a -> a.name, LinkedHashMap::new, Collectors.toList()));
        for (Map.Entry<String, List<A>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static class A {
        String name;
        int age;
        public static A of(String name, int age) {
            A a = new A();
            a.name = name;
            a.age = age;
            return a;
        }

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 100L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10));
        CompletableFuture<Integer>[] futures = new CompletableFuture[10];
        for (int i = 0; i < 10; i++) {
            final int j = i;
            futures[i] = CompletableFuture.supplyAsync(() -> {
                if (j == 5) {
                    throw new RuntimeException("2333:" + j);
                }
                System.out.println(System.currentTimeMillis() + " end:" + j);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return j;
            }, executor);
        }
        try {
            CompletableFuture.allOf(futures).join();
        } catch (CompletionException e) {
            System.out.println(e.getMessage());
        }
        for (CompletableFuture<Integer> future : futures) {
            System.out.println(future.get());
        }
    }
}
