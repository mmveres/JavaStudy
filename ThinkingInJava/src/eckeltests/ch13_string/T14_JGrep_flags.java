//: strings/JGrep.java
// A very simple version of the "grep" program.
// {Args: JGrep.java "\\b[Ssct]\\w+"}
package eckeltests.ch13_string;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.regex.*;
import net.mindview.util.*;

public class T14_JGrep_flags {
	public static void main(String[] args) {
		String file = "/home/d2e/workspace/ThinkingInJava/src/eckeltests/ch10_innerclasses/t23/GreenhouseControls.java";
		String regex = "system";
		String pattern_flag = "Pattern.CASE_INSENSITIVE";
		String[] input = { file, regex, pattern_flag };

		try {
			Grep.doGrep(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static class Grep {
		public static void doGrep(String[] args) throws Exception {
			int i = 0;
			boolean correct_flag=false;

			if (args.length < 3) {
				System.out.println("Usage: java JGrep file regex PATTERN_FLAG");
				System.exit(0);
			}
			String[] flags = new String[Pattern.class.getFields().length];
			for (Field field : Pattern.class.getFields()) {
				flags[i++] = field.toString().replaceFirst("public static final int java.util.regex.", "");
			}
			for (String string : flags) {
				System.out.println(string + " "+ args[2]);
				if (string.equals(args[2])){correct_flag=true;}
			}
			if(!correct_flag){
				System.out.println("Incorrect falg received!");
				System.exit(0);}

			Pattern p = Pattern.compile(args[1]);
			// Pattern p = Pattern.compile(args[1], args[2]);
			// Iterate through the lines of the input file:
			int index = 0;
			Matcher m = p.matcher("");
			for (String line : new TextFile(args[0])) {
				m.reset(line);
				while (m.find())
					System.out.println(index++ + ": " + m.group() + ": " + m.start());
			}
		}

	}
}


