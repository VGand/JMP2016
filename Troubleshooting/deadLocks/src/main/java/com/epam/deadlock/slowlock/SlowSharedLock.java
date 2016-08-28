package com.epam.deadlock.slowlock;

/**
 * Created by Полина on 28.08.2016.
 */
public class SlowSharedLock {
    public static  void startDeadLock() {
        final String r1 = "resource1";

        Thread t1 = new Thread("t1") {
            public void run() {
                synchronized(r1){
                    System.out.println("Thread 1 Locked r1");
                    try {
                        //very slow
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {

                    }
                }
            }
        };

        Thread t2 = new Thread("t2"){
            public void run(){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                synchronized(r1){
                    System.out.println("Thread 2 Locked r1");

                }
            }
        };

        Thread t3 = new Thread("t3"){
            public void run(){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                synchronized(r1){
                    System.out.println("Thread 3 Locked r1");

                }
            }
        };

        Thread t4 = new Thread("t4"){
            public void run(){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                synchronized(r1){
                    System.out.println("Thread 4 Locked r1");

                }
            }
        };

        Thread t5 = new Thread("t5"){
            public void run(){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                synchronized(r1){
                    System.out.println("Thread 5 Locked r1");

                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
