package practice.Mastermind;

import java.util.ArrayList;
import java.util.Scanner;

public class Mastermind {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // the number of clues
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        ArrayList<Integer> remainingNumbers = new ArrayList<>();

        // Initialize the remaining numbers from 1 to 100
        for (int i = 1; i <= 100; i++) {
            remainingNumbers.add(i);
        }

        // Process the clues
        for (int i = 0; i < n; i++) {
            String guess_response = scanner.nextLine();
            String[] guess_response_split = guess_response.split(" ");
            int guess = Integer.parseInt(guess_response_split[0]);
            String response = guess_response_split[1];

            if (response.equalsIgnoreCase("Yes")) {
                // Keep only numbers divisible by the guess
                remainingNumbers.removeIf(num -> num % guess != 0);
            } else {
                // Remove numbers divisible by the guess
                remainingNumbers.removeIf(num -> num % guess == 0);
            }
        }

        // Output the first remaining number (the secret number)
        System.out.println(remainingNumbers.get(0));

        scanner.close();
    }
}