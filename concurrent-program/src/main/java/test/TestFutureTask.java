package test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 有返回值的创建多线程
 */
@Slf4j
@Data
public class TestFutureTask {
    public static void main(String[] args) {
        Vector<FutureTask<String>> futureTaskList = new Vector<>();
        for (int i = 0; i < 6; i++) {

            FutureTask<String> task = new FutureTask(() -> {
                log.debug("running....");
                Thread.sleep(1000);
                return "0";
            });
            Thread thread = new Thread(task, "t1");
            thread.start();
            futureTaskList.add(task);
        }
        futureTaskList.forEach(e -> {
            try {
                String s = e.get();
                System.out.println(s);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } catch (ExecutionException executionException) {
                executionException.printStackTrace();
            }
        });
        log.debug("main....");

    }
}
