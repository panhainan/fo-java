package com.study.nio;

import java.nio.ByteBuffer;

/**
 * Created by FirePan on 2017/1/19.
 */
public class Buffer1 {
    public static void main(String[] args) {
//      cap-pos ==
//      and
//      class type ==
//

        ByteBuffer bbf = ByteBuffer.allocate(48);
        ByteBuffer bbf2 = ByteBuffer.allocate(48);
        ByteBuffer bbf3 = ByteBuffer.allocate(47);
        ByteBuffer bbf4 = ByteBuffer.allocate(49);

        System.out.println("bbf=" + bbf);
        System.out.println("bbf2=" + bbf2);
        System.out.println("bbf3=" + bbf3);
        System.out.println("bbf4=" + bbf4);
        System.out.println("bbf.equals(bbf2)=" + bbf.equals(bbf2));
        System.out.println("bbf.compareTo(bbf2)=" + bbf.compareTo(bbf2));
        System.out.println("bbf.equals(bbf3)=" + bbf.equals(bbf3));
        System.out.println("bbf.compareTo(bbf3)=" + bbf.compareTo(bbf3));
        System.out.println("******************************");

        bbf.put((byte) 10);
        bbf4.put((byte) 12);
        bbf4.put((byte) 13);
        System.out.println("bbf=" + bbf);
        System.out.println("bbf2=" + bbf2);
        System.out.println("bbf3=" + bbf3);
        System.out.println("bbf4=" + bbf4);
        System.out.println("bbf.equals(bbf2)=" + bbf.equals(bbf2));
        System.out.println("bbf.compareTo(bbf2)=" + bbf.compareTo(bbf2));
        System.out.println("bbf.equals(bbf3)=" + bbf.equals(bbf3));
        System.out.println("bbf.compareTo(bbf3)=" + bbf.compareTo(bbf3));
        System.out.println("bbf.equals(bbf4)=" + bbf.equals(bbf4));
        System.out.println("bbf.compareTo(bbf4)=" + bbf.compareTo(bbf4));
        System.out.println("******************************");

        bbf2.put((byte) 11);
        System.out.println("bbf=" + bbf);
        System.out.println("bbf2=" + bbf2);
        System.out.println("bbf3=" + bbf3);
        System.out.println("bbf4=" + bbf4);
        System.out.println("bbf.equals(bbf2)=" + bbf.equals(bbf2));
        System.out.println("bbf.compareTo(bbf2)=" + bbf.compareTo(bbf2));
        System.out.println("******************************");


    }
}
