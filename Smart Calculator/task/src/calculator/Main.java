package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            input = scanner.nextLine();
            
            switch (input) {
                case "/exit":
                    System.out.println("Bye!");
                    break;
                case "":
                    break;
                case "/help":
                    System.out.println("The program calculates the sum/subtraction of numbers");
                    break;
                default:
                    input = input.replaceAll("\\s+", " ")
                            .replaceAll("\\++", "+")
                            .replaceAll("-{3}", "-")
                            .replaceAll("-{2}", "+")
                            .replaceAll("-\\+|\\+-", "-")
                            .replaceAll(" - ", " + -");
                    int sum = 0;
                    for (String string : input.split("\\+")) {
                        sum += Integer.parseInt(string.trim());
                    }
                    System.out.println(sum);
            }
        } while (!input.equals("/exit"));
    }
}
