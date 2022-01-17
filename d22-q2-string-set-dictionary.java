```
Pramod is working on words. He used to remove all the duplicate letters 
from a word. Pramod is given a word W. His task to remove all the duplicate 
letters from W, in such a way that the resulatant word R, contains 
no duplicate letters and all distinct letters from W should be there in R. 
And R should appear first in the dictionary order. 

Input Format:
-------------
A String, the word W.

Output Format:
--------------
Print a String, resulatant word R.


Sample Input-1:
---------------
cbadccb

Sample Output-1:
----------------
adcb


Sample Input-2:
---------------
silicosis

Sample Output-2:
----------------
ilcos
```
import java.util.*;
class x{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        HashMap<Character,Integer> fin=new HashMap<>();
        Stack <Character> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(fin.get(s.charAt(i))==null){
                fin.put(s.charAt(i),i);
            }
        }
        for(int i=0;i<n;i++){
            if(!st.contains(s.charAt(i))){
                if(st.isEmpty()){
                    st.push(s.charAt(i));
                }
                else if(st.peek()<s.charAt(i)){
                    st.push(s.charAt(i));
                }
                else{
                    while(!st.isEmpty() && st.peek()>s.charAt(i) && fin.get(st.peek())>i){
                        st.pop();
                    }
                    st.push(s.charAt(i));
                }
            }
        }
        StringBuilder ans=new StringBuilder();
        for(Character i:st){
            ans.append(Character.toString(i));
            
        }
        System.out.print(ans);
    }
}
