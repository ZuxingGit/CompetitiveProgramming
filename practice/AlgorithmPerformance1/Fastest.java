package practice.AlgorithmPerformance1;

import java.util.Scanner;

public class Fastest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Get the number of run times
        int n = scanner.nextInt();
        scanner.nextLine();
        // System.out.println(n);

        // Get the n run times for a space separated row
        int[] runTimes = new int[n];
        String[] runTimesString = scanner.nextLine().split(" ");
        // Convert the string array to an int array
        for (int i = 0; i < n; i++) {
            runTimes[i] = Integer.parseInt(runTimesString[i]);
            // System.out.println(runTimes[i]);
        }

        System.out.println(getMin(runTimes));
    }

    // Get the min from the array
    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}