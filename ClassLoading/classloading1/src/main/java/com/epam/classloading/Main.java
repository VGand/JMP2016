package com.epam.classloading;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Полина on 08.08.2016.
 */
public class Main {

    public static void main (String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        URL redSemaphoreUrl = new URL("file:///D:/workspace/classloading1/");

        URL[] urls = {redSemaphoreUrl};

        MyClassloader myClassloader = new MyClassloader(urls);

        Semaphore semaphore = (Semaphore) myClassloader.loadClass("RedSemaphore").newInstance();

        System.out.println(semaphore.getLight());
    }
}
