package com.epam.deadlock;

import com.epam.deadlock.fourlock.FourDeadLock;
import com.epam.deadlock.realistic.RealisticDeadLock;
import com.epam.deadlock.simple.SimpleDeadLock;
import com.epam.deadlock.slowlock.SlowSharedLock;

/**
 * Created by Полина on 28.08.2016.
 */
public class Main {

    public static void main(String[] args) {
        SimpleDeadLock.startDeadLock();
        RealisticDeadLock.startDeadLock();
        FourDeadLock.startDeadLock();
        SlowSharedLock.startDeadLock();
    }
}
