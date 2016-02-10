package eckeltests.ch13_string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.midi.Soundbank;

public class T11_Arline {
	private static Pattern p;
	private static Matcher m;

	public static void main(String[] args) {
		String input = "Arline ate eight apples and one orange while Anita hadn't any";
		p = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b ");
		m = p.matcher(input);
		while (m.find()) {
			System.out.println(m.group() + " ");
		}

	}
}
