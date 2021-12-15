/*
The Valid shortcuts of a string "abcd", are as follows:
abcd, abcd, a1cd, ab1d, abc1, 2cd, a2d, ab2, 1b1d, 1bc1,a1c1, 1b2, 2c1, 3d,a3,4

You are given a string S and shortcut string  SC, 
Your task is to find out whether the string matches with the given shortcut or not.
if matched print true, else false.

Note:
String S contains only lowercase letters and String SC contains only lowercase
letters and digits.

Input Format:
-------------
Two space separated Strings S and SC

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
internationalization i12iz4n

Sample Output-1:
----------------
true

Sample Input-2:
---------------
apple a2e

Sample Output-2:
----------------
false
*/
import java.util.*;
class x{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String s1=sc.next();
        int a[]=new int[s1.length()];
        int j=0,flag=0;
        String l="";
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)>='a' && s1.charAt(i)<='z'){
                if(l!=""){
                    a[j]=Integer.parseInt(l);
                    l="";
                    ++j;
                    
                }
            }
            else{
        
                l=l+s1.charAt(i);
            }
        }
        if(l!=""){
            a[j]=Integer.valueOf(l);
        }
        int i=0,le;
        j=0;
        int k=0;

        while(k<s1.length() && i<s.length()){
            if(s1.charAt(k)>='a' && s1.charAt(k)<='z'){
                if(s1.charAt(k)!=s.charAt(i)){
                    flag=-1;
                    break;
                }
                
            }
            else{
                le=a[j];
                i=i+le-1;
                k=k+(Integer.toString(le)).length()-1;
                ++j;
    
        
            }
            k=k+1;
            i=i+1;
    
        }
        if(i!=s.length() || k!=s1.length()){
            flag=-1;
        }
        if(flag==0){
            System.out.print(true);
        }
        else{
            System.out.print(false);
        }
    }
}