package com.epam.carthread;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Полина on 21.08.2016.
 */
public class CarMain {
    static Logger log = Logger.getLogger("CarLogger");

    public static void main(String[] args) throws InterruptedException {
        List<Car> carList = new ArrayList<Car>();

        Car car = new Car("car1", 100);
        carList.add(car);
        car = new Car("car2", 101);
        carList.add(car);
        car = new Car("car3", 99);
        carList.add(car);
        car = new Car("car4", 102);
        carList.add(car);

        List<Thread> threadList = new ArrayList<Thread>();
        for(Car carObj : carList) {
            Thread carThread = new Thread(carObj);
            threadList.add(carThread);
            carThread.start();
        }

        int randomDisqualify = (int)(Math.random() * threadList.size());
        threadList.get(randomDisqualify).interrupt();

        for(int i = 0; i < threadList.size(); i++) {
            if (i != randomDisqualify) {
                threadList.get(i).join();
            }
        }
        log.info(FinishLine.getWinner() + " is Winner!!!");
    }
}
