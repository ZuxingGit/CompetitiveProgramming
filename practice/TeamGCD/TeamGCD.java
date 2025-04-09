package practice.TeamGCD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamGCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of employees
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Get the productivity of each employee:3 5 21 11 15
        String[] productivity = scanner.nextLine().split(" ");
        int[] prod = new int[n];
        for (int i = 0; i < n; i++) {
            prod[i] = Integer.parseInt(productivity[i]);
        }

        // Get the number of days employees team up
        int m = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Get m lines of teamed up employees, like: i j
        int[][] Teams = new int[m][2];
        for (int i = 0; i < m; i++) {
            String[] team = scanner.nextLine().split(" ");
            Teams[i][0] = Integer.parseInt(team[0]) - 1; // Convert to 0-based index
            Teams[i][1] = Integer.parseInt(team[1]) - 1; // Convert to 0-based index
        }

        // Calculate the GCD of the productivity of all days
        sumGCD(n, m, Teams, prod);

        scanner.close();
    }

    /**
     * Calculate the GCD of all days
     * 
     * @param n     number of employees
     * @param m     number of days
     * @param Teams the teams of employees
     * @param prod  the productivity of employees
     * @return the sum of GCD of all days
     */
    public static int sumGCD(int n, int m, int[][] Teams, int[] prod) {
        int sum = 0;

        // Array to track which team each employee belongs to
        int[] teamMap = new int[n];
        for (int i = 0; i < n; i++) {
            teamMap[i] = i; // Initially, each employee is in their own team
        }

        // Iterate through each day's team formation
        for (int[] team : Teams) {
            int emp1 = team[0];
            int emp2 = team[1];

            // Merge the teams of emp1 and emp2
            int team1 = teamMap[emp1];
            int team2 = teamMap[emp2];
            for (int i = 0; i < n; i++) {
                if (teamMap[i] == team2) {
                    teamMap[i] = team1; // Merge team2 into team1
                }
            }

            // Collect all employees in the current team
            List<Integer> currentTeam = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (teamMap[i] == team1) {
                    currentTeam.add(prod[i]);
                }
            }

            // Calculate the GCD of the current team's productivity
            int[] teamProductivity = currentTeam.stream().mapToInt(Integer::intValue).toArray();

            System.out.println(getGCD(teamProductivity));
        }

        return sum;
    }

    public static int getGCD(int[] arr) {
        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            gcd = gcd(gcd, arr[i]);
        }
        return gcd;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
