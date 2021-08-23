package me.ele.download.util;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

public class ExecutorServiceUtil {


    public static final ExecutorService ORDER_EXPORT_EXECUTOR = new ThreadPoolExecutor(
            2,
            2,
            1000L,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(10),
            new ThreadPoolExecutor.AbortPolicy());
}
