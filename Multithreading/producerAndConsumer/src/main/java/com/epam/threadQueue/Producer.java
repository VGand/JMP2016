package com.epam.threadQueue;

/**
 * Created by Полина on 21.08.2016.
 */
public class Producer implements Runnable {
    private SynchronizedQueue synchronizedQueue;

    public Producer(SynchronizedQueue synchronizedQueue) {
        this.synchronizedQueue = synchronizedQueue;
    }

    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()) {
                Thread.sleep(1);
                synchronized (synchronizedQueue) {
                    String message = "Random message" + Math.random();
                    System.out.println("Random message = " + message);
                    synchronizedQueue.addMessage(message);
                    synchronizedQueue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
