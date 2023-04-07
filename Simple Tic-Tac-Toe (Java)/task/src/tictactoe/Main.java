package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        //Tic-Tac-Toe
        String input = userInput();
        printGrid(input);
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
