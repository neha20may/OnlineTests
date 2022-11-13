package multithreading.prod_con;

public class Consumer extends Thread {
    MyBlockingQueue queue;


    public Consumer(String name, MyBlockingQueue queue) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
//            int x = (int) queue.get();
            int x = (int) queue.getSync();
            System.out.println(currentThread().getName() + " removed item " + x +" size "+queue.getSize());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
