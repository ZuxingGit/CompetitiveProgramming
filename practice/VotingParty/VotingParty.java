package practice.VotingParty;

import java.util.HashMap;
import java.util.Scanner;

public class VotingParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Get the number of people at the party
        int n = scanner.nextInt();
        scanner.nextLine();

        HashMap<String, Integer> votesMap = new HashMap<>();

        // Get the votes for each person
        for (int i = 0; i < n; i++) {
            String vote = scanner.nextLine();
            if (votesMap.containsKey(vote)) {
                votesMap.put(vote, votesMap.get(vote) + 1);
            } else {
                votesMap.put(vote, 1);
            }
        }

        getMaxVotes(votesMap);

        scanner.close();
    }

    public static void getMaxVotes(HashMap<String, Integer> votesMap) {
        String maxVote = "";
        int maxCount = 0;
        for (String key : votesMap.keySet()) {
            if (votesMap.get(key) > maxCount || (votesMap.get(key) == maxCount && key.compareTo(maxVote) < 0)) {
                maxCount = votesMap.get(key);
                maxVote = key;
            }
        }

        System.out.println(maxVote);
    }
}
