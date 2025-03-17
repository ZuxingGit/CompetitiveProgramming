#include <iostream>
#include <string>
using namespace std;

void sayHello(const string &name)
{
    cout << "Hello " << name << "!" << endl;
}

int main()
{
    int n;
    cin >> n;
    cin.ignore(); // To consume the newline character after the integer input

    for (int i = 0; i < n; i++)
    {
        string name;
        getline(cin, name);
        sayHello(name);
    }

    return 0;
}
