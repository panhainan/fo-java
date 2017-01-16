package com.study.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径
            String path = "src/main/java/com/study/io/";
            inputStream = new FileReader(path+"xanadu.txt");
            outputStream = new FileWriter(path+"characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}