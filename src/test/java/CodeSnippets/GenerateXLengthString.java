package CodeSnippets;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

public class GenerateXLengthString {

	private static Random random = new Random((new Date()).getTime());

	/**
	 * generates an alphanumeric string based on specified length.
	 * 
	 * @param length # of characters to generate
	 * @return random string
	 */
	public static String generateRandomString(int length) {
		char[] values = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		String out = "";
		for (int i = 0; i < length; i++) {
			int idx = random.nextInt(values.length);
			out += values[idx];
		}
		return out;
	}
	
	public static void main(String[] args) {
		System.out.println(generateRandomString(11));
	}

}