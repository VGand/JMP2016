package com.epam.proxy;

/**
 * Created by Полина on 14.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        MakeReporter makeReporter = new MakeReportProxy(new MakeReportImpl());

        String paymentReport = makeReporter.makePaymentReport("123");
        System.out.println(paymentReport);
        String purchasingReport = makeReporter.makePurchasingReport("321");
        System.out.println(purchasingReport);
    }
}
