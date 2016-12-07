package com.panhainan.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Pan on 2016/12/7.
 */
public class RegexTest {
    public static void main(String[] args) {
        // using pattern with flags
//        Pattern pattern = Pattern.compile("ab", Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher("ABcabdAb");
//        // using Matcher find(), group(), start() and end() methods
//        while (matcher.find()) {
//            System.out.println("Found the text \"" + matcher.group()
//                    + "\" starting at " + matcher.start()
//                    + " index and ending at index " + matcher.end());
//        }
//
//        // using Pattern split() method
//        pattern = Pattern.compile("\\W");
//        String[] words = pattern.split("one@two#three:four$five");
//        for (String s : words) {
//            System.out.println("Split using Pattern.split(): " + s);
//        }
//
//        // using Matcher.replaceFirst() and replaceAll() methods
//        pattern = Pattern.compile("1*2");
//        matcher = pattern.matcher("11234512678");
//        System.out.println("Using replaceAll: " + matcher.replaceAll("_"));
//        System.out.println("Using replaceFirst: " + matcher.replaceFirst("_"));
//
//        String text = "A sep Text sep With sep Many sep Separators";
//        String patternString = "sep";
//        Pattern pattern00 = Pattern.compile(patternString);
//        String[] split = pattern00.split(text);
//        System.out.println("split.length = " + split.length);
//        for (String element : split) {
//            System.out.println("element = " + element);
//        }
//        String text    =
//                "John aaabbb writes about this, and John Doe writes about that," +
//                        " and John Wayne writes about everything."
//                ;
//        String patternString1 = "(John) (.+?) ";
//        Pattern pattern = Pattern.compile(patternString1);
//        Matcher matcher = pattern.matcher(text);
//        while(matcher.find()) {
//            System.out.println("found: " + matcher.group(0) +matcher.group(1) +
//                    " "       + matcher.group(2));
//        }

//        String text    =
//                "John writes about this, and John Doe writes about that," +
//                        " and John Wayne writes about everything."
//                ;
//        String patternString1 = "((John) (.+?)) ";
//        Pattern pattern = Pattern.compile(patternString1);
//        Matcher matcher = pattern.matcher(text);
//        while(matcher.find()) {
//            System.out.println("found:" + matcher.group(3));
//        }

        String text    =
                "John writes about this, and John Doe writes about that," +
                        " and John Wayne writes about everything."
                ;

        String patternString1 = "((John) (.+?)) ";
        Pattern      pattern      = Pattern.compile(patternString1);
        Matcher matcher      = pattern.matcher(text);
        StringBuffer stringBuffer = new StringBuffer();

        while(matcher.find()){
            matcher.appendReplacement(stringBuffer, "Joe Blocks ");
            System.out.println(stringBuffer.toString());
        }
        matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer.toString());
    }


}