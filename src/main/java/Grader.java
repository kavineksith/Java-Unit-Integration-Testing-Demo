import java.util.Scanner;

public class Grader {
    public char determineGrade(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        } else if (score >= 75) {
            return 'A';
        } else if (score >= 65) {
            return 'B';
        } else if (score >= 55) {
            return 'C';
        } else if (score >= 35) {
            return 'S';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        var grader = new Grader(); // Create an instance of Grader
        var scanner = new Scanner(System.in); // Scanner for user input

        while (true) {
            try {
                System.out.print("Enter your score (or type 'exit' to quit): ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) break;
                int score = Integer.parseInt(input);
                System.out.println("Your grade is: " + grader.determineGrade(score));
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Exiting the program.");
    }
}
