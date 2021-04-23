package threadpool;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

@Slf4j
public final class ThreadPoolTask implements Runnable, Serializable {
    //业务需要的参数，需要注意此类属性需要是线程安全的
    private Long i;
    private Long sum=0l;
    //
    private CountDownLatch latch;

    public ThreadPoolTask(Long i, Long sum, CountDownLatch latch) {
        this.i = i;
        this.latch = latch;
        this.sum = sum;
    }


    @Override
    public void run() {
        getSum(i, latch);
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getSum(Long i, CountDownLatch latch) {
        try {
            log.info("------------------>" + i);
            sum += i;
            log.info("sum------------------>" + sum);
            latch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
