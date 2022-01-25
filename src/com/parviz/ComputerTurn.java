package com.parviz;
import java.util.Random;

public class ComputerTurn {
    public static void main(String[] args) {
    }
    public static void normalMove(char[][] board) {
        Random rand = new Random();
        int computerMove;
        do {
            computerMove = rand.nextInt(9) + 1;
        } while (!TicTacToe.isValidMove(board, Integer.toString(computerMove)));
        StdOut.println("Computer chose " + computerMove);
        TicTacToe.placeMove(board, Integer.toString(computerMove), 'O');
    }
}
