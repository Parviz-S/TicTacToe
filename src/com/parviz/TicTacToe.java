package com.parviz;
import java.util.Random;


public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};

        printBoard(board);

        while (true) {
            playerTurn(board);
            if (isGameFinished(board)){
                break;
            }
            printBoard(board);

            ComputerTurn.normalMove(board);
            if (isGameFinished(board)){
                break;
            }
            printBoard(board);
        }
    }


    private static boolean isGameFinished(char[][] board) {

        if (hasContestantWon(board, 'X')) {
            printBoard(board);
            StdOut.println("Player wins!");
            return true;
        }

        if (hasContestantWon(board, 'O')) {
            printBoard(board);
            StdOut.println("Computer wins!");
            return true;
        }

        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        StdOut.println("The game ended in a tie!");
        return true;
    }


    private static boolean hasContestantWon(char[][] board, char symbol) {
        return (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }


    static boolean isValidMove(char[][] board, String position) {
        return switch (position) {
            case "1" -> (board[0][0] == ' ');
            case "2" -> (board[0][1] == ' ');
            case "3" -> (board[0][2] == ' ');
            case "4" -> (board[1][0] == ' ');
            case "5" -> (board[1][1] == ' ');
            case "6" -> (board[1][2] == ' ');
            case "7" -> (board[2][0] == ' ');
            case "8" -> (board[2][1] == ' ');
            case "9" -> (board[2][2] == ' ');
            default -> false;
        };
    }

    private static void playerTurn(char[][] board) {
        String userInput;
        while (true) {
            StdOut.println("Where would you like to play? (1-9)");
            userInput = StdIn.readString();
            if (isValidMove(board, userInput)){
                break;
            } else {
                StdOut.println(userInput + " is not a valid move.");
            }
        }
        placeMove(board, userInput, 'X');
    }


    static void placeMove(char[][] board, String position, char symbol) {
        switch (position) {
            case "1" -> board[0][0] = symbol;
            case "2" -> board[0][1] = symbol;
            case "3" -> board[0][2] = symbol;
            case "4" -> board[1][0] = symbol;
            case "5" -> board[1][1] = symbol;
            case "6" -> board[1][2] = symbol;
            case "7" -> board[2][0] = symbol;
            case "8" -> board[2][1] = symbol;
            case "9" -> board[2][2] = symbol;
        }
    }




    private static void printBoard(char[][] board) {
        StdOut.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
        StdOut.println("-+-+-");
        StdOut.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
        StdOut.println("-+-+-");
        StdOut.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
    }

}
