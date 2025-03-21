#include <iostream>
#include <vector>
#include <string>

using namespace std;

struct TrieNode
{
    TrieNode *children[26]; // 26 English letters
    int pass;               // Number of words passing through this node

    TrieNode()
    {
        pass = 0;
        for (int i = 0; i < 26; ++i)
            children[i] = nullptr;
    }
};

class Trie
{
public:
    Trie() { root = new TrieNode(); }

    // Insert a word and calculate its contribution to the total power
    int insert(const string &word)
    {
        TrieNode *node = root;
        int commonPrefixLen = 0;

        for (char c : word)
        {
            int idx = c - 'A';
            if (node->children[idx] == nullptr)
            {
                node->children[idx] = new TrieNode();
            }
            node = node->children[idx];

            commonPrefixLen += node->pass; // Calculate the contribution of the common prefix
            node->pass++;                  // Increment the number of words passing through this node
        }

        return commonPrefixLen; // Return the length of the common prefix for this word
    }

private:
    TrieNode *root;
};

int main()
{
    int n;
    cin >> n;

    Trie trie;
    vector<string> spells(n);

    // Input all spells
    for (int i = 0; i < n; ++i)
    {
        cin >> spells[i];
    }

    int totalPower = 0;

    // Insert each spell into the Trie and calculate the total power
    for (const string &spell : spells)
    {
        totalPower += trie.insert(spell);
    }

    // Output the total power
    cout << totalPower << endl;
    return 0;
}
