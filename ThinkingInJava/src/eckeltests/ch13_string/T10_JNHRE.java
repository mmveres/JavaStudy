package eckeltests.ch13_string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.midi.Soundbank;

public class T10_JNHRE {
	private static Pattern p;
	private static Matcher m;
	
	public static void main(String[] args) {
		String input="Java now has regular expressions";
		p=Pattern.compile("^Java");
		m=p.matcher(input);
		while(m.find()){
			System.out.println(m.group()+ " ");
		}
		p=Pattern.compile("reg.*");
		m=p.matcher(input);
		while(m.find()){
			System.out.println(m.group()+ " ");
		}
		p=Pattern.compile("n.w\\s+h(a|i)s");
		m=p.matcher(input);
		while(m.find()){
			System.out.println(m.group()+ " ");
		}
		p=Pattern.compile("s{0,3}");
		m=p.matcher(input);
		while(m.find()){
			System.out.println(m.group()+ " ");
		}
	}

}
