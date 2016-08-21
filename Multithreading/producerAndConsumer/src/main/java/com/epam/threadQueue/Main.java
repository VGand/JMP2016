package com.epam.threadQueue;

/**
 * Created by Полина on 21.08.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedQueue synchronizedQueue = new SynchronizedQueue();

        Producer producer = new Producer(synchronizedQueue);
        Consumer consumer = new Consumer(synchronizedQueue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        Thread.sleep(10);

        producerThread.interrupt();
        consumerThread.interrupt();
    }
}
