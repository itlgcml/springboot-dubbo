package MultithreadingTicket;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import test.ThreadLg;

/**
 * 买票重新实现方法
 */
@Slf4j
public class Ticket implements Runnable {

    private int total = 5;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (this.total > 0) {
                    Thread thread = Thread.currentThread();
                    log.debug("{}线程数为:{}出售第{}张票", thread.getName(), Thread.activeCount(), String.valueOf(this.total));
                    ThreadLg.sleep(1000l);
                    this.total = this.total - 1;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket, "t1");
        Thread thread2 = new Thread(ticket, "t2");
        Thread thread3 = new Thread(ticket, "t3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
