package com.panhainan.question;

/**
 * Created by Pan on 2016/12/27.
 */
public class A {
    int i=0;
    public void change(A a){
        a = new A();
        a.i=1;
    }
    public void change1(A a){
        a.i=1;
        a = new A();
    }
    public static void main(String[] args) {
        A a = new A();  // 1
        a.change(a);    //2
        System.out.println(a.i);  //3

        A b= new A();
        b.change1(b);
        System.out.println(b.i);
    }
}
