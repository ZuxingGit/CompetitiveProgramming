#include <iostream>
#include <unordered_map>
#include <string>
using namespace std;

void getMaxVotes(const unordered_map<string, int> &votesMap)
{
    string maxVote = "";
    int maxCount = 0;

    for (const auto &pair : votesMap)
    {
        if (pair.second > maxCount ||
            (pair.second == maxCount && pair.first.length() < maxVote.length()))
        {
            maxCount = pair.second;
            maxVote = pair.first;
        }
    }

    cout << maxVote << endl;
}

int main()
{
    int n;
    cin >> n;
    cin.ignore(); // To consume the newline character after the integer input

    unordered_map<string, int> votesMap;

    // Get the votes for each person
    for (int i = 0; i < n; i++)
    {
        string vote;
        getline(cin, vote);
        if (votesMap.find(vote) != votesMap.end())
        {
            votesMap[vote]++;
        }
        else
        {
            votesMap[vote] = 1;
        }
    }

    getMaxVotes(votesMap);

    return 0;
}