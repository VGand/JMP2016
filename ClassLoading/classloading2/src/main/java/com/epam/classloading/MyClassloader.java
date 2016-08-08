package com.epam.classloading;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Полина on 08.08.2016.
 */
public class MyClassloader extends ClassLoader {

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (name != null) {
            String[] classpathParts = name.split(Constants.DELIMITER);
            URL url;
            try {
                url = new URL("file:///" + classpathParts[0]);
                URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
                return urlClassLoader.loadClass(classpathParts[1]);
            } catch (MalformedURLException e) {
            }
        }

        return null;
    }
}
