package threadpool;

import java.util.concurrent.*;
/**
 * 多线程中线程池调用实例，
 * 在使用线程池处理多线程时，
 * ThreadPoolTask这个实现了Runnable接口的类需要注意，
 * 里面的成员属性都需要是线程安全的类
 */

public class TestThreadPool {


    public static void main(String[] args) {
        final int corePoolSize = 10;

        final ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, corePoolSize + 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20));

        try {
            Long[] longArray = {1l, 2l, 3l, 1l, 2l, 1l};
            final CountDownLatch latch = new CountDownLatch(longArray.length);
            for (int i = 0; i < longArray.length; i++) {
                ThreadPoolTask task = new ThreadPoolTask(longArray[i], 0l, latch);
                executor.execute(task);
            }
            //latch.await();
            System.out.println("结束了");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
