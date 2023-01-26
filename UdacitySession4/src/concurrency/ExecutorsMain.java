package concurrency;

import java.util.concurrent.*;

public class ExecutorsMain {

    static CountDownLatch countDownLatch = new CountDownLatch(3);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(12);

        // submits runnable with no return value
        Future<?> print = pool.submit(() -> {
            System.out.println("random");
            countDownLatch.countDown();
        });

        pool.execute(() -> {
            System.out.println("no return with execute");
            countDownLatch.countDown();
        });

        Future<String> randoStr = pool.submit(() -> downloadFile());

        // causes code to wait until countdown latch reaches 0. meaning all threads have completed
        countDownLatch.await();
        System.out.println(randoStr.get());
        pool.close();
    }

    public static String downloadFile(){
        // do some downloading stuff
        countDownLatch.countDown();
        return "downloaded file thing";
    }
}
