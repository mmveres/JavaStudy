package eckeltests.ch13_string;

import static net.mindview.util.Print.print;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T13_PoemStartEnd {
	public static String input = "Twas brillig, and the slithy toves\n" + "Did gyre and gimble in the wabe.\n"
			+ "All mimsy were the borogoves,\n" + "And the mome raths outgrabe.\n\n"
			+ "Beware the Jabberwock, my son,\n" + "The jaws that bite, the claws that catch.\n"
			+ "Beware the Jubjub bird, and shun\n" + "The frumious Bandersnatch.";

	private static class Display {
		private boolean regexPrinted = false;
		private String regex;

		Display(String regex) {
			this.regex = regex;
		}

		void display(String message) {
			if (!regexPrinted) {
				print(regex);
				regexPrinted = true;
			}
			print(message);
		}
	}

	static void examine(String s, String regex) {
		Display d = new Display(regex);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		while (m.find())
			d.display("find() '" + m.group() + "' start = " + m.start() + " end = " + m.end());
		if (m.lookingAt()) // No reset() necessary
			d.display("lookingAt() start = " + m.start() + " end = " + m.end());
		if (m.matches()) // No reset() necessary
			d.display("matches() start = " + m.start() + " end = " + m.end());
	}

	public static void main(String[] args) {
		for (String in : input.split("\n")) {
			print("input : " + in);
			for (String regex : new String[] { "\\w*ere\\w*", "\\w*ever", "T\\w+", "^[A-Z][\\w^[\\s]]+" })
				examine(in, regex);
		}
	}
}
