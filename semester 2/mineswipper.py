
import random 


def checker(i , j ) :
     
    if Answer[i][j]=="*":

        return 
    
    for x in range(i-1 , i+2):
         for y in range(j-1 , j+2):
              if ( (x==i and y==j) or  x<0 or  y<0 or y>=Column or x>=Row  ):
                   continue
              if Answer[x][y]=="*":
                        Answer[i][j]+=1

Row = int(input("row"))
Column = int(input("Column"))
Mines = int(input("Mines"))

Answer=[[int(0)] * Column for i in range(Row) ] 

x = 0 
while x <Mines:
    Random_Row=random.randint(0,Row-1)
    Random_Column=random.randint(0,Column-1)
    if Answer[Random_Row][Random_Column] == "*":
           continue
    else :
         Answer[Random_Row][Random_Column] = "*"
         x+=1

for i in range(Row):
     for j in range(Column):
        checker(i , j)
        
for z in range(Row):
     for K in Answer[z]:
          print(K , "\t" , end="" )
     print("\n")

