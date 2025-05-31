package Round3;

import java.util.Scanner;

public class OneArmBandit {
    private double[] probabilities;
    private int[] rewards;
    private int totalPlays;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input number of payouts n
        int n = scanner.nextInt();
        // Input the array of payouts
        scanner.nextLine(); // consume the leftover newline
        String payString = scanner.nextLine();
        String[] payStrings = payString.split(" ");
        int[] payArray = new int[n];
        for (int i = 0; i < n; i++) {
            payArray[i] = Integer.parseInt(payStrings[i]);
        }

        // Input number of plays m
        int m = scanner.nextInt();
        // Input the sequence of plays
        scanner.nextLine(); // consume the leftover newline
        String playSeq = scanner.nextLine();
        String[] playStrings = playSeq.split(" ");
        int[] playArray = new int[m];
        for (int i = 0; i < m; i++) {
            playArray[i] = Integer.parseInt(playStrings[i]);
        }

        scanner.close();


        // try calculate the max total payout
        int maxPayout = calculateMaxPayout(payArray, playArray);
        System.out.println(maxPayout);
    }

    private static int calculateMaxPayout(int[] payouts, int[] plays) {
        int maxPayout = 0;
        for (int play : plays) {
            if (play >= 1 && play <= payouts.length) {
                maxPayout += payouts[play - 1];
            }
        }
        return maxPayout;
    }
    public OneArmBandit(double[] probabilities, int[] rewards) {
        this.probabilities = probabilities;
        this.rewards = rewards;
        this.totalPlays = 0;
    }
    
}