package com.panhainan.io;

import java.io.IOException;

/**
 * Created by FirePan on 2017/1/19.
 */
public class MyException extends Throwable {
    public MyException(IOException e, String s) {
        super();
    }

    public MyException(IOException processException, IOException e, String s) {
        super();
    }
}
