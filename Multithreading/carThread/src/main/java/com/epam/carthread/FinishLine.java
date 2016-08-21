package com.epam.carthread;

/**
 * Created by Полина on 21.08.2016.
 */
public class FinishLine {
    private static String winnerName = null;

    public static synchronized void finishing(String name) {
        if (winnerName == null) {
            winnerName = name;
        }
    }

    public static String getWinner() {
        return winnerName;
    }
}
