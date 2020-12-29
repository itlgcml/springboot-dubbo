package test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * 烧水多线程练习
 */
@Slf4j
public class TestPractice1 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.debug("洗茶壶");
                ThreadLg.sleep(1000);
                log.debug("泡茶杯");
                ThreadLg.sleep(1000);
                log.debug("拿茶叶");
                ThreadLg.sleep(1000);
            }
        };
        Thread thread1 = new Thread(runnable, "小李");
        thread1.start();

        Runnable xw = () -> {
            log.debug("洗水壶");
            ThreadLg.sleep(1000);
            log.debug("烧水开始");
            ThreadLg.sleep(5000);
            log.debug("烧水完成");
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        Thread xwThread = new Thread(xw, "小王");
        xwThread.start();
    }
}
