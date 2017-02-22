package com.panhainan.string;

import java.math.BigInteger;
import java.util.Formatter;

/**
 * Created by fo on 2017/1/6.
 */
public class FormatterTest {

    public final static int WIDTH = 6;
    public final static String FORMAT_STR = "%.+"+WIDTH+"s";

    public static void main(String[] args) {

        Formatter f = new Formatter(System.out);
        f.format(FORMAT_STR,"asdfghjkl");
    }

}
