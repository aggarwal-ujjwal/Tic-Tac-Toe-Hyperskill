package tictactoe;

import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //Tic-Tac-Toe
         HashMap<Character, Integer> charCountMap
                = new HashMap<Character, Integer>();
        String input = userInput();
        printGrid(input);
        userMakeMove(input, charCountMap);
       // gameState(input);
    }

    private static void userMakeMove(String input, HashMap<Character, Integer> charCountMap) {
        Scanner scanner = new Scanner(System.in);
            int a = 0,b =0;
//        System.out.println("x = " + x);
//        System.out.println("y = " + y);
        boolean validInput = false;
        while (!validInput) {
            try {
                String line = scanner.nextLine();
                //Imp line
                //int num = Integer.parseInt(line.replaceAll("[\\D]", ""));
                String[] parts = line.split(" ");
                a = Integer.parseInt(parts[0]);
                b = Integer.parseInt(parts[1]);
                if((a>3 || a<=0) || b>3 || b<=0) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                int index = decideIndex(a,b);
                if(input.charAt(index)=='X' || input.charAt(index)=='O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;

                }
                validInput = true;
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
//                scanner.nextLine(); // clear the invalid input from the scanner buffer
            }
        }


        int index = decideIndex(a,b); // index of the character to be changed
        String numOfOYString = numOfOX(input, charCountMap);
        String[] parts = numOfOYString.split(" ");
        int numOfO = parts[0]==null?0:Integer.parseInt(parts[0]);
        int numOfX = parts[1]==null?0:Integer.parseInt(parts[1]);
        char newChar;
        if(numOfX>numOfO)
            newChar = 'O';
        else
            newChar = 'X';
        String newStr = input.substring(0, index) + newChar + input.substring(index+1);
        printGrid(newStr);
    }

    public static int decideIndex(int a, int b) {
        int index = 0;
        if(a==1){
            index = b-1;
        } else if (a==2) {
            index = b+2 ;
        } else {
            index = b+5;
        }
        return index;
    }
    public static String numOfOX(String input, HashMap<Character, Integer> charCountMap){
        char[] strArray = input.toCharArray();

        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
            else {
                charCountMap.put(c, 1);
            }
        }

        Integer numOfX = charCountMap.size()==1?0:charCountMap.get('X') ;
        Integer numOfO = charCountMap.size()==1?0:charCountMap.get('O') ;
        String result = numOfO + " " + numOfX;
        return result;
    }
    private static void gameState(String input, HashMap<Character, Integer> charCountMap ) {

        String numOfOYString = numOfOX(input,charCountMap);
        String[] parts = numOfOYString.split(" ");
        int numOfO = Integer.parseInt(parts[0]);
        int numOfX = Integer.parseInt(parts[1]);

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
