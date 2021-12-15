/*You are given a bunch of sticks with diffrent lengths.
All the even length sticks should be arranged to appear first in the bunch and 
all the odd length sticks should be arranged to appear first in the bunch.

Print the length of the sticks, after arranging them according to above conditions. 

Input Format:
-------------
Line-1: An integer N, number of sticks in the bunch
Line-2: N space separated integers, lengths of the sticks.

Output Format:
--------------
Print the list of length of the sticks after arrangements accordingly.


Sample Input-1:
---------------
4
1 4 3 2

Sample Output-1:
----------------
[4, 2, 1, 3]


Sample Input-2:
---------------
8
10 13 1 6 9 12 9 10

Sample Output-2:
----------------
[10, 6, 12, 10, 13, 1, 9, 9]
*/
import java.util.*;
class x{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int temp,k;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int j=1;
        while(j<n){
            int x=arr[j];
            k=j;
            while(k>0){
                if(arr[k]%2==0 && arr[k-1]%2!=0){
                    arr[k]=arr[k-1];
                    arr[k-1]=x;
                }
                else{
                    break;
                }
                k=k-1;
            }
            j=j+1;
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}