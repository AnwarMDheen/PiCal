package com.example.navi_bar;
import java.util.Scanner;
public class binaryconverter {
	/*public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter a binary number: ");
			String binary = scanner.nextLine();

         	double decimal = convertBinaryToDecimal(binary);
		   System.out.println("Decimal representation: " + decimal);  
        	System.out.print("Enter a binary number: "); 
        	 binary = scanner.nextLine();

			String hexadecimal = convertBinaryToHexadecimal(binary);
			System.out.println("Hexadecimal representation: " + hexadecimal);  
			String binaryNumber = "-1101.1001";

	        String octalNumber = binaryToOctal(binaryNumber);
	        System.out.println("Octal equivalent: " + octalNumber);
			
		}
    }*/

    public  static double convertBinaryToDecimal(String binary) {
        int integerPart = 0;
        double fractionalPart = 0;
        int sign = 1;

        // Handling negative sign
        if (binary.charAt(0) == '-') {
            sign = -1;
            binary = binary.substring(1);
        }

        // Splitting the binary number into integer and fractional parts
        if (binary.contains(".")) {
            String[] parts = binary.split("\\.");
            binary = parts[0];
            fractionalPart = convertFractionalPart(parts[1]);
        }

        // Calculating the integer part
        int length = binary.length();
        for (int i = length - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                int power = length - i - 1;
                integerPart += Math.pow(2, power);
            }
        }

        // Combining the integer and fractional parts with the sign
        double decimal = sign * (integerPart + fractionalPart);
        return decimal;
    }

    public static double convertFractionalPart(String fraction) {
        int length = fraction.length();
        double result = 0;

        for (int i = 0; i < length; i++) {
            if (fraction.charAt(i) == '1') {
                int power = -(i + 1);
                result += Math.pow(2, power);
            }
        }

        return result;
    } 
    public static String convertBinaryToHexadecimal(String binary) {
        int sign = 1;
        int integerPart = 0;
        double fractionalPart = 0;

        // Handling negative sign
        if (binary.charAt(0) == '-') {
            sign = -1;
            binary = binary.substring(1);
        }

        // Splitting the binary number into integer and fractional parts
        if (binary.contains(".")) {
            String[] parts = binary.split("\\."); 
            binary = parts[0];
            fractionalPart = convertFractionalPart1(parts[1]);
        }

        // Calculating the integer part
        int length = binary.length();
        for (int i = length - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                int power = length - i - 1;
                integerPart += Math.pow(2, power);
            }
        }
        // Combining the integer and fractional parts with the sign
        double decimal =  (integerPart + fractionalPart);
        String hexadecimal = " "; 
        if(sign == -1) 
        { 
        	hexadecimal +="-";
        }
        // Converting decimal to hexadecimal
        hexadecimal +=Integer.toHexString((int) decimal).toUpperCase(); 
        if (fractionalPart != 0) {
            hexadecimal+=(".");
            for (int i = 0; i < 6; i++) {
                fractionalPart *= 16;
                int digit = (int) fractionalPart;
                 hexadecimal+=(Integer.toHexString(digit).toUpperCase());
                fractionalPart -= digit;
            }
        }

        return hexadecimal;
    }

    public static double convertFractionalPart1(String fraction) {
        int length = fraction.length();
        double result = 0;

        for (int i = 0; i < length; i++) {
            if (fraction.charAt(i) == '1') {
                int power = -(i + 1);
                result += Math.pow(2, power);
            }
        }
        return result;
    }  
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

    // Convert decimal to octal
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
    
}


