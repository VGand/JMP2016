package com.epam.bookticket;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Полина on 31.08.2016.
 */
public class MainBookTicket {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "SpringConfig.xml");


    }
}
