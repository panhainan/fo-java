/**
 * 
 */
package com.panhainan.io;

import java.io.PrintWriter;

/**
 * 
 * @author 潘海南
 * @email panhainan@yeah.net
 * @website http://panhainan.com
 * @date 2016年12月29日
 */
public class ChangeSystemOut {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		out.println("ChangeSystemOut");
	}
}
