/*
Ramesh and Suresh are best friends. They decided to play a word game.
 The game rules are as follows:
 	- The game board shows a word W consist of two characters only A and B.
	- You are allowed to replace a pair of neighbour letters AA with BB in W.
 	- Finally, The one who failed to replace the letters will lose the game.
 Your task is to find all the possible ways of W, after one valid replacement. 
 You have to perform the replacement of the pair from left to right in the word.
 and print the result in the same order of replacement.
   
  
Input Format:
-------------
 A string W, word.

 Output Format:
 --------------
 Print the list of possible replacements of W.
  
Sample Input-1:
---------------
 AAABAA

Sample Output-1:
----------------
[BBABAA, ABBBAA, AAABBB]
  
Sample Input-2:
---------------
AAAAA

Sample Output-2:
----------------
[BBAAA, ABBAA, AABBA, AAABB] 

*/
s=input()
l1=[]
for j in range(len(s)):
    l1.append(s[j])
i=0
while(i<len(s)-1):
    if(s[i]=='A' and s[i+1]=='A'):
        l1[i]='B'
        l1[i+1]='B'
        print(''.join(l1))
        l1[i]='A'
        l1[i+1]='A'
    i=i+1