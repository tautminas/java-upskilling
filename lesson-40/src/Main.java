public class Main {

    /*
     1. Thread challenge
     Your task is to create two threads.
     You should make one thread subclass the java.lang.Thread class.
     The other should be created using a Runnable, which you can pass to the Thread constructor.   This can be any class that implements Runnable, or a lambda expression.
     Each thread should have a run method. The first thread's code should print 5 even numbers, and the second thread should print 5 odd numbers.
     You should execute them asynchronously, calling the start method on each, in two consecutive statements, in your main code.
     Have your main method, after these threads run a few seconds, interrupt one or both threads.
    */

    public static void main(String[] args) throws InterruptedException {

        EvenThread evenThread = new EvenThread();

        Thread oddThread = new Thread(new OddRunnable());

        evenThread.start();
        oddThread.start();

        Thread.sleep(3000);

        evenThread.interrupt();
        oddThread.interrupt();

        System.out.println("Main thread finished.");
    }
}

class EvenThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i += 2) {
            if (isInterrupted()) {
                System.out.println("Even thread interrupted.");
                return;
            }

            System.out.println("Even: " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Even thread interrupted during sleep.");
                return;
            }
        }
    }
}

class OddRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 10; i += 2) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Odd thread interrupted.");
                return;
            }

            System.out.println("Odd: " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Odd thread interrupted during sleep.");
                return;
            }
        }
    }
}
