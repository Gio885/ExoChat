package it.exolab.exochat.crud;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TEST {

	  public static void main(String[] args) {
	        String binaryString = "11011110 00100000 10101001 00001111 01100001 00011100 11100110 01000000";
	        String asciiString = binaryToString(binaryString);
	        System.out.println("Stringa convertita: " + asciiString);
	    }

	    private static String binaryToString(String binaryString) {
	        String[] binaryBytes = binaryString.split(" ");
	        StringBuilder result = new StringBuilder();

	        for (String binaryByte : binaryBytes) {
	            int decimalValue = Integer.parseInt(binaryByte, 2);
	            result.append((char) decimalValue);
	        }

	        return result.toString();
	    }
}
