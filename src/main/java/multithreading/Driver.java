package multithreading;

class Producer extends Thread {
    MyBlockingQueue queue;


    public Producer(String name, MyBlockingQueue queue) {
        super(name);
        this.queue = queue;

    }

    @Override
    public void run() {
        while (true) {
            queue.put(100);
            System.out.println(currentThread().getName() + " put item " + 100);
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer extends Thread {
    MyBlockingQueue queue;


    public Consumer(String name, MyBlockingQueue queue) {
        super(name);

        this.queue = queue;

    }

    @Override
    public void run() {
        while (true) {
            int x = (int) queue.get();
            System.out.println(currentThread().getName() + " removed item " + x);
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Driver {


    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue(1);
        Producer p = new Producer("p1", queue);
        Consumer c = new Consumer("c1", queue);

        p.start();

        c.start();


    }
}
