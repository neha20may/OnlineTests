/**
 * Illegal monitor state exception;
 * Concepts: Monitor, if/while, wait notify, synchronize, lock, condition
 */
class Printer{
    int start=1;
    int end= 10;
    public void printEven() {
        synchronized (this) {
            while (start < end) {
                while (start % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("Thread " + Thread.currentThread().getName() + "  got interrupted at " + System.currentTimeMillis());
                    }
                }
                System.out.println("Thread " + Thread.currentThread() + " printing :: " + start++);
                notify();
            }
        }
    }
    public void printOdd(){
        synchronized (this) {
            while (start < end) {
                while (start % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("Thread " + Thread.currentThread().getName() + "  got interrupted at " + System.currentTimeMillis());
                    }
                }
                System.out.println("Thread " + Thread.currentThread() + " printing :: " + start++);
                notify();
            }
        }
    }
}
public class driver {
    public static void main(String [] args) {

        Thread t1;
        Thread t2;
        Printer pob= new Printer();
        t1 = new Thread(new Runnable(){
            public void run(){
                pob.printOdd();
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                pob.printEven();
            }
        });
        t1.start();
        t2.start();

    }

}
