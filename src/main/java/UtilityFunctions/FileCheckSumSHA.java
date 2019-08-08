package UtilityFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileCheckSumSHA {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

		MessageDigest md = MessageDigest.getInstance("SHA-256"); // SHA, MD2,
																	// MD5,
																	// SHA-256,
																	// SHA-384...
		String hex = checksum("C:\\Users\\srasz\\Desktop\\project\\SeleniumCodeSnippets\\pom.xml", md);
		if (hex.equals("79fa3e96984757004d0ed643d520a0e916aa3d2c8afa6f8528b3de9f5cbfd59e"))
			System.out.println(hex);
		System.out.println(hex);
	}

	private static String checksum(String filepath, MessageDigest md) throws IOException {

		// file hashing with DigestInputStream
		try (DigestInputStream dis = new DigestInputStream(new FileInputStream(filepath), md)) {
			while (dis.read() != -1)
				; // empty loop to clear the data
			md = dis.getMessageDigest();
		}

		// bytes to hex
		StringBuilder result = new StringBuilder();
		for (byte b : md.digest()) {
			result.append(String.format("%02x", b));
		}
		return result.toString();

	}

}