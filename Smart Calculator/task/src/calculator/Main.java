package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        String[] input;
        do {
            input = scanner.nextLine().split(" ");
            switch (input.length) {
                case 0:
                    continue;
                case 1:
                    if (input[0].equals("/exit")) {
                        System.out.println("Bye!");
                        break;
                    } else if (input[0].equals("/help")) {
                        System.out.println("The program calculates the sum of numbers");
                    } else if (!input[0].equals("")) {
                        System.out.println(input[0]);
                    }
                    break;
                default:
                    int sum = 0;
                    for (String string : input) {
                        sum += Integer.parseInt(string);
                    }
                    System.out.println(sum);
                    break;
            }
        } while (!input[0].equals("/exit"));
    }
}
