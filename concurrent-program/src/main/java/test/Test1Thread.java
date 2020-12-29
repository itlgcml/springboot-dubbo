package test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test1")
public class Test1Thread {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run(){
                ThreadLg.sleep(1000l);
                log.debug("running1");
            }
        };
        t.setName("run2");//设置线程名词
        t.start();//启动线程
        log.debug("running2");
    }
}
