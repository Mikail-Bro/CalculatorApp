import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Creating the Scanner with Locale.US to ensure "." as the decimal separator
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // Output description
        System.out.println("~~~ Simple Calculator ~~~");
        System.out.println("Available operations: +, -, *, /");

        // Variables for input
        double number1 = 0;
        double number2 = 0;
        char operator = ' ';

        // Input the first number with error handling
        while (true) {
            try {
                System.out.print("Enter the first number: ");
                number1 = scanner.nextDouble();
                break; // Exit loop if input is valid
            } catch (Exception e) {
                System.out.println("ERROR: Please enter a valid numeric value!");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        // Input the operator with validation
        while (true) {
            try {
                System.out.print("Enter the operator (+, -, *, /): ");
                String input = scanner.next();
                operator = input.charAt(0);

                // Check if the operator is valid
                if ("+-*/".indexOf(operator) != -1) {
                    break; // Exit loop if operator is valid
                } else {
                    System.out.println("ERROR: Invalid operator! Please enter one of +, -, *, /.");
                }
            } catch (Exception e) {
                System.out.println("ERROR: Invalid input! Please enter a valid operator.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        // Input the second number with error handling
        while (true) {
            try {
                System.out.print("Enter the second number: ");
                number2 = scanner.nextDouble();
                break; // Exit loop if input is valid
            } catch (Exception e) {
                System.out.println("ERROR: Please enter a valid numeric value!");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        // Variable to store the result
        double result = 0;

        // Logic for operations
        switch (operator) {
            case '+': // Addition
                result = number1 + number2;
                break;
            case '-': // Subtraction
                result = number1 - number2;
                break;
            case '*': // Multiplication
                result = number1 * number2;
                break;
            case '/': // Division
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    System.out.println("ERROR: Division by zero is prohibited!");
                    scanner.close();
                    return; // Exit the calculator program
                }
                break;
        }

        // Output the result rounded to 5 decimal places
        System.out.printf("Result: %.5f%n", result);

        // Closing the Scanner
        scanner.close();
    }
}