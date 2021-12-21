/*
There are a group of kids playing a game in a circle.This game is to check their
Arithmetic division skills.We will start the game by selecting a kid and he has 
to say 1 to start the game and the next kid turn arrives he has to say next 
number but with the following rules.
   - if number is divisible by 3 then the answer is "Hi".
   - if number is divisible by 5 then the answer is "Hello".
   - if number is divisible by both 3 and 5 then the answer is "HiHello".
   - else the answer is the number itself.

 Given a number N , return a string array result[] (1-indexed),which consists the 
 answers from kid-1 to kid-N.

Input Format:
-------------
Line-1: An integer N.

Output Format:
--------------
Print a string array[].

Constraints:
� 1 <= n <= 10^4
 
Sample Input-1:
---------------
4

Sample Output-1:
----------------
1 2 Hi 4 


Sample Input-2:
---------------
15

Sample Output-2:
----------------
1 2 Hi 4 Hello Hi 7 8 Hi Hello 11 Hi 13 14 HiHello 
 


*/






import java.util.*;

class Shared{
    int i=1;
    int n=0;
    Shared(int n){
        this.n=n;
    }
    public synchronized int get(){
        if(i<=n){
            return i;
        }
        else{
            return -1;
        }
    }
    public synchronized void increment(){
        this.i++;
    }
}
class number implements Runnable{
    Shared s;
    number(Shared obj){
        s=obj;
    }
    @Override
    public void run(){
        synchronized(s){
            while(s.get()!=-1){
                if(s.get()%3!=0 &&s.get()%5!=0){
                    System.out.println(s.get());
                    s.increment();
                    s.notifyAll();
                }
                else{
                    try{
                        s.wait();
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                }
            }
        }
    }
}

class Hi implements Runnable{
    Shared s;
    Hi(Shared obj){
        s=obj;
    }
    @Override
    public void run(){
        synchronized(s){
            while(s.get()!=-1){
                if(s.get()%3==0 &&s.get()%5!=0){
                    System.out.println("Hi");
                    s.increment();
                    s.notifyAll();
                }
                else{
                    try{
                        s.wait();
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                }
            }
        }
    }
}

class Hello implements Runnable{
    Shared s;
    Hello(Shared obj){
        s=obj;
    }
    @Override
    public void run(){
        synchronized(s){
            while(s.get()!=-1){
                if(s.get()%3!=0 &&s.get()%5==0){
                    System.out.println("Hello");
                    s.increment();
                    s.notifyAll();
                }
                else{
                    try{
                        s.wait();
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                }
            }
        }
    }
}

class HiHello implements Runnable{
    Shared s;
    HiHello(Shared obj){
        s=obj;
    }
    @Override
    public void run(){
        synchronized(s){
            while(s.get()!=-1){
                if(s.get()%3==0 &&s.get()%5==0){
                    System.out.println("HiHello");
                    s.increment();
                    s.notifyAll();
                }
                else{
                    try{
                        s.wait();
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
        Shared obj=new Shared(n);
        Thread t1=new Thread(new number(obj));
        Thread t2=new Thread(new Hi(obj));
        Thread t3=new Thread(new Hello(obj));
        Thread t4=new Thread(new HiHello(obj));
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
    }
}




/*
import java.util.*;
public class a{
    static int n,count=1;
    public void f3_5(){
        synchronized(this){
            while(count<=n){
                if(count%3==0 && count%5==0){
                    System.out.print("HiHello ");
                    count++;
                    notifyAll();
                }
                else{
                    try{
                        wait();
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void f5(){
        synchronized(this){
            while(count<=n){
                if(count%3!=0 && count%5==0){
                    System.out.print("Hello ");
                    count++;
                    notifyAll();
                }
                else{
                    try{
                        wait();
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void f3(){
        synchronized(this){
            while(count<=n){
                if(count%3==0 && count%5!=0){
                    System.out.print("Hi ");
                    count++;
                    notifyAll();
                }
                else{
                    try{
                        wait();
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void f(){
        synchronized(this){
            while(count<=n){
                if(count%3!=0 && count%5!=0){
                    System.out.print(count+" ");
                    count++;
                    notifyAll();
                }
                else{
                    try{
                        wait();
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String arfs[]){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        a obj=new a();
        Thread t1=new Thread(new Runnable(){
            public void run(){
                obj.f3_5();
            }
        });
        Thread t2=new Thread(new Runnable(){
            public void run(){
                obj.f5(); 
            }
        });
        Thread t3=new Thread(new Runnable(){
            public void run(){
                obj.f3();   
            }
        });
        Thread t4=new Thread(new Runnable(){
            public void run(){
                 obj.f();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
*/