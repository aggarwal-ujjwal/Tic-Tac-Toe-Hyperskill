package tictactoe;

import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        // write your code here
        //Tic-Tac-Toe
        String input = userInput();
        printGrid(input);
        gameState(input);
    }

    private static void gameState(String input) {

        HashMap<Character, Integer> charCountMap
                = new HashMap<Character, Integer>();

        char[] strArray = input.toCharArray();

        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
            else {
                charCountMap.put(c, 1);
            }
        }

        int numOfX = charCountMap.get('X') ;
        int numOfO = charCountMap.get('O');
        
        boolean xWin = false;
        boolean oWin = false;
        //if X wins
        if ((input.charAt(0)=='X' && input.charAt(1)=='X' && input.charAt(2)=='X')
        || (input.charAt(3)=='X' && input.charAt(4)=='X' && input.charAt(5)=='X')
        || (input.charAt(6)=='X' && input.charAt(7)=='X' && input.charAt(8)=='X')
        || (input.charAt(0)=='X' && input.charAt(4)=='X' && input.charAt(8)=='X')
        || (input.charAt(6)=='X' && input.charAt(4)=='X' && input.charAt(2)=='X')
        || (input.charAt(0)=='X' && input.charAt(3)=='X' && input.charAt(6)=='X')
        || (input.charAt(1)=='X' && input.charAt(4)=='X' && input.charAt(7)=='X')
        || (input.charAt(2)=='X' && input.charAt(5)=='X' && input.charAt(8)=='X')){
            xWin = true;
        }

        if ((input.charAt(0)=='O' && input.charAt(1)=='O' && input.charAt(2)=='O')
                || (input.charAt(3)=='O' && input.charAt(4)=='O' && input.charAt(5)=='O')
                || (input.charAt(6)=='O' && input.charAt(7)=='O' && input.charAt(8)=='O')
                || (input.charAt(0)=='O' && input.charAt(4)=='O' && input.charAt(8)=='O')
                || (input.charAt(6)=='O' && input.charAt(4)=='O' && input.charAt(2)=='O')
                || (input.charAt(0)=='O' && input.charAt(3)=='O' && input.charAt(6)=='O')
                || (input.charAt(1)=='O' && input.charAt(4)=='O' && input.charAt(7)=='O')
                || (input.charAt(2)=='O' && input.charAt(5)=='O' && input.charAt(8)=='O')){
            oWin = true;
        }

        if (xWin && oWin) {
            System.out.println("Impossible");
            return;
        } else if (xWin) {
            System.out.println("X wins");
            return;
        } else if (oWin) {
            System.out.println("O wins");
            return;
        }

        if(abs(numOfO-numOfX)>=2) {
            System.out.println("Impossible");
            return;
        }

        if(numOfX+numOfO<9) {
            System.out.println("Game not finished");
            return;
        } else if (numOfX+numOfO==9) {
            System.out.println("Draw");
            return;
        }




    }

    private static void printGrid(String input) {
        System.out.println("---------");
        System.out.printf("| %c %c %c |\n" +
                           "| %c %c %c |\n" +
                           "| %c %c %c |\n",
                            input.charAt(0),input.charAt(1),input.charAt(2),
                            input.charAt(3),input.charAt(4),input.charAt(5),
                            input.charAt(6),input.charAt(7),input.charAt(8));
        System.out.println("---------");
    }

    public static String userInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}
