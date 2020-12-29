package test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class TestFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.debug("running....");
                Thread.sleep(1000);
                return "t1";
            }
        });
        Thread thread = new Thread(task, "t1");
        thread.start();
        FutureTask<String> task2 = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.debug("running....");
                Thread.sleep(2000);
                return "t2";
            }
        });
        Thread thread2 = new Thread(task2, "t2");
        thread2.start();
        log.debug(task2.get());
        log.debug(task.get());//get方法需要该线程执行完成后才会执行

    }
}
