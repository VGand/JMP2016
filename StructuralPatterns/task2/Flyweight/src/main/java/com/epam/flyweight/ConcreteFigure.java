package com.epam.flyweight;

/**
 * Created by Полина on 14.08.2016.
 */
public class ConcreteFigure implements ChessFigure {
    private String figureName;

    public ConcreteFigure(String figureName) {
        this.figureName = figureName;
    }

    public void drawChessFigure(String x, String y, String color) {
        StringBuilder sb = new StringBuilder();
        sb.append("Draw ").append(color).append(" ").append(figureName).append(" in position ").append(x).append(" ").append(y);
        System.out.println(sb.toString());
    }
}
