package threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 多线程中线程池调用实例，
 * 在使用线程池处理多线程时，
 * ThreadPoolTask这个实现了Runnable接口的类需要注意，
 * 里面的成员属性都需要是线程安全的类
 */
@Slf4j
public class TestThreadPool {


    public static void main(String[] args) {
        final int corePoolSize = 1;
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, corePoolSize+3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1), handler);

        try {
            AtomicLong atomicLong = new AtomicLong();
            Long[] longArray = {1l, 2l, 3l, 4l, 5l, 6l};
            final CountDownLatch latch = new CountDownLatch(longArray.length);
            for (int i = 0; i < longArray.length; i++) {
                ThreadPoolTask task = new ThreadPoolTask(longArray[i], latch, atomicLong);
                executor.execute(task);
            }
            latch.await();
            log.info("和为：" + atomicLong);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
