package practice.Round3;

import java.util.Scanner;

public class Formidable {
    private static int n;
    private static java.util.ArrayList<Integer> dealer;
    private static java.util.ArrayList<Integer> player;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input number of cards n
        n = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline
        // Input the array of dealer's cards
        String dealerString = scanner.nextLine();
        dealer = dealerString.isEmpty() ? new java.util.ArrayList<>() : parseArray(dealerString);
        // sort dealer's cards in ascending order
        dealer.sort(Integer::compareTo);
        // Input the array of player's cards
        String playerString = scanner.nextLine();
        player = playerString.isEmpty() ? new java.util.ArrayList<>() : parseArray(playerString);
        // sort player's cards in ascending order
        player.sort(Integer::compareTo);

        scanner.close();

        // // print inputs as when inputed
        // System.out.println(n);
        // System.out.println(dealer);
        // System.out.println(player);

        // Compare the dealer's and player's cards
        compare(n, dealer, player);
    }

    private static void compare(int n, java.util.ArrayList<Integer> dealer, java.util.ArrayList<Integer> player) {
        // Compare the dealer's and player's cards
        int playerWins = 0;
        int dealerIndex = 0;
        int left = 0;
        int right = n - 1;

        while (dealerIndex < n && left < n && player.get(right) > dealer.get(dealerIndex)) {
            if (player.get(left) > dealer.get(dealerIndex)) {
                playerWins++;
                left++;
                dealerIndex++;
            } else {
                left++;
            }

        }

        if (playerWins > (n - playerWins)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    // Parses a space-separated string of integers into an int array
    private static java.util.ArrayList<Integer> parseArray(String input) {
        java.util.ArrayList<Integer> result = new java.util.ArrayList<>();
        String[] parts = input.split(" ");
        for (String part : parts) {
            if (!part.isEmpty()) {
                result.add(Integer.parseInt(part));
            }
        }
        return result;
    }
}
