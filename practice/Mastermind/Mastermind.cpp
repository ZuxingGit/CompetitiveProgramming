#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>
using namespace std;

int main()
{
    int n;
    cin >> n;
    cin.ignore(); // Consume the newline character after the integer input

    vector<int> remainingNumbers;

    // Initialize the remaining numbers from 1 to 100
    for (int i = 1; i <= 100; i++)
    {
        remainingNumbers.push_back(i);
    }

    string guess_response;
    int guess;
    string response;

    // Process the clues
    for (int i = 0; i < n; i++)
    {
        getline(cin, guess_response);
        stringstream ss(guess_response);
        ss >> guess >> response;

        if (response == "Yes" || response == "yes")
        {
            remainingNumbers.erase(
                remove_if(remainingNumbers.begin(), remainingNumbers.end(),
                          [guess](int num)
                          { return num % guess != 0; }),
                remainingNumbers.end());
        }
        else
        {
            remainingNumbers.erase(
                remove_if(remainingNumbers.begin(), remainingNumbers.end(),
                          [guess](int num)
                          { return num % guess == 0; }),
                remainingNumbers.end());
        }
    }

    // Output the first remaining number (the secret number)
    cout << remainingNumbers[0] << endl;

    return 0;
}