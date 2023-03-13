package reverseecho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReverseEcho {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(2001);
		Socket skt = ss.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(skt.getInputStream()));
		PrintStream ps = new PrintStream(skt.getOutputStream());

		String msg;
		StringBuilder sb;

		do {
			msg = br.readLine();
			sb = new StringBuilder(msg);
			sb.reverse();
			msg = sb.toString();
			ps.println(msg);
		} while (!msg.equals("dne"));
	}
}
