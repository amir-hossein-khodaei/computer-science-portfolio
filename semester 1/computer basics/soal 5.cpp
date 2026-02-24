#include <iostream>
#include <cmath>
#include <string>
using namespace std;
int search(int a , int b[] , int c)
{
    int i ;
    for (i=0;i<c;i++)
    {
        if (a==b[i])
        {
            return(i);
        }
    }
    return(2147483647);
}
int main()
{
    int adad[20]={0} ;
    int i , temp ;
    for (i=0;i<20;i++)
    {
        cout << "enter your " << i << "th number :" ;
        cin >> temp ;
        if (search(temp,adad,20)!=2147483647)
        {
            cout << "i said enter new number :/ ";
            i--;
        }
        else if (search(temp,adad,20)==2147483647)
        {
            cout << "ok = " << temp ;
            adad[i]=temp;
        }
    }
} 