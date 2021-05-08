package test;

import lombok.extern.slf4j.Slf4j;

/**
 * lambda表达式
 */
@Slf4j(topic = "Test2")
public class Test2Thread {
    public static void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                log.debug("running");
            }
        };
        Thread thread = new Thread(r, "t2");
        thread.start();
    }

    public static void test2() {
        Runnable r = () -> {
            log.debug("running");
        };
        Thread thread = new Thread(r, "t2");
        thread.start();
    }
}
