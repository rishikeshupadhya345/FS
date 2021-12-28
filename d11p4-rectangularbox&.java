/*JVS Infra Pvt Ltd purchased a flatland of size M*N, and it is divided into 1*1 cells.
They mave marked some cells with red colors indicated with 1.
and other cells with blue color indicated with 0.

They want build the walls in the form of rectangles by connecting four distinct 
red colored cells on the flatland that forms an axis-aligned rectangle.
And only the corners of the walls need to be red colored.

Your task is to help, JVS Infra to count the number of rectangular walls
can be built by connecting the red colored cells on the flatland.

Input Format:
-------------
Line-1: Two space separated integers, M and N
Next M lines: N space separated integers, either 0 or 1 only.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 4
1 0 1 0
1 1 1 1
0 1 1 1

Sample Output-1:
----------------
4

Explanation:
-----------
Given flatland is:
1 0 1 0
1 1 1 1
0 1 1 1
Number of rectngular walls are: 4
rectangle-1: by connecting 1's at (0, 0), (1, 0), (0, 2), (1, 2)
rectangle-2: by connecting 1's at (1, 1), (1, 2), (2, 1), (2, 2)
rectangle-3: by connecting 1's at (1, 1), (1, 3), (2, 1), (2, 3)
rectangle-4: by connecting 1's at (1, 2), (2, 2), (1, 3), (2, 3)


Sample Input-2:
---------------
4 5
1 0 1 0 1
0 0 0 1 0
0 1 1 0 1
1 0 1 0 0

Sample Output-2:
----------------
2
*/
import java.util.*;
class x{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        ArrayList<String >s=new ArrayList<>();
        String a[]=new String[r];
        for(int i=0;i<r;i++){
            String sl="";
            for(int j=0;j<c;j++){
                sl=sl+sc.next();
            }
            a[i]=sl;
        }
        int count=0;
        for(int i=0;i<r-1;i++){
            for(int j=i+1;j<r;j++){
                int one=Integer.bitCount((Integer.valueOf(a[i],2) & Integer.valueOf(a[j],2)));
                if(one>=2){
                    count=count+(one*(one-1)/2);
                }
                
            }
        }
        
        System.out.print(count);
    }
}
