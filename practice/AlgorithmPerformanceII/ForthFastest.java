package practice.AlgorithmPerformanceII;

import java.util.Scanner;

public class ForthFastest {
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

        System.out.println(get4th_Min(runTimes));

        scanner.close();
    }

    // Get the 4th min from the array
    public static int get4th_Min(int[] arr) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int thirdMin = Integer.MAX_VALUE;
        int fourthMin = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                fourthMin = thirdMin;
                thirdMin = secondMin;
                secondMin = min;
                min = arr[i];
            } else if (arr[i] < secondMin) {
                fourthMin = thirdMin;
                thirdMin = secondMin;
                secondMin = arr[i];
            } else if (arr[i] < thirdMin) {
                fourthMin = thirdMin;
                thirdMin = arr[i];
            } else if (arr[i] < fourthMin) {
                fourthMin = arr[i];
            }
        }
        return fourthMin;
    }
}
