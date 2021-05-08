package MultithreadingTicket;

/**
 * 多线程卖票
 */
public class TestMain {
    public static void main(String[] args) {
        Ticket sellTicketsThread = new Ticket();
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

