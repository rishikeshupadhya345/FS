/*
Suppose you are given the following code:

class KmitNgit {
  public void kmit() {
    for (int i = 0; i < n; i++) {
      print("Kmit");
    }
  }

  public void ngit() {
    for (int i = 0; i < n; i++) {
      print("Ngit");
    }
  }
}

The same instance of KmitNgit will be passed to two different threads. 
Thread A will call kmit() while thread B will call ngit(). 
Modify the given program to output "KmitNgit" n times.

Input Format:
-------------
An integer N.

Output Format:
--------------
Print KmitNgit for N times using threads.


Sample Input:
-------------
1
Sample Output:
--------------
KmitNgit

Explanation:
------------
There are two threads being fired asynchronously. 
One of them calls kmit(), while the other calls ngit(). 
"KmitNgit" is being output 1 time.


Sample Input:
-------------
2

Sample Output:
--------------
KmitNgitKmitNgit

Explanation:
------------
"KmitNgit" is being output 2 times.

*/


import java.util.*;

class KmitNgit {
    int n;
    int turn=1;
    int i=1;
    KmitNgit(int n){
        this.n=n;
    }
    public int get(){
        return turn;
    }
    
    public void inc(){
        this.i++;
    }
    
  public void kmit() {
    
      System.out.print("Kmit");
        turn--;
  }

  public void ngit() {
    
      System.out.print("Ngit");
        turn++;
  }
}

class t1 implements Runnable{
    
    KmitNgit kn;
    t1(KmitNgit obj){
        kn=obj;
    }
    
    public void run(){
        synchronized(kn){
            while(kn.i<=kn.n){
                if(kn.get()==1){
                    kn.kmit();
                    kn.notifyAll();
                }
                else{
                    try{
                        kn.wait();
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                }
            }
            
        }
    }
    
}

class t2 implements Runnable{
    
    KmitNgit kn;
    t2(KmitNgit obj){
        kn=obj;
    }
    
    public void run(){
        synchronized(kn){
            while(kn.i<=kn.n){
                if(kn.get()==0){
                    kn.ngit();
                    kn.inc();
                    kn.notifyAll();
                }
                else{
                    try{
                        kn.wait();
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                }
            }
            
        }
    }
    
}


class sol{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        KmitNgit obj=new KmitNgit(n);
        
        Thread thread1=new Thread(new t1(obj));
        Thread thread2=new Thread(new t2(obj));
        
        thread1.start();
        thread2.start();
        
    }
}