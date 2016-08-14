package com.epam.proxy;

import java.util.Random;

/**
 * Created by Полина on 14.08.2016.
 */
public class MakeReportImpl implements MakeReporter {

    public String makePaymentReport(String paymentNumber) {
        return "This is super payment report № " + paymentNumber;
    }

    public String makePurchasingReport(String purchasingNumber) {
        return "This is super purchasing report № " + purchasingNumber;
    }
}
