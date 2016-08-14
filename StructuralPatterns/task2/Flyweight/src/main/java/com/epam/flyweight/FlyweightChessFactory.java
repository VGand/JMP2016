package com.epam.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Полина on 14.08.2016.
 */
public class FlyweightChessFactory {

    private static Map<String, ChessFigure> figureMap = new HashMap<String, ChessFigure>();

    public static ChessFigure getInstance(String figureName) {
        if (figureMap.containsKey(figureName)) {
            return figureMap.get(figureName);
        } else {
            ChessFigure chessFigure = new ConcreteFigure(figureName);
            figureMap.put(figureName, chessFigure);
            return chessFigure;
        }
    }
}
