package test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestTwoInterrupt {
    public static void main(String[] args) throws InterruptedException {
        ConCurrent conCurrent = new ConCurrent();
        conCurrent.start();
        Thread.sleep(2000l);
        conCurrent.stop();
    }
}

@Slf4j
class ConCurrent {
    private Thread thread;

    public void start() {
        thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    Thread t = Thread.currentThread();
                    boolean bool = t.isInterrupted();
                    if (bool) {
                        log.debug("料理后事");
                        break;
                    }
                    try {
                        //执行监控记录
                        log.debug("执行监控记录");//1
                        Thread.sleep(1000l);//2
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        //重新设置打断标记
                        t.interrupt();
                    }
                }
            }
        };
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }
}
