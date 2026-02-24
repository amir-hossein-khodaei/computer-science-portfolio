#include <iostream>
#include <string>
using namespace std;
main ()
{
    char ch ;
    string hello_world ;
    for (ch='a';ch<'h';ch++)
        {
            cout << ch <<endl ;
        }
    hello_world = ch;
    for (ch='a';ch<'e';ch++)
        {
            cout << hello_world << ch << endl ;
        }
    hello_world+=ch ;
    for (ch='a';ch<'l';ch++)
        {
            cout << hello_world << ch << endl ;
        }
    hello_world+=ch ;
    for (ch='a';ch<'l';ch++)
        {
            cout << hello_world << ch << endl ;
        }
    hello_world+=ch ;
    for (ch='a';ch<'o';ch++)
        {
            cout << hello_world << ch << endl ;
        }
    hello_world+=ch ;
    hello_world+=" ";
    for (ch='a';ch<'w';ch++)
        {
            cout << hello_world << ch << endl ;
        }
    hello_world+=ch ;
    for (ch='a';ch<'o';ch++)
        {
            cout << hello_world << ch << endl ;
        }
    hello_world+=ch ;
    for (ch='a';ch<'r';ch++)
        {
            cout << hello_world << ch << endl ;
        }
    hello_world+=ch ;
    for (ch='a';ch<'l';ch++)
        {
            cout << hello_world << ch << endl ;
        }
    hello_world+=ch ;
    for (ch='a';ch<'d';ch++)
        {
            cout << hello_world << ch << endl ;
        }
    hello_world+=ch ;
    for(ch='a';ch<'e';ch++)
        {
        cout << hello_world << endl ;
        } 
    cout << hello_world << endl ;
}