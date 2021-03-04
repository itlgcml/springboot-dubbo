package threadpool;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

public final class ThreadPoolTask implements Runnable, Serializable {
    //业务需要的参数，需要注意此类属性需要是线程安全的
    private Long i;
    private Long sum;
    //
    private CountDownLatch latch;

    public ThreadPoolTask(Long i, Long sum, CountDownLatch latch) {
        this.i = i;
        this.latch = latch;
        this.sum = sum;
    }


    @Override
    public void run() {
        getSum(i, latch, sum);
    }

    private void getSum(Long i, CountDownLatch latch, Long sum) {
        try {
            Thread.sleep(i*1000);
            System.out.println("------------------>" + i);
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
