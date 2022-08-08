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
                    } else {
                        System.out.println(input[0]);
                    }
                    break;
                default:
                    int a = Integer.parseInt(input[0]);
                    int b = Integer.parseInt(input[1]);
                    System.out.println(a + b);
                    break;
            }
        } while (!input[0].equals("/exit"));
    }
}
