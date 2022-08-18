package calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static boolean isInvalidExpression(String expression) {
        Matcher matcher = Pattern.compile("[a-zA-Z]").matcher(expression);
        return expression.matches("[+-]?\\d+[+-]+") || (matcher.find() && !expression.startsWith("/"));
    }

    private static boolean isUnknownCommand(String command) {
        return command.startsWith("/") && !command.equals("/exit") && !command.equals("/help");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            input = scanner.nextLine();
            if (isInvalidExpression(input)) {
                System.out.println("Invalid expression");
                continue;
            }
            if (isUnknownCommand(input)) {
                System.out.println("Unknown command");
                continue;
            }
            switch (input) {
                case "":
                    break;
                case "/exit":
                    System.out.println("Bye!");
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
                    for (String token : input.split("\\+")) {
                        if (!token.isEmpty()) {
                            sum += Integer.parseInt(token.trim());
                        }
                    }
                    System.out.println(sum);
            }
        } while (!input.equals("/exit"));
    }
}
