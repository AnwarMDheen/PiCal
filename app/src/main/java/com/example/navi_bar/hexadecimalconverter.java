package com.example.navi_bar;

public class hexadecimalconverter {

	public static void main(String[] args) {
		 String hexadecimalNumber = "-1A.B";

	        String binaryNumber = hexToBinary(hexadecimalNumber);
	        System.out.println("Binary equivalent: " + binaryNumber); 
	         double decimalNumber = hexToDecimal(hexadecimalNumber);
	        System.out.println("Decimal equivalent: " + decimalNumber); 
         String octalNumber = hexToOctal(hexadecimalNumber);
          System.out.println("Octal equivalent: " + octalNumber);
	} 
	  public static String hexToBinary(String hexadecimalNumber) {
	        // Checking if the number is negative 
		  String binaryNumber;
	        boolean isNegative = false;
	        if (hexadecimalNumber.charAt(0) == '-') {
	            isNegative = true;
	            hexadecimalNumber = hexadecimalNumber.substring(1); // Remove the negative sign
	        }

	        // Checking if the number is floating-point
	        boolean isFloatingPoint = false;
	        if (hexadecimalNumber.contains(".")) {
	            isFloatingPoint = true;
	        }
             if(isFloatingPoint) 
             {
	        // Splitting the hexadecimal number into whole and fractional parts
	        String[] parts = hexadecimalNumber.split("\\.");
	        String wholePart = parts[0];
	        String fractionalPart = parts[1];

	        // Convert whole part from hexadecimal to binary
	        String binaryWholePart = hexToBinaryWhole(wholePart);

	        // Convert fractional part from hexadecimal to binary
	        String binaryFractionalPart = hexToBinaryFractional(fractionalPart);

	        // Combining the binary parts
	          binaryNumber = binaryWholePart + "." + binaryFractionalPart; 
             }  
             else 
             { 
            	 binaryNumber=hexToBinaryWhole(hexadecimalNumber);
             }
             

	        // Handling negative sign
	        if (isNegative) {
	            binaryNumber = "-" + binaryNumber;
	        }

	        return binaryNumber;
	    }

	    // Convert whole part from hexadecimal to binary
	    public static String hexToBinaryWhole(String hexadecimal) {
	        StringBuilder binary = new StringBuilder();
	        for (int i = 0; i < hexadecimal.length(); i++) {
	            char hexDigit = hexadecimal.charAt(i);
	            String binaryDigit = Integer.toBinaryString(Character.digit(hexDigit, 16));
	            binary.append(String.format("%4s", binaryDigit).replace(' ', '0'));
	        }
	        return binary.toString();
	    }

	    // Convert fractional part from hexadecimal to binary
	    public static String hexToBinaryFractional(String hexadecimal) {
	        StringBuilder binary = new StringBuilder();
	        for (int i = 0; i < hexadecimal.length(); i++) {
	            char hexDigit = hexadecimal.charAt(i);
	            String binaryDigit = Integer.toBinaryString(Character.digit(hexDigit, 16));
	            binary.append(binaryDigit);
	        }
	        return binary.toString();
	    } 
	    public static double hexToDecimal(String hexadecimalNumber) {
	        // Checking if the number is negative 
	    	 double decimalNumber = 0;
	        boolean isNegative = false;
	        if (hexadecimalNumber.charAt(0) == '-') {
	            isNegative = true;
	            hexadecimalNumber = hexadecimalNumber.substring(1); // Remove the negative sign
	        }

	        // Checking if the number is floating-point
	        boolean isFloatingPoint = false;
	        if (hexadecimalNumber.contains(".")) {
	            isFloatingPoint = true;
	        }
             if(isFloatingPoint) 
             {
	        // Splitting the hexadecimal number into whole and fractional parts
	        String[] parts = hexadecimalNumber.split("\\.");
	        String wholePart = parts[0];
	        String fractionalPart = parts[1];

	        // Convert whole part from hexadecimal to decimal
	        int decimalWholePart = hexToDecimalWhole(wholePart);

	        // Convert fractional part from hexadecimal to decimal
	        double decimalFractionalPart = hexToDecimalFractional(fractionalPart);

	        // Combining the decimal parts
	         decimalNumber = decimalWholePart + decimalFractionalPart; 
             } 
             else 
             { 
            	 decimalNumber=hexToDecimalWhole(hexadecimalNumber);
             }

	        // Handling negative sign
	        if (isNegative) {
	            decimalNumber = -decimalNumber;
	        }

	        return decimalNumber;
	    }

	    // Convert whole part from hexadecimal to decimal
	    public static int hexToDecimalWhole(String hexadecimal) {
	        int decimal = 0;
	        int power = 0;
	        for (int i = hexadecimal.length() - 1; i >= 0; i--) {
	            char hexDigit = hexadecimal.charAt(i);
	            int digit = Character.digit(hexDigit, 16);
	            decimal += digit * Math.pow(16, power);
	            power++;
	        }
	        return decimal;
	    }

	    // Convert fractional part from hexadecimal to decimal
	    public static double hexToDecimalFractional(String hexadecimal) { 
	    	
	        double decimal = 0;
	        double power = 1;
	        for (int i = 0; i < hexadecimal.length(); i++) {
	            char hexDigit = hexadecimal.charAt(i);
	            int digit = Character.digit(hexDigit, 16);
	            decimal += digit * Math.pow(16, -power);
	            power++;
	        }
	        return decimal;
	    }  
	    /////////////////////////////////////////////////////////////////////////////////////////////// 
	       public static String hexToOctal(String hexadecimalNumber) 
	       { 
	    	    String s1=hexToBinary(hexadecimalNumber); 
	    	    s1=binaryToOctal(s1); 
	    	    return s1;
	       }
//	    public static String hexToOctal(String hexadecimalNumber) {  
//	    	String octalNumber;
//	        // Checking if the number is negative
//	        boolean isNegative = false;
//	        if (hexadecimalNumber.charAt(0) == '-') {
//	            isNegative = true;
//	            hexadecimalNumber = hexadecimalNumber.substring(1); // Remove the negative sign
//	        }
//
//	        // Checking if the number is floating-point
//	        boolean isFloatingPoint = false;
//	        if (hexadecimalNumber.contains(".")) {
//	            isFloatingPoint = true;
//	        }
//            if(isFloatingPoint) 
//            {
//	        // Splitting the hexadecimal number into whole and fractional parts
//	        String[] parts = hexadecimalNumber.split("\\.");
//	        String wholePart = parts[0];
//	        String fractionalPart = parts[1];
//
//	        // Convert whole part from hexadecimal to octal
//	        String octalWholePart = hexToOctalWhole(wholePart);
//
//	        // Convert fractional part from hexadecimal to octal
//	        String octalFractionalPart = hexToOctalFractional(fractionalPart);
//
//	        // Combining the octal parts
//	         octalNumber = octalWholePart + "." + octalFractionalPart; 
//            } 
//            else 
//            { 
//            	octalNumber=hexToOctalWhole(hexadecimalNumber);
//            }
//
//	        // Handling negative sign
//	        if (isNegative) {
//	            octalNumber = "-" + octalNumber;
//	        }
//
//	        return octalNumber;
//	    }
//
//	    // Convert whole part from hexadecimal to octal
//	    public static String hexToOctalWhole(String hexadecimal) {
//	        StringBuilder octal = new StringBuilder();
//	        String binary = hexToBinary1(hexadecimal);
//	        octal.append(binaryToOctal(binary));
//	        return octal.toString();
//	    }
//
//	    // Convert fractional part from hexadecimal to octal
//	    public static String hexToOctalFractional(String hexadecimal) {
//	        StringBuilder octal = new StringBuilder();
//	        String binary = hexToBinaryFractional1(hexadecimal);
//	        octal.append(binaryToOctalFractional(binary));
//	        return octal.toString();
//	    }
//
//	    // Convert hexadecimal to binary
//	    public static String hexToBinary1(String hexadecimal) {
//	        StringBuilder binary = new StringBuilder();
//	        for (int i = 0; i < hexadecimal.length(); i++) {
//	            char hexDigit = hexadecimal.charAt(i);
//	            String binaryDigit = Integer.toBinaryString(Character.digit(hexDigit, 16));
//	            binary.append(String.format("%4s", binaryDigit).replace(' ', '0'));
//	        }
//	        return binary.toString();
//	    }
//
//	    // Convert fractional part from hexadecimal to binary
//	    public static String hexToBinaryFractional1(String hexadecimal) {
//	        StringBuilder binary = new StringBuilder();
//	        for (int i = 0; i < hexadecimal.length(); i++) {
//	            char hexDigit = hexadecimal.charAt(i);
//	            String binaryDigit = Integer.toBinaryString(Character.digit(hexDigit, 16));
//	            binary.append(binaryDigit);
//	        }
//	        return binary.toString();
//	    }
//
//	    // Convert binary to octal
//	    public static String binaryToOctal(String binary) {
//	        StringBuilder octal = new StringBuilder();
//	        int numDigits = binary.length();
//	        int padding = 3 - (numDigits % 3); // Padding with 0's if necessary
//	        binary = "0".repeat(padding) + binary;
//	        for (int i = 0; i < binary.length(); i += 3) {
//	            String binaryChunk = binary.substring(i, i + 3);
//	            int decimal = Integer.parseInt(binaryChunk, 2);
//	            octal.append(decimal);
//	        }
//	        return octal.toString();
//	    }
//
//	    // Convert fractional part from binary to octal
//	    public static String binaryToOctalFractional(String binary) {
//	        StringBuilder octal = new StringBuilder();
//	        int precision = 5; // Limiting the precision to 5 digits after the decimal point
//	        while (precision > 0) {
//	            binary = binary.substring(0, binary.length() - 1);
//	            int decimal = Integer.parseInt(binary, 2);
//	            octal.append(decimal);
//	            binary = String.valueOf(decimal);
//	            precision--;
//	        }
//	        return octal.toString();
//	    } 
	    public static String binaryToOctal(String binaryNumber) { 
	    	String octalNumber;
	        // Checking if the number is negative
	        boolean isNegative = false;
	        if (binaryNumber.charAt(0) == '-') {
	            isNegative = true;
	            binaryNumber = binaryNumber.substring(1); // Remove the negative sign
	        }

	        // Checking if the number is floating-point
	        boolean isFloatingPoint = false;
	        if (binaryNumber.contains(".")) {
	            isFloatingPoint = true;
	        }
	         if(isFloatingPoint) 
	         {
	        // Splitting the binary number into decimal and fractional parts
	        String[] parts = binaryNumber.split("\\.");
	        String integerPart = parts[0];
	        String fractionalPart = parts[1];
	        // Convert integer part from binary to octal
	        String octalIntegerPart = binaryToOctalInteger(integerPart);

	        // Convert fractional part from binary to octal
	        String octalFractionalPart = binaryToOctalFractional(fractionalPart);

	        // Combining the octal parts
	          octalNumber = octalIntegerPart + "." + octalFractionalPart;
	        } 
	         else 
	         { 
	        	 octalNumber =binaryToOctalInteger(binaryNumber);
	         }
	        // Handling negative sign
	        if (isNegative) {
	            octalNumber = "-" + octalNumber;
	        }

	        return octalNumber;
	    }

	    // Convert binary integer part to octal
	    public static String binaryToOctalInteger(String binary) {
	        int decimal = binaryToDecimal(binary);
	        return decimalToOctal(decimal);
	    }

	    // Convert binary fractional part to octal
	    public static String binaryToOctalFractional(String binary) {
	        double decimal = binaryToDecimalFractional(binary);
	        return decimalToOctalFractional(decimal);
	    } 
	    // Convert binary to decimal
	    public static int binaryToDecimal(String binary) {
	        int decimal = 0;
	        int power = 0;
	        for (int i = binary.length() - 1; i >= 0; i--) {
	            int digit = binary.charAt(i) - '0';
	            decimal += digit * Math.pow(2, power);
	            power++;
	        }
	        return decimal;
	    }

	    // Convert fractional part from binary to decimal
	    public static double binaryToDecimalFractional(String binary) {
	        double decimal = 0;
	        for (int i = 0; i < binary.length(); i++) {
	            int digit = binary.charAt(i) - '0';
	            decimal += digit / Math.pow(2, i + 1);
	        }
	        return decimal;
	    }
	    public static String decimalToOctal(int decimal) {
	        StringBuilder octal = new StringBuilder();
	        while (decimal != 0) {
	            int remainder = decimal % 8;
	            octal.insert(0, remainder);
	            decimal /= 8;
	        }
	        return octal.toString();
	    }

	    // Convert fractional part from decimal to octal
	    public static String decimalToOctalFractional(double decimal) {
	        StringBuilder octal = new StringBuilder();
	        int precision = 5; // Limiting the precision to 5 digits after the decimal point
	        while (precision > 0) {
	            decimal *= 8;
	            int digit = (int) decimal;
	            octal.append(digit);
	            decimal -= digit;
	            precision--;
	        }
	        return octal.toString();
	    }
	    
	    // Convert decimal to octal

}
