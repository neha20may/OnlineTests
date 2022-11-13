package multithreading.prod_con;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {
    private Queue<E> queue;
    private int max = 0;
    public ReentrantLock lock = new ReentrantLock();
    public Condition full = lock.newCondition();
    public Condition empty = lock.newCondition();

    public MyBlockingQueue(int max) {
        this.queue = new LinkedList<E>();
        this.max = max;
    }

    E get() {
        lock.lock();
        try {
            while (queue.size() == 0) {
                empty.await();
            }
            E item = queue.remove();
            full.signalAll();
            return item;
        } catch (InterruptedException e) {
            String name = Thread.currentThread().getName();
            System.out.println("Thread " + name + "got interrupted");

        } catch (Exception e) {
            System.out.println(e + "by" + Thread.currentThread().getName() + " in getting item;");

        } finally {
            lock.unlock();
        }
        return null;
    }

    E getSync() {
        synchronized (queue) {
            try {
                while (queue.size() == 0) {
                    queue.wait();
                }
                E item = queue.remove();
//                full.signalAll();
                queue.notifyAll();
                return item;
            } catch (InterruptedException e) {
                String name = Thread.currentThread().getName();
                System.out.println("Thread " + name + "got interrupted");

            } catch (Exception e) {
                System.out.println(e + "by" + Thread.currentThread().getName() + " in getting item;");
            }
        }
        return null;
    }

    void put(E item) {
        lock.lock();
        try {
            while (queue.size() == max) {
                full.await();
            }
            queue.add(item);
            empty.signalAll();
        } catch (InterruptedException e) {
            String name = Thread.currentThread().getName();
            System.out.println("Thread " + name + "got interrupted");
        } finally {
            lock.unlock();
        }
    }

    void putSync(E item) {
        synchronized (queue) {
            try {
                while (queue.size() == max) {
                    queue.wait();
                }
                queue.add(item);
//                empty.signalAll();
                queue.notifyAll();
            } catch (InterruptedException e) {
                String name = Thread.currentThread().getName();
                System.out.println("Thread " + name + "got interrupted");
            }
        }

    }

    int getSize(){
        synchronized (queue){
            return queue.size();
        }
    }

}
