/*
    * CSCI 111 Fall 2013
    * Edited November 2, 2013 by C. Herbert
    * This is for teaching purposes only.
    * Monopoly and the names and images used in Monopoly are
    * registered trademarks of Parker Brothers, Hasbro, and others.
*/

import java.util.*;

public class Monopoly {
    public static void main(String[] args) throws Exception {
        BoardSquare[] squares = new BoardSquare[40];
        loadSquares(squares);

        System.out.println("--== Monopoly Board Squares==--");
        System.out.println("NAME, TYPE, RENT, PRICE, COLOR");
        for(int i=0; i<40; i++)
            System.out.println(squares[i].toString());
    }

    public static void loadSquares(BoardSquare[] squares) throws Exception {
        String name, type, color;
        int price, rent;

        java.io.File squaresFile = new java.io.File("squares.txt");
        Scanner squaresScanner = new Scanner(squaresFile);
        for(int i=0; i<40; i++) {
            name  = squaresScanner.nextLine();
            type  = squaresScanner.nextLine();
            price = Integer.parseInt(squaresScanner.nextLine());
            rent  = Integer.parseInt(squaresScanner.nextLine());
            color = squaresScanner.nextLine();
            squares[i] = new BoardSquare(name, type, price, rent, color);
        }
        squaresScanner.close();
    }
}
