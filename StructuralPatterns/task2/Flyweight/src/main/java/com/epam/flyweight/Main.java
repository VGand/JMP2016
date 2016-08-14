package com.epam.flyweight;

/**
 * Created by Полина on 14.08.2016.
 */
public class Main {
    /*
        Задача, рисование шахматных фигур на доске
     */

    public static void main(String[] args) {
        drawChessBoard();
    }

    private static void drawChessBoard() {
        FlyweightChessFactory.getInstance("ладья").drawChessFigure("1","A","white");
        FlyweightChessFactory.getInstance("ладья").drawChessFigure("1","H","white");

        FlyweightChessFactory.getInstance("конь").drawChessFigure("1","B","white");
        FlyweightChessFactory.getInstance("конь").drawChessFigure("1","G","white");

        FlyweightChessFactory.getInstance("слон").drawChessFigure("1","C","white");
        FlyweightChessFactory.getInstance("слон").drawChessFigure("1","F","white");

        FlyweightChessFactory.getInstance("король").drawChessFigure("1","E","white");
        FlyweightChessFactory.getInstance("ферзь").drawChessFigure("1","D","white");

        FlyweightChessFactory.getInstance("пешка").drawChessFigure("2","A","white");
        FlyweightChessFactory.getInstance("пешка").drawChessFigure("2","B","white");
        FlyweightChessFactory.getInstance("пешка").drawChessFigure("2","C","white");
        FlyweightChessFactory.getInstance("пешка").drawChessFigure("2","D","white");
        FlyweightChessFactory.getInstance("пешка").drawChessFigure("2","E","white");
        FlyweightChessFactory.getInstance("пешка").drawChessFigure("2","F","white");
        FlyweightChessFactory.getInstance("пешка").drawChessFigure("2","G","white");
        FlyweightChessFactory.getInstance("пешка").drawChessFigure("2","H","white");
    }
}
