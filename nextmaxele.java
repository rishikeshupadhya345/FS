/*
Kiran Rao purchased two boxes (Box1,Box2) of unique weights 
of gold coins, where first box weights are subset of second box gold weights.

 Now design a method for Gumadi Baleshwar Rao to find all the next largest weights 
of Box1 gold coins in the corresponding locations of box2 , 
if doesn’t exist return -1.

The Next largest Weight is Weight ‘W’ in Box1 is the first largest weight 
 to its right side weight in Box2.

NOTE: Unique weights means, no two coins will have same weight.

 Input Format:
 -------------
Line-1: space separated integers, weihts of gold coins in the first box.
Line-2: space separated integers, weihts of gold coins in the second box.

Output Format:
--------------
 Print a list of integers, next largest weights

Sample Input-1:
---------------
 4 3 2
 1 3 4 2

Sample Output-1:
 ----------------
 [-1, 4, -1]


 Sample Input-2:
 ---------------
5 6 3 4
1 5 3 7 8 6 4 2

 Sample Output-2:
 ----------------
[7, -1, 7, -1]

*/
import java.util.*;
class x {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        String arr1[] = inp.split(" ");
        int ar1[] = new int[arr1.length];
        String inp2 = sc.nextLine();
        String arr2[] = inp2.split(" ");
        int ar2[] = new int[arr2.length];
        for(int i=0 ; i<arr1.length ; i++) ar1[i]=Integer.parseInt(arr1[i]);
        for(int i=0 ; i<arr2.length ; i++) ar2[i]=Integer.parseInt(arr2[i]);
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i : ar2) {
            if(stack.empty()) stack.push(i);
            else {
                while(!stack.empty()) {
                    if(stack.peek()<i) {
                        hm.put(stack.peek(),i);
                        stack.pop();
                    }
                    else break;
                }
                stack.push(i);
            }
        }
        for(int i : ar1) System.out.print(hm.getOrDefault(i,-1)+" ");
    }
}