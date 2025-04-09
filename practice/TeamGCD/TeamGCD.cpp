#include <iostream>
#include <vector>
#include <numeric>   // For std::gcd
#include <algorithm> // For std::transform
#include <cstdlib>   // For std::abs

using namespace std;

// Function to calculate the GCD of an array
int getGCD(const vector<int> &arr)
{
    int gcd = abs(arr[0]); // Use absolute value to ensure non-negative input
    for (size_t i = 1; i < arr.size(); i++)
    {
        gcd = std::gcd(gcd, abs(arr[i])); // Use std::gcd
    }
    return gcd;
}

int sumGCD(int n, int m, vector<vector<int>> &Teams, vector<int> &prod)
{
    int sum = 0;

    // Array to track which team each employee belongs to
    vector<int> teamMap(n);
    for (int i = 0; i < n; i++)
    {
        teamMap[i] = i; // Initially, each employee is in their own team
    }

    // Iterate through each day's team formation
    for (const auto &team : Teams)
    {
        int emp1 = team[0];
        int emp2 = team[1];

        // Merge the teams of emp1 and emp2
        int team1 = teamMap[emp1];
        int team2 = teamMap[emp2];
        for (int i = 0; i < n; i++)
        {
            if (teamMap[i] == team2)
            {
                teamMap[i] = team1; // Merge team2 into team1
            }
        }

        // Collect all employees in the current team
        vector<int> currentTeam;
        for (int i = 0; i < n; i++)
        {
            if (teamMap[i] == team1)
            {
                currentTeam.push_back(prod[i]);
            }
        }

        // Calculate the GCD of the current team's productivity
        int teamGCD = getGCD(currentTeam);
        cout << teamGCD << endl; // Output the GCD for the current team
        sum += teamGCD;          // Add the GCD to the total sum
    }

    return sum;
}

int main()
{
    // Input number of employees
    int n;
    cin >> n;

    // Input productivity of each employee
    vector<int> prod(n);
    for (int i = 0; i < n; i++)
    {
        cin >> prod[i];
    }

    // Input number of days employees team up
    int m;
    cin >> m;

    // Input m lines of teamed-up employees
    vector<vector<int>> Teams(m, vector<int>(2));
    for (int i = 0; i < m; i++)
    {
        cin >> Teams[i][0] >> Teams[i][1];
        Teams[i][0]--; // Convert to 0-based index
        Teams[i][1]--; // Convert to 0-based index
    }

    // Calculate the GCD of the productivity of all days
    sumGCD(n, m, Teams, prod);

    return 0;
}