#include <iostream>
using namespace std ;
int main()
{
    int number ;
    cout << "enter your number " ;
    cin >> number ;
    if (number < 10 )
    {
        cout << "shoma as maliat moafid !!";

    }
    else if ( (number<15)&&(number>10) )
    {
        cout << "maliat shoma 5 darsad ast \n mablagh =" << number+number*0.05;

    } 
    else if ( (number<20)&&(number>15) )
    {
        cout << "maliat shoma 10 darsad ast \n mablagh =" << number+number*0.1;

    }
    else if (number > 20 )
    {
        cout << "maliat shoma 20 darsad ast \n mablagh =" << number+number*0.2;
    }
}