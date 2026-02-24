#include <iostream>

using namespace std ;

int main() 
{
    cout << "pls import your temp in farenhide ";
    int temp;
    cin >> temp;
    double celsius = (temp - 32) / 1.8 ;
    cout << celsius ;
    return 0;
}