package com.epam.filedirectoryinfo;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by Полина on 21.08.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter directory path...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();

        File file = new File(filePath);
        FileDirectoryInfo fileDirectoryInfo = new ForkJoinPool().invoke(new DirectoryReader(file));

        System.out.println("Directory count = " + fileDirectoryInfo.getDirectoryCount());
        System.out.println("File count = " + fileDirectoryInfo.getFileCount());
        System.out.println("File size(bytes) = " + fileDirectoryInfo.getFileSizes());
    }
}
