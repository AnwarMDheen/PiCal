package com.example.navi_bar;
//import java.util.Scanner;
public class decimalconverter {
	/*    public static void main(String[] args) {
	        try (Scanner scanner = new Scanner(System.in)) {
				System.out.print("Enter a decimal number: ");
				double decimal = scanner.nextDouble();

				String hexadecimal = convertDecimalToHexadecimal(decimal);
				System.out.println("Hexadecimal representation: " + hexadecimal);  
				
				System.out.print("Enter a decimal number: ");
				decimal= scanner.nextDouble();

				String binary = convertDecimalToBinary(decimal);
				System.out.println("Binary representation: " + binary); 
				 System.out.print("Enter a decimal number: ");
			         decimal = scanner.nextDouble();

			        String octal = convertDecimalToOctal(decimal);
			        System.out.println("Octal representation: " + octal);
			}
	    }*/

	    public static String convertDecimalToHexadecimal(double decimal) {
	        long wholePart = (long) decimal;
	        double fractionalPart = decimal - wholePart;

	        StringBuilder result = new StringBuilder();
	        if (wholePart == 0) {
	            result.append("0");
	        } else if (wholePart < 0) {
	            result.append("-");
	            wholePart = Math.abs(wholePart);
	        }

	        result.append(Long.toHexString(wholePart).toUpperCase());

	        if (fractionalPart != 0) {
	            result.append(".");
	            for (int i = 0; i < 6; i++) {
	                fractionalPart *= 16;
	                int digit = (int) fractionalPart;
	                result.append(Integer.toHexString(digit).toUpperCase());
	                fractionalPart -= digit;
	            }
	        }

	        return result.toString();
	    } 
	        public  static String convertDecimalToBinary(double decimal) {
	            long wholePart = (long) decimal;
	            double fractionalPart = decimal - wholePart;
                 fractionalPart=Math.abs(fractionalPart);
	            StringBuilder result = new StringBuilder();
	            if (wholePart == 0) {
	                result.append("0");
	            } else if (wholePart < 0) {
	                result.append("-");
	                wholePart = Math.abs(wholePart);
	            }

	            result.append(Long.toBinaryString(wholePart));

	            if (fractionalPart != 0) {
	                result.append(".");
	                for (int i = 0; i < 6; i++) {
	                    fractionalPart *= 2;
	                    int digit = (int) fractionalPart;
	                    result.append(digit);
	                    fractionalPart -= digit;
	                }
	            }
	            return result.toString();
	        } 
	        public static String convertDecimalToOctal(double decimal) {
	            long wholePart = (long) decimal;
	            double fractionalPart = decimal - wholePart;
                  fractionalPart=Math.abs(fractionalPart);
	            StringBuilder result = new StringBuilder();
	            if (wholePart == 0) {
	                result.append("0");
	            } else if (wholePart < 0) {
	                result.append("-");
	                wholePart = Math.abs(wholePart);
	            }

	            result.append(Long.toOctalString(wholePart));

	            if (fractionalPart != 0) {
	                result.append(".");
	                for (int i = 0; i < 6; i++) {
	                    fractionalPart *= 8;
	                    int digit = (int) fractionalPart;
	                    result.append(digit);
	                    fractionalPart -= digit;
	                }
	            }

	            return result.toString();
	        }
	    }


