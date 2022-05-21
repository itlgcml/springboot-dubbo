package test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyFutureTask extends FutureTask implements Callable{
    public MyFutureTask(Callable callable) {
        super(callable);
    }


    public MyFutureTask(Runnable runnable, Object result) {
        super(runnable, result);
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
