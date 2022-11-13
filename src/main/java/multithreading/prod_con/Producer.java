package multithreading.prod_con;

public class Producer implements Runnable {
    MyBlockingQueue queue;


    public Producer(String name, MyBlockingQueue queue) {
//        super(name); // !! not needed in implements Runnable
        this.queue = queue; //constructor initialization of shared stuff!
    }

    @Override
    public void run() {
        while (true) {
//            queue.put(100);
            queue.putSync(100);
            System.out.println(Thread.currentThread().getName() + " put item " + 100+ "queue size "+queue.getSize());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
