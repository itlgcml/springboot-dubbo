package MultithreadingTicket;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 买票重新实现方法
 */
@Slf4j
public class A2 implements Runnable {

    private AtomicInteger ticketCount = new AtomicInteger(0);

    @Override
    public void run() {
        while (ticketCount.get() < 50) {
            sellTicket();
            /**
             当前线程休眠，好让其他线程继续执行
             */
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sellTicket() {
        if (ticketCount.get() < 50) {
            int i = ticketCount.incrementAndGet();
            log.info(Thread.currentThread().getName() + "正在卖第：" +i);
        } else {
            log.info("票已卖完");
            return;
        }
    }

    public static void main(String[] args) {
        A2 sellTicketsThread = new A2();
        Thread firstThread = new Thread(sellTicketsThread, "线程1");
        Thread secondThread = new Thread(sellTicketsThread, "线程2");
        Thread thirdThread = new Thread(sellTicketsThread, "线程3");
        Thread fourthThread = new Thread(sellTicketsThread, "线程4");
        Thread fifthThread = new Thread(sellTicketsThread, "线程5");
        firstThread.start();
        secondThread.start();
        thirdThread.start();
        fourthThread.start();
        fifthThread.start();
    }

}

