package com.panhainan.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by FirePan on 2017/2/3.
 */
public class TestInetAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);


        InetAddress address2 = InetAddress.getByName("phn");
        System.out.println(address2);

        InetAddress address3 = InetAddress.getByName("1.1.1.10");
        System.out.println(address3);
    }
}
