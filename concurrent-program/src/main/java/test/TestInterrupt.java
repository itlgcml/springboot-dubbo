package test;

import lombok.extern.slf4j.Slf4j;

/**
 * 休眠的线程被打断，会抛异常
 */
@Slf4j
public class TestInterrupt {
  /*  public static void main(String[] args) {
        Thread thread = new Thread("t1") {
            @Override
            public void run() {
                ThreadLg.sleep(1000l);
                log.debug("t1.run");
            }
        };
        thread.start();
        ThreadLg.sleep(500l);
        thread.interrupt();
        log.debug("打断状态:{}", thread.isInterrupted());
    }*/


    public static void main(String[] args) {
        Thread thread = new Thread("t1") {
            @Override
            public void run() {
                while (true){
                    if (Thread.currentThread().isInterrupted()){
                        log.debug("isInterrupted");
                        break;
                    }
                }
            }
        };
        thread.start();
        ThreadLg.sleep(1000l);
        thread.interrupt();
        log.debug("打断状态:{}", thread.isInterrupted());

    }
}
