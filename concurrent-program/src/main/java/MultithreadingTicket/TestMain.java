package MultithreadingTicket;

public class TestMain {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket,"t1");
        Thread thread2 = new Thread(ticket,"t2");
        Thread thread3 = new Thread(ticket,"t3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

