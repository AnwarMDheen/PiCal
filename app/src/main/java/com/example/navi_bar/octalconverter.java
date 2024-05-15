package com.example.navi_bar;

public class octalconverter {
//	public static void main(String[] args) {
//	        String octalNumber = "-65";
//	        String binaryNumber = octalToBinary(octalNumber);
//	        System.out.println("Binary equivalent: " + binaryNumber);
//	        double decimalNumber = octalToDecimal(octalNumber);
//	        System.out.println("Decimal equivalent: " + decimalNumber);
//	        String hexadecimalNumber = octalToHexadecimal(octalNumber);
//	        System.out.println("Hexadecimal equivalent: " + hexadecimalNumber);
//	    }

	public static String octalToBinary(String octalNumber) {
		String binaryNumber;
		// Checking if the number is negative
		boolean isNegative = false;
		if (octalNumber.charAt(0) == '-') {
			isNegative = true;
			octalNumber = octalNumber.substring(1); // Remove the negative sign
		}

		// Checking if the number is floating-point
		boolean isFloatingPoint = false;
		if (octalNumber.contains(".")) {
			isFloatingPoint = true;
		}
		if(isFloatingPoint)
		{

			// Splitting the octal number into whole and fractional parts
			String[] parts = octalNumber.split("\\.");
			String wholePart = parts[0];
			String fractionalPart = parts[1];

			// Convert whole part from octal to binary
			String binaryWholePart = octalToBinaryWhole(wholePart);

			// Convert fractional part from octal to binary
			String binaryFractionalPart = octalToBinaryFractional(fractionalPart);

			// Combining the binary parts
			binaryNumber = binaryWholePart + "." + binaryFractionalPart;
		}
		else
		{
			binaryNumber=octalToBinaryWhole(octalNumber);
		}

		// Handling negative sign
		if (isNegative) {
			binaryNumber = "-" + binaryNumber;
		}

		return binaryNumber;
	}

	// Convert whole part from octal to binary
	public static String octalToBinaryWhole(String octal) {
		StringBuilder binary = new StringBuilder();
		for (int i = 0; i < octal.length(); i++) {
			char octalDigit = octal.charAt(i);
			int decimal = Integer.parseInt(String.valueOf(octalDigit));
			String binaryDigit = Integer.toBinaryString(decimal);
			binary.append(String.format("%3s", binaryDigit).replace(' ', '0'));
		}
		return binary.toString();
	}

	// Convert fractional part from octal to binary
	public static String octalToBinaryFractional(String octal) {
		StringBuilder binary = new StringBuilder();
		for (int i = 0; i < octal.length(); i++) {
			char octalDigit = octal.charAt(i);
			int decimal = Integer.parseInt(String.valueOf(octalDigit));
			String binaryDigit = Integer.toBinaryString(decimal);
			binary.append(binaryDigit);
		}
		return binary.toString();
	}
	public static double octalToDecimal(String octalNumber) {
		double decimalNumber;
		// Checking if the number is negative
		boolean isNegative = false;
		if (octalNumber.charAt(0) == '-') {
			isNegative = true;
			octalNumber = octalNumber.substring(1); // Remove the negative sign
		}

		// Checking if the number is floating-point
		boolean isFloatingPoint = false;
		if (octalNumber.contains(".")) {
			isFloatingPoint = true;
		}
		if(isFloatingPoint)
		{
			// Splitting the octal number into whole and fractional parts
			String[] parts = octalNumber.split("\\.");
			String wholePart = parts[0];
			String fractionalPart = parts[1];

			// Convert whole part from octal to decimal
			int decimalWholePart = octalToDecimalWhole(wholePart);

			// Convert fractional part from octal to decimal
			double decimalFractionalPart = octalToDecimalFractional(fractionalPart);

			// Combining the decimal parts
			decimalNumber = decimalWholePart + decimalFractionalPart;
		}
		else
		{
			decimalNumber=octalToDecimalWhole(octalNumber);
		}
		// Handling negative sign
		if (isNegative) {
			decimalNumber = -decimalNumber;
		}

		return decimalNumber;
	}

	// Convert whole part from octal to decimal
	public static int octalToDecimalWhole(String octal) {
		int decimal = 0;
		for (int i = 0; i < octal.length(); i++) {
			char octalDigit = octal.charAt(i);
			int digit = Character.getNumericValue(octalDigit);
			decimal = decimal * 8 + digit;
		}
		return decimal;
	}

	// Convert fractional part from octal to decimal
	public static double octalToDecimalFractional(String octal) {
		double decimal = 0;
		for (int i = 0; i < octal.length(); i++) {
			char octalDigit = octal.charAt(i);
			int digit = Character.getNumericValue(octalDigit);
			decimal = decimal * 8 + digit;
		}
		int length = octal.length();
		decimal = decimal / Math.pow(8, length);
		return decimal;
	}
	public static String octalToHexadecimal(String octalNumber) {
		// Checking if the number is negative
		boolean isNegative = false;
		if (octalNumber.charAt(0) == '-') {
			isNegative = true;
			octalNumber = octalNumber.substring(1); // Remove the negative sign
		}

		// Checking if the number is floating-point
		boolean isFloatingPoint = false;
		if (octalNumber.contains(".")) {
			isFloatingPoint = true;
		}

		// Splitting the octal number into whole and fractional parts
		String[] parts = octalNumber.split("\\.");
		String wholePart = parts[0];
		String fractionalPart = "";
		if (isFloatingPoint) {
			fractionalPart = parts[1];
		}
		// System.out.println(isFloatingPoint +" " +fractionalPart);
		// Convert whole part from octal to hexadecimal
		String hexadecimalWholePart = octalToHexadecimalWhole(wholePart);

		// Convert fractional part from octal to hexadecimal
		String hexadecimalFractionalPart = "";
		if (isFloatingPoint) {
			hexadecimalFractionalPart = octalToHexadecimalFractional(fractionalPart);
		}

		// Combining the hexadecimal parts
		String hexadecimalNumber = hexadecimalWholePart;
		if (isFloatingPoint) {
			hexadecimalNumber += "." + hexadecimalFractionalPart;
		}

		// Handling negative sign
		if (isNegative) {
			hexadecimalNumber = "-" + hexadecimalNumber;
		}

		return hexadecimalNumber;
	}

	// Convert whole part from octal to hexadecimal
	public static String octalToHexadecimalWhole(String octal) {
		int decimal = 0;
		for (int i = 0; i < octal.length(); i++) {
			char octalDigit = octal.charAt(i);
			int digit = Character.getNumericValue(octalDigit);
			decimal = decimal * 8 + digit;
		}
		return Integer.toHexString(decimal);
	}

	// Convert fractional part from octal to hexadecimal
	public static String octalToHexadecimalFractional(String octal) {
		int value= Integer.parseInt(octal);
		int val1=Integer.parseInt(octal,8);
		String val=Integer.toBinaryString(val1);
		int len=val.length();
		if(len/4 !=0)
		{
			len=len%4;
		}
		for(int i=0;i<len;i++)
		{
			val +="0";
		}
		String s1,s2;
		s2=" ";
		s1=val.substring(0,4);
		if(val.length()>=8)
		{
			s2=val.substring(4,8);
		}
		String ret=" ";
		int i1,i2;
		i1=Integer.parseInt(s1,2);

		ret +=Integer.toHexString(i1);
		if(val.length()>=8)
		{
			i2=Integer.parseInt(s2,2);
			ret +=Integer.toHexString(i2);
		}

		return ret.toUpperCase();
	}

}


