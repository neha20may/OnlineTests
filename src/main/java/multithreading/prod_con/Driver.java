package multithreading.prod_con;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue(3); //>>>> This my dear is the shared variable,
        // and it knows its shared hence it implements its method as synchronized
        Thread p = new Thread(new Producer("p1", queue)); // >>>>> implements Runnable ,
        // and then you create a thread manually.
        Consumer c = new Consumer("c1", queue); //>>>>> directly extends thread so
        Consumer c2 = new Consumer("c2", queue);
        // creating object of class is equivalent to new Thread.
//        c.start();
//        c2.start();
//        p.start();
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            threadPool.execute(new Producer("p" + finalI, queue));
        }
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            threadPool.execute(() -> {
                new Consumer("c" + finalI, queue).start();
            });
        }

    }
}
