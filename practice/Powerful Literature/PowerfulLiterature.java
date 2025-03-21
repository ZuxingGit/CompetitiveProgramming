import java.util.Scanner;

class TrieNode {
    TrieNode[] children; // 26 English letters
    int pass; // Number of words passing through this node

    TrieNode() {
        children = new TrieNode[26];
        pass = 0;
    }
}

class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    // Insert a word and calculate its contribution to the total power
    public int insert(String word) {
        TrieNode node = root;
        int commonPrefixLen = 0;

        for (char c : word.toCharArray()) {
            int idx = c - 'A';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];

            commonPrefixLen += node.pass; // Calculate the contribution of the common prefix
            node.pass++; // Increment the number of words passing through this node
        }

        return commonPrefixLen; // Return the length of the common prefix for this word
    }
}

public class PowerfulLiterature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Trie trie = new Trie();
        String[] spells = new String[n];

        // Input all spells
        for (int i = 0; i < n; i++) {
            spells[i] = scanner.nextLine();
        }

        int totalPower = 0;

        // Insert each spell into the Trie and calculate the total power
        for (String spell : spells) {
            totalPower += trie.insert(spell);
        }

        // Output the total power
        System.out.println(totalPower);

        scanner.close();
    }
}