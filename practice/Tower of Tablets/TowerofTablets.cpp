#include <iostream>
#include <vector>
#include <string>
using namespace std;

// TIME LIMIT EXCEEDED
// Function to reorder tablets recursively
bool reorderTablets(vector<string> &oldList, int position, vector<string> &newList)
{
    if (oldList.empty())
    {
        return true;
    }

    for (size_t i = 0; i < oldList.size(); i++)
    {
        string currentTablet = oldList[i];
        string lastTablet = newList.back();

        // Check if the glyph at the given position matches
        if (currentTablet[position] == lastTablet[position])
        {
            // Add the current tablet to the new list
            newList.push_back(currentTablet);
            oldList.erase(oldList.begin() + i);

            // Try both positions recursively
            if (reorderTablets(oldList, 1 - position, newList))
            {
                return true;
            }

            // Backtrack: undo the changes
            oldList.insert(oldList.begin() + i, currentTablet);
            newList.pop_back();
        }
    }

    return false;
}

int main()
{
    int n;
    cin >> n;
    cin.ignore(); // Consume the newline character after the integer input

    vector<string> tablets;

    // Read the glyphs of tablets
    for (int i = 0; i < n; i++)
    {
        string glyph;
        getline(cin, glyph);
        tablets.push_back(glyph);
    }

    bool isPossible = false;

    for (size_t i = 0; i < tablets.size(); i++)
    {
        vector<string> oldList = tablets;
        vector<string> newList;
        newList.push_back(tablets[i]);
        oldList.erase(oldList.begin() + i);

        if (reorderTablets(oldList, 0, newList) || reorderTablets(oldList, 1, newList))
        {
            isPossible = true;
            for (const string &tablet : newList)
            {
                cout << tablet << endl;
            }
            break;
        }
    }

    if (!isPossible)
    {
        cout << -1 << endl;
    }

    return 0;
}