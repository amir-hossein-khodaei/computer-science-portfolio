#include <iostream>
using namespace std ;
int main() 
{
    double sales = 95000;
    double state_taxes = 0.04 ;
    double country_taxes = 0.02 ;
    cout << "sales : " << sales << endl 

         << "state taxes by 4% : " << sales * state_taxes 
         << "\n country taxes by 2% : " << sales * country_taxes ;
}