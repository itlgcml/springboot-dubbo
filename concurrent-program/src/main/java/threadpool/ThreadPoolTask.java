package threadpool;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class ThreadPoolTask implements Runnable, Serializable {
    //业务需要的参数
    private Long i;
    private CountDownLatch latch;
    private AtomicLong atomicLong;

    public ThreadPoolTask(Long i, CountDownLatch latch, AtomicLong atomicLong) {
        this.i = i;
        this.latch = latch;
        this.atomicLong = atomicLong;
    }


    @Override
    public void run() {
        getSum(i, latch, atomicLong);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getSum(Long i, CountDownLatch latch, AtomicLong atomicLong) {
        try {
            int sum = 0;
            for (int n = 1; n <= i; n++) {
                sum += n;
            }
            log.info("sum------------------>" + atomicLong.addAndGet(sum));
            latch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
