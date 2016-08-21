package com.epam.threadQueue;

/**
 * Created by Полина on 21.08.2016.
 */
public class Consumer implements Runnable {
    private SynchronizedQueue synchronizedQueue;

    public Consumer(SynchronizedQueue synchronizedQueue) {
        this.synchronizedQueue = synchronizedQueue;
    }

    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            if (synchronizedQueue.isEmpty()) {
                synchronized (synchronizedQueue) {
                    try {
                        synchronizedQueue.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            synchronized (synchronizedQueue) {
                String message = synchronizedQueue.getMessage();
                System.out.println("Get message " + message);
            }
        }
    }
}
