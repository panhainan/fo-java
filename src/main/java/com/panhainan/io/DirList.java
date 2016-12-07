package com.panhainan.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * Created by Pan on 2016/12/7.
 */
public class DirList {
    /**
     * 匿名内部类方式
     * @param regex
     * @return
     */
    public static  FilenameFilter filenameFilter(final String regex){
        return new FilenameFilter(){
            private Pattern pattern=Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };

    }
    public static void main(String[] args) {
        File file = new File(".");
        String[] names = file.list(filenameFilter(".*xml$"));//new DirFilter(".*xml$")
        for(String name : names){
            System.out.println(name);
        }
    }
}
class DirFilter implements FilenameFilter{

    private Pattern pattern;

    public DirFilter(String regex) {
        this.pattern = Pattern.compile(regex);
    }
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}