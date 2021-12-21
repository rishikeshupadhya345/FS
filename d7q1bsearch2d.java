/*There is a board with M*N size. 
The board contains M*N blocks of 1*1 size.
Each block is printed a number on it.

You will be given a number, your task is to find whether the number is printed on 
any of the blocks or not. If found print true, otherwise print false.

NOTE: 
- The numbers printed on the board in each row and each column are
  in increasing order. And all the numbers are unique.

Input Format:
-------------
Line-1 -> Two integers M and N, board size.
Next M lines -> N space separated integers.
Last Line -> An integer T, number to search.

Output Format:
--------------
Print a boolean value, 'true' if number found.
otherwise, 'false'.


Sample Input-1:
---------------
4 4
1 3 6 10
2 5 9 13
4 8 12 16
7 11 14 17
5

Sample Output-1:
----------------
true


Sample Input-2:
---------------
4 4
1 3 6 10
2 5 9 13
4 8 12 16
7 11 14 17
15

Sample Output-2:
----------------
false
*/
import java.util.*;
class x{
    static int v;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        boolean flag=false;
        int a[][]=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                a[i][j]=sc.nextInt();
            }
        }
        v=sc.nextInt();
        int i=0;
        while(i<r){
            if(a[i][0]<=v && v<=a[i][c-1]){
                int s=0;
                int e=c-1;
                while(s<=e){
                    int mid=(s+e)/2;
                    if(a[i][mid]==v){
                        flag=true;
                        break;
                    }
                    else if(a[i][mid]>v){
                        e=mid-1;
                    }
                    else{
                        s=mid+1;
                    }
                }
                
            }
            if(flag==true){
                break;
            }
            i=i+1;
            
        }
    
        System.out.print(flag);
    }
}
