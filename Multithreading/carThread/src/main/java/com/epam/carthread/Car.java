package com.epam.carthread;

import java.util.logging.Logger;

/**
 * Created by Полина on 21.08.2016.
 */
public class Car implements Runnable {

    private static final long MAX_DISTANCE = 10000;
    Logger log = Logger.getLogger("CarLogger");

    private long friction;
    private long distance;

    private String name;



    public Car(String name, long friction) {
        this.name = name;
        this.friction = friction;
    }

    public void run() {
        try {
            while (distance < MAX_DISTANCE && !Thread.currentThread().isInterrupted()) {
                Thread.sleep(friction);
                distance += 100;
                log.info(name + " " + distance);
            }
            if (Thread.currentThread().isInterrupted()) {
                log.info(name + " was disqualified");
            } else {
                FinishLine.finishing(name);
            }
        } catch (InterruptedException e) {
            log.warning(e.getMessage());
            log.info(name + " was disqualified");
        }
    }
}
