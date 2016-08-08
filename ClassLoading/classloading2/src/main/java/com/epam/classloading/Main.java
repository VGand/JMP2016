package com.epam.classloading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Полина on 08.08.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        MyClassloader classloader = new MyClassloader();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("Enter classpath:");
            String classpath = br.readLine() + Constants.DELIMITER + Constants.CLASS_NAME;

            try {
                Semaphore semaphore = (Semaphore)classloader.loadClass(classpath).newInstance();
                System.out.println("Class was load. Result: " + semaphore.getLight());
            } catch (ClassNotFoundException e) {
                System.out.println("Error ocourres while trying to load class from classpath:" + classpath);
            } catch (InstantiationException e) {
                System.out.println("Error ocourres while trying to get new instance class from classpath:" + classpath);
            } catch (IllegalAccessException e) {
                System.out.println("Error ocourres while trying to get new instance class from classpath:" + classpath);
            }
        }
    }
}
