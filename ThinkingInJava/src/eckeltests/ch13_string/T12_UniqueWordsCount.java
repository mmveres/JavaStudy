package eckeltests.ch13_string;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T12_UniqueWordsCount {
	static public final String POEM = "Twas brillig, and the slithy toves\n" + "Did gyre and gimble in the wabe.\n"
			+ "All mimsy were the borogoves,\n" + "And the mome raths outgrabe.\n\n"
			+ "Beware the Jabberwock, my son,\n" + "The jaws that bite, the claws that catch.\n"
			+ "Beware the Jubjub bird, and shun\n" + "The frumious Bandersnatch.";

	public static void main(String[] args) {
		int unique = 0;
		int word_count=0;
//		System.out.println(POEM);
		Matcher m = Pattern.compile("\\b[a-z][\\w]+")
				// Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$")
				.matcher(POEM);
		
		while (m.find()) {
			System.out.println(++word_count);
			System.out.println(m.group());
			Matcher m2 = Pattern.compile(m.group()).matcher(POEM);
			if(!m2.find(m.end())){++unique;}
			
		}
		System.out.println("Unique: "+ unique);
	}
}
