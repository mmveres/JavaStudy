package eckeltests.ch13_string;

class RegExChecker {
	
	
	static boolean isInput(String input){
		return input.matches("the");
	}
	static boolean isInteger(String input){
		return input.matches("(-|\\+)?\\d+");
	}
	static boolean isReal(String input){
		return input.matches("(-|\\+)?\\d+\\.\\d");
	}
	static boolean isNegativeOctal(String input){
		return input.matches("-[0-7]*");
	}
	static boolean isPositiveBinary(String input){
		return input.matches("\\+?[0-1]*");
	}
	static boolean isHexadecimal(String input){
		return input.matches("(-|\\+)?(0x|0X)[0-9a-fA-F]*");
	}
	static boolean isHHMMSS(String input){
		return input.matches("([0-1][0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]");
	}
	static boolean isDDMM20YY(String input){
		return input.matches("(0[1-9]|[1-2][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.20\\d{2}");
	}
	static boolean isKievCityNumber(String input){
		return input.matches("(\\+38(\\s)?)?044\\s?[1-9]\\d{6}");
	}
}


public class T01_URiseTask {
	private static String test;
	public static void main(String[] args) {
System.out.println("=== Input test ===");
test="rock the shit";
System.out.println(test + " "+ RegExChecker.isInput(test));
System.out.println("=== Integer test ===");
test="+8000";
System.out.println(test + " "+ RegExChecker.isInteger(test));
System.out.println("=== Real test ===");
test="+8000.0";
System.out.println(test + " "+ RegExChecker.isReal(test));
System.out.println("=== Negative Octal test ===");
test="-712345674";
System.out.println(test + " "+ RegExChecker.isNegativeOctal(test));
System.out.println("=== Positive Binary test ===");
test="+10100101110";
System.out.println(test + " "+ RegExChecker.isPositiveBinary(test));
System.out.println("=== Hexadecimal test ===");
test="-0x12af9";
System.out.println(test + " "+ RegExChecker.isHexadecimal(test));
System.out.println("=== HHMMSS test ===");
test="00:00:00";
System.out.println(test + " "+ RegExChecker.isHHMMSS(test));
System.out.println("=== DDMM20YY test ===");
test="31.02.2099";
System.out.println(test + " "+ RegExChecker.isDDMM20YY(test));
System.out.println("=== KievCityNumber test ===");
test="+38 044 1233545";
System.out.println(test + " "+ RegExChecker.isKievCityNumber(test));
	}

}
