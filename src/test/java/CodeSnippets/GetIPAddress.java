package CodeSnippets;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIPAddress {

	public static void main(String[] args) {
		System.out.println(getInetAddress("www.google.com"));

	}

	private static String getInetAddress(String host) {
		InetAddress address = null;
		try {
			address = InetAddress.getByName(host);
		} catch (UnknownHostException e) {
			System.err.println(e.getMessage());
		}
		return address.getHostAddress();
	}
}
