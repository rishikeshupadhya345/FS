/*There are B bags containing N gold boxes each. In each bag, gold boxes are 
arranged  in ascending order of their weights strictly, create a method in 
such a way that we need to return the least weight of gold box which is 
common least weight in all the given bags.

If we don’t have any common least weighted gold box, among all the bags then return -1.

Input Format:
-------------
Line-1: Two integers B and N, number of bags and number of goldboxes in each Bag.
Next B lines: N space separated integers, weights of GoldBoxes.

Output Format:
--------------
Print the least weight of gold box, if found
Print -1, if not found.


Sample Input:
---------------
5 5
1 2 3 4 5
2 3 6 7 9
1 2 3 5 8
1 3 4 6 8 
2 3 5 7 8

Sample Output:
----------------
3
*/
import java.util.*;
class x{
    public static boolean binary(int s,int e,int a[][],int r,int v){
        while(s<=e){
            int mid=(s+e)/2;
            if(a[r][mid]==v){
                return true;
            }
            else if(a[r][mid]>v){
                e=mid-1;
            }
            else if(a[r][mid]<v){
                s=mid+1;
            }
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int b=sc.nextInt();
        int g=sc.nextInt();
        int a[][]=new int[b][g];
        for(int i=0;i<b;i++){
            for(int j=0;j<g;j++){
                a[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<g;i++){
            int min=a[0][i];
            int flag=0;
            for(int j=1;j<b;j++){
                boolean f=binary(0,g-1,a,j,min);
                
                if(!f){
                    flag=1;
                }
            
            }
            if(flag==0){
                System.out.print(min);
                return;
            }
        }
        System.out.print(-1);
        
    }
}
