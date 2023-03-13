package collection.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TokenizerDemo {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		FileInputStream fis = new FileInputStream("C:/Users/OMKUMAR/Downloads/demo.txt");
		byte[] b = new byte[fis.available()];
		fis.read(b);
		String data = new String(b);
		// String data = "name=Om address=delhi country=india dept=cse";
		StringTokenizer stk = new StringTokenizer(data, ",");
		ArrayList<Integer> al = new ArrayList<>();
		while (stk.hasMoreElements()) {
			al.add(Integer.valueOf(stk.nextToken()));
		}
		System.out.println(al);
	}
}
