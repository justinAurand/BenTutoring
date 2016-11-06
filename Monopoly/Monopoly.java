/*
    * CSCI 111 Fall 2013
    * Edited November 2, 2013 by C. Herbert
    * This is for teaching purposes only.
    * Monopoly and the names and images used in Monopoly are
    * registered trademarks of Parker Brothers, Hasbro, and others.
*/

import java.io.IOException;
import java.util.*;

public class Monopoly {
    static final int NUMBER_OF_SQUARES = 40;

    public static void main(String[] args) throws Exception {
        BoardSquare[] squares = new BoardSquare[NUMBER_OF_SQUARES];
        loadSquares(squares);

        System.out.println("--== Monopoly Board Squares==--");
        System.out.println("NAME, TYPE, RENT, PRICE, COLOR");
        for (int i=0; i<NUMBER_OF_SQUARES; i++)
            System.out.println(squares[i].toString());

        for (int i=0; i<20; i++)
            System.out.println(rollDice(2));

        Player player = new Player("Justin", "Iron", 0, 1500);
        while (player.getBalance() > 0)
            takeTurn(player, squares);
    }

    private static void displayStatus(Player player, BoardSquare[] squares, int roll, int rent) {
        int location = player.getLocation();
        BoardSquare square = squares[location];
        String squareName = square.getName();

        System.out.println(player.toString());
        System.out.println("Roll: " + Integer.toString(roll));
        System.out.println("Current square: " + squareName);
        if (rent > 0)
            System.out.println("Rent paid: " + Integer.toString(rent));
    }

    private static void loadSquares(BoardSquare[] squares) throws Exception {
        String name, type, color;
        int price, rent;

        java.io.File file = new java.io.File("squares.txt");
        Scanner scan = new Scanner(file);
        for (int i=0; i<NUMBER_OF_SQUARES; i++) {
            name  = scan.nextLine();
            type  = scan.nextLine();
            price = Integer.parseInt(scan.nextLine());
            rent  = Integer.parseInt(scan.nextLine());
            color = scan.nextLine();
            squares[i] = new BoardSquare(name, type, price, rent, color);
        }
        scan.close();
    }

    private static int movePlayer(Player player) {
        int currentLocation = player.getLocation();
        int roll = rollDice(2);
        int newLocation = currentLocation + roll;

        if (newLocation > (NUMBER_OF_SQUARES-1))
            newLocation = newLocation - NUMBER_OF_SQUARES;

        player.setLocation(newLocation);
        return roll;
    }

    private static int payRent(Player player, BoardSquare[] squares) {
        int location = player.getLocation();
        BoardSquare square = squares[location];
        int rent = square.getRent();

        int currentBalance = player.getBalance();
        int newBalance = currentBalance - rent;
        player.setBalance(newBalance);

        return rent;
    }

    private static void requireInput() {
        System.out.println("press enter to continue");
        try {
            System.in.read();
        } catch (IOException ex) { }
        System.out.println("");
    }

    private static int rollDice(int dice) {
        if (dice < 1)
            return 0;

        int sum = 0;
        for (int i=0; i<dice; i++)
            sum += rollDie();
        return sum;
    }

    private static int rollDie() {
        return (int)(Math.random()*6+1);
    }

    private static void takeTurn(Player player, BoardSquare[] squares) {
        int roll = movePlayer(player);
        int rent = payRent(player, squares);
        displayStatus(player, squares, roll, rent);
        requireInput();
    }
}
