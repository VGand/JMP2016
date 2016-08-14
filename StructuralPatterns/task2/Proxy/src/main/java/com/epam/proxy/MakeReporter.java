package com.epam.proxy;

/**
 * Created by Полина on 14.08.2016.
 */
public interface MakeReporter {

    String makePaymentReport(String paymentNumber);

    String makePurchasingReport(String purchasingNumber);
}
