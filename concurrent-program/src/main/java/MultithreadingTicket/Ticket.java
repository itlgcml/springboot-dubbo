package MultithreadingTicket;


import lombok.extern.slf4j.Slf4j;

/**
 * 买票重新实现方法
 */
@Slf4j
public class Ticket implements Runnable {

    private Long ticketCount = 50l;

    @Override
    public void run() {
        while (ticketCount > 0) {
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
        synchronized (this) {
            if (ticketCount > 0) {
                log.info(Thread.currentThread().getName() + "正在卖第：" + ticketCount + "张票" +
                        ",还剩" + (ticketCount - 1) + "张票");
                ticketCount--;
            } else {
                log.info("票已卖完");
                return;
            }
        }
    }

}

