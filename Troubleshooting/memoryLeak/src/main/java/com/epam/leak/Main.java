package com.epam.leak;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Полина on 28.08.2016.
 */
public class Main {
    public static final String FILE_NAME = "src/main/file.txt";

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(FILE_NAME));
            /* //before
            //Все дело в substring в ранних версиях java строит подстроку но сохраняет ссылку
            //на весь массив символов. И мы вытоге выгружаем все содержимое файла в память
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                list.add(line.substring(0,3));
            }*/

            //after
            while (scanner.hasNextLine()){
                String charCode = scanner.findInLine("^([A-Za-z][A-Za-z][A-Za-z])");
                scanner.nextLine();
                list.add(charCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        System.out.println("File was read!!!");

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
