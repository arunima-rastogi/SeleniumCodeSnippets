package UtilityFunctions;

import java.util.Base64;

public class Base64EncoderDecoders {
	
	public String Encode(String original) {
		
        String sample = original; 
  
        // print actual String 
        System.out.println("Original string "+ sample); 
  
        // Encode into Base64 format 
        String BasicBase64format = Base64.getEncoder().encodeToString(sample.getBytes()); 
  
        // print encoded String 
        System.out.println("Encoded String: "+ BasicBase64format); 
        
        return BasicBase64format;
	}
	
	public String Decode(String encodedString) {
	      String encoded = encodedString;  // "SW5kaWEgVGVhbSB3aWxsIHdpbiB0aGUgQ3Vw"; 

      // print encoded String 
      System.out.println("Encoded String: " + encoded); 

      // decode into String from encoded format 
      byte[] actualByte = Base64.getDecoder().decode(encoded); 

      String actualString = new String(actualByte); 

      // print actual String 
      System.out.println("actual String: " + actualString);
      
      return actualString;
	}

}
