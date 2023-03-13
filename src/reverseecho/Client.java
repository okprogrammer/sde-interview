package reverseecho;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket skt = new Socket("192.168.101.3", 2001);
		BufferedReader keyb = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(skt.getInputStream()));
		PrintStream ps = new PrintStream(skt.getOutputStream());

		String msg;
		StringBuilder sb;

		do {
			msg = keyb.readLine();
			ps.println(msg);
			msg = br.readLine();
			System.out.println("From Server "+msg);
		} while (!msg.equals("dne"));
		skt.close();
	}
}
