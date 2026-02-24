#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int main () 
{
    cout << "^_^ welcom to random number generator ^_^ " << endl << "what is your starting number ? " ;
    int minimum ;
    cin >> minimum ;
    cout << "what is your ending number ? " ;
    int maximum ;
    cin >> maximum ;
    srand(time(0)) ;
    double random_number = ((rand() % ( maximum - minimum + 1 )) + minimum) ;
    cout << random_number ;
    return(0) ;
}