package com.epam.proxy;

/**
 * Created by Полина on 14.08.2016.
 */
public class MakeReportProxy implements MakeReporter {

    private MakeReporter makeReporter;

    public MakeReportProxy(MakeReporter makeReporter) {
        this.makeReporter = makeReporter;
    }

    public String makePaymentReport(String paymentNumber) {
        System.out.println("Start making payment report by number №" + paymentNumber);
        return makeReporter.makePaymentReport(paymentNumber);
    }

    public String makePurchasingReport(String purchasingNumber) {
        System.out.println("Start making purchasing report by number №" + purchasingNumber);
        return makeReporter.makePurchasingReport(purchasingNumber);
    }
}
