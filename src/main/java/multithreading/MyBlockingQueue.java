package multithreading;

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
            if (queue.size() == 0) {
                empty.await();
            }
            E item = queue.remove();
            full.signalAll();
            return item;
        } catch (InterruptedException e) {
            String name = Thread.currentThread().getName();
            System.out.println("Thread " + name + "got interrupted");

        }
        catch (Exception e){
            System.out.println(e + "by" + Thread.currentThread().getName()+" in getting item");

        } finally
        {
            lock.unlock();
        }
        return null;
    }

    void put(E item) {
        lock.lock();
//        System.out.println("acquired loack");
        try {
            if (queue.size() == max) {
                full.await();
            }
            queue.add(item);
            empty.signalAll();
        } catch (InterruptedException e) {
            String name = Thread.currentThread().getName();
            System.out.println("Thread " + name + "got interrupted");

        } finally {
//            System.out.println("realeasing loack");
            lock.unlock();
//            System.out.println("realeased");
        }

    }
}
