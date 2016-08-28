package com.epam.deadlock.realistic;

/**
 * Created by Полина on 28.08.2016.
 */
public class RealisticDeadLock {

    public static  void startDeadLock() {
        final String r1 = "resource1";
        final String r2 = "resource2";

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

        Thread t11 = new Thread("t11"){
            public void run(){
                try{
                    Thread.sleep(200);
                } catch (InterruptedException e){

                }
                synchronized(r1){
                    System.out.println("Thread 11 Locked r1");

                }
            }
        };

        Thread t12 = new Thread("t12"){
            public void run(){
                try{
                    Thread.sleep(200);
                } catch (InterruptedException e){

                }
                synchronized(r1){
                    System.out.println("Thread 12 Locked r1");

                }
            }
        };

        Thread t13 = new Thread("t13"){
            public void run(){
                try{
                    Thread.sleep(200);
                } catch (InterruptedException e){

                }
                synchronized(r1){
                    System.out.println("Thread 13 Locked r1");

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
                    synchronized(r1){
                        System.out.println("Thread 2 Locked r1");
                    }
                }
            }
        };


        Thread t21 = new Thread("t21"){
            public void run(){
                try{
                    Thread.sleep(200);
                } catch (InterruptedException e){

                }
                synchronized(r2){
                    System.out.println("Thread 21 Locked r2");

                }
            }
        };

        Thread t22 = new Thread("t22"){
            public void run(){
                try{
                    Thread.sleep(200);
                } catch (InterruptedException e){

                }
                synchronized(r2){
                    System.out.println("Thread 22 Locked r2");

                }
            }
        };

        Thread t23 = new Thread("t23"){
            public void run(){
                try{
                    Thread.sleep(200);
                } catch (InterruptedException e){

                }
                synchronized(r2){
                    System.out.println("Thread 23 Locked r2");

                }
            }
        };

        t1.start();
        t11.start();
        t12.start();
        t13.start();

        t2.start();
        t21.start();
        t22.start();
        t23.start();
    }
}
