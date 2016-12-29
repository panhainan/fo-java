package com.panhainan.question;

/**
 * Created by Pan on 2016/12/27.
 */
public class A {
    int i=0;
    public void change(A t){
        System.out.println("change t start:"+t.hashCode());
        t = new A();
        System.out.println("change t end:"+t.hashCode());
        t.i=1;
    }
    public void change1(A t){
        t.i=1;
        System.out.println("change1 t start:"+t.hashCode());
        t = new A();
        System.out.println("change1 t end:"+t.hashCode());
    }
    public static void main(String[] args) {
        A a = new A();  // 1
        System.out.println("main a start:"+a.hashCode());
        a.change(a);    //2
        System.out.println("main a end:"+a.hashCode());
        System.out.println(a.i);  //3

        A b= new A();
        System.out.println("main b start:"+b.hashCode());
        b.change1(b);
        System.out.println("main a end:"+b.hashCode());
        System.out.println(b.i);
    }
}
