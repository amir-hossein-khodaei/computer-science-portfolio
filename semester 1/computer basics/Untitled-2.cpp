#include <iostream>
int main () 
{
    int y = 5 ;
    double x = 10 ;
    int x = x + 5 ; // x += 5
    int y = y * 3 ; // y *= 3
    float z =(x+10)/(3*y) ; 
    /* float and double are used for ashar numbers
    for non ashars (sahih) we use int */
    std::cout << z ;
}