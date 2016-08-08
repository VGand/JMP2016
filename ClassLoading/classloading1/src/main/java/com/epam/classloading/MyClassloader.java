package com.epam.classloading;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Полина on 08.08.2016.
 */
public class MyClassloader extends URLClassLoader {
    public MyClassloader(URL[] urls) {
        super(urls);
    }

    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
