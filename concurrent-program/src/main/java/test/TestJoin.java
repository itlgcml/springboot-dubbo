package test;

import lombok.extern.slf4j.Slf4j;

/**
 * 等待其他线程执行完成
 */
@Slf4j
public class TestJoin {
    static int r1 = 0;
    static int r2 = 0;
    public static void main(String[] args) throws InterruptedException {
        test2();
    }
    private static void test2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            ThreadLg.sleep(1000l);
            r1 = 10;
        });
        Thread t2 = new Thread(() -> {
            ThreadLg.sleep(2000l);
            r2 = 20;
        });
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        //t2.join();
        t1.join(1010l);

        long end = System.currentTimeMillis();
        log.debug("r1: {} r2: {} cost: {}", r1, r2, end - start);
        ThreadLg.sleep(1000L);
        log.debug("r1: {} r2: {} cost: {}", r1, r2, end - start);
    }
}
