/*
You are given a list of N integers List[], list contains both +ve and -ve integers.
Your task is to findout, the Highest Product possible,
Where the product is the product of all the elements of contiguous sublist sList[],
and sub list should conatin atleast 1 integer.

Input Format:
-------------
Line-1: An integer N.
Line-2: N space separated integers, List[].

Output Format:
--------------
Print an integer output, the highest product.

Sample Input-1:
---------------
4
2 3 -2 4

Sample Output-1:
----------------
6

Explanation:
------------
Product of contiguous sub list [2,3].


Sample Input-2:
---------------
3
-2 0 -3

Sample Output-2:
----------------
0

Explanation:
------------
Product of sub list [0], where [-2,-3] is not a contiguous sublist

*/
n=int(input())
l=list(map(int,input().split()))
max_pro=l[0]
max1=[l[0]]+[0]*(n-1)
min1=[l[0]]+[0]*(n-1)
for i in range(1,n):
    max1[i]=max(min1[i-1]*l[i],max1[i-1]*l[i],l[i])
    min1[i]=min(min1[i-1]*l[i],max1[i-1]*l[i],l[i])
print(max(max1))    