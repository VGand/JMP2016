package com.epam.deadlock.fourlock;

/**
 * Created by Полина on 28.08.2016.
 */
public class FourDeadLock {
    public static  void startDeadLock() {
        final String r1 = "resource1";
        final String r2 = "resource2";
        final String r3 = "resource3";
        final String r4 = "resource4";

        Thread t1 = new Thread("t1") {
            public void run() {
                synchronized(r1){
                    System.out.println("Thread 1 Locked r1");
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e) {

                    }
                    synchronized(r2){
                        System.out.println("Thread 1 Locked r2");
                    }
                }
            }
        };

        Thread t2 = new Thread("t2"){
            public void run(){
                synchronized(r2){
                    System.out.println("Thread 2 Locked r2");
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e){

                    }
                    synchronized(r3){
                        System.out.println("Thread 2 Locked r3");
                    }
                }
            }
        };

        Thread t3 = new Thread("t3") {
            public void run() {
                synchronized(r3){
                    System.out.println("Thread 3 Locked r3");
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e) {

                    }
                    synchronized(r4){
                        System.out.println("Thread 3 Locked r4");
                    }
                }
            }
        };

        Thread t4 = new Thread("t4"){
            public void run(){
                synchronized(r4){
                    System.out.println("Thread 4 Locked r4");
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e){

                    }
                    synchronized(r1){
                        System.out.println("Thread 4 Locked r1");
                    }
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
