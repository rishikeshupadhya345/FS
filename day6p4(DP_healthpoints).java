/*Your playing a game, the game contains m*n grid.
Each cell in the grid represent the health points.
You can move one step either downwads or rightwards only.
Whenever you visit a cell in the grid, you will lose the 
same health points of the cell.

You will start at (0,0) cell of the grid and have to reach (m-1)*(n-1) cell.
Your task is to minimize the loss of overall health points.

Input Format:
-------------
Line-1: Two integers M and N.
Next M lines: N space separated integers, health points in each row of the grid.

Output Format:
--------------
Print an integer, minimal loss of overall health points.


Sample Input-1:
---------------
3 3
1 3 1
1 5 1
4 2 1

Sample Output-1:
----------------
7

Explanation:
------------
start at cell(0,0) =>  1→3→1→1→1 minimizes the loss of health points.


Sample Input-2:
---------------
4 4
8 6 9 3
7 6 2 1
5 5 7 9
8 9 6 2

Sample Output-2:
----------------
34

Explanation:
------------
start at cell(0,0) =>  8→6→6→2→1→9→2 minimizes the loss of health points.
*/



import java.util.*;
class test{
    static HashMap<String,Integer > H=new HashMap<>();
    public static int dp(int a[][],int x,int y){
        String s=x+"$"+y;
        if(H.get(s)!=null){
            return H.get(s);
        }
        if(x==0 && y==0){
            return a[0][0];
        }
        if(x!=0 && y==0){
            H.put(s,a[x][y]+dp(a,x-1,y));
            return H.get(s);
        }
        if(x==0 && y!=0){
            H.put(s,a[x][y]+dp(a,x,y-1));
            return H.get(s);
        }
        else{
            if(H.get(s)==null){
                int mi=a[x][y]+Math.min(dp(a,x-1,y),dp(a,x,y-1));
                H.put(s,mi);
                
            }
            return H.get(s);
        }
        
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int a[][]=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                a[i][j]=sc.nextInt();
            }
        }
        System.out.print(dp(a,rows-1,cols-1));
    }
}