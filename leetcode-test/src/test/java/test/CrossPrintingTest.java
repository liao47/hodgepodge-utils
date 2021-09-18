package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author liaoshiqing
 * @date 2021/9/14 15:14
 */
public class CrossPrintingTest {
    public static final String RESULT = "A1B2C3D4E5F6G7H8I9J10K11L12M13N14O15P16Q17R18S19T20U21V22W23X24Y25Z26";
    Thread t1 = null;
    Thread t2 = null;
    @Test
    public void test() throws InterruptedException {
        StringBuffer sb = new StringBuffer();
        t1 = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                sb.append((char) ('A' + i));
                LockSupport.unpark(t2);
                LockSupport.park();
            }
            System.out.println("t1 end");
        });

        t2 = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                LockSupport.park();
                sb.append(i);
                LockSupport.unpark(t1);
            }
            System.out.println("t2 end");
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(sb);
        Assert.assertEquals(RESULT, sb.toString());
    }

    enum RunnableThread {T1, T2}
    volatile RunnableThread runnable = RunnableThread.T1;

    @Test
    public void test2() throws InterruptedException {
        StringBuffer sb = new StringBuffer();
        t1 = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                while (runnable != RunnableThread.T1) {}
                sb.append((char) ('A' + i));
                runnable = RunnableThread.T2;
            }
            System.out.println("t1 end");
        });

        t2 = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                while (runnable != RunnableThread.T2) {}
                sb.append(i);
                runnable = RunnableThread.T1;
            }
            System.out.println("t2 end");
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(sb);
        Assert.assertEquals("A1B2C3D4E5F6G7H8I9J10K11L12M13N14O15P16Q17R18S19T20U21V22W23X24Y25Z26", sb.toString());
    }
}
