package wordfq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	
	List<String> ll=new ArrayList<>();
	
	public static void main(String[] args) {

		String path = "/home/d2e/workspace/019_WordlFrequencyFromTextFile/src/main/test.txt";
		try {
			readFile(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// for (String a : args) {
		// Integer freq = m.get(a);
		// m.put(a, (freq == null) ? 1 : freq + 1);
		// }
		// System.out.println(m.size() + " distinct words:");
		// System.out.println(m);
	}

	private static void readFile(String path) throws FileNotFoundException, IOException {
		Map<String, Integer> m = new TreeMap<String, Integer>();
		String[] words;
		// create file object
		File file = new File(path);
		// open input stream for it
		FileInputStream fis = new FileInputStream(file);
		// create buffered reader from stream opened
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = null;
		// while we have new line in buffer - read it
		while ((line = br.readLine()) != null) {
			// array - splitted line by spaces
			words = line.split("\\s+");
			for (String string : words) {
				if (!string.equals("")) {
					Integer freq = m.get(string);
//					m.put(string.replaceAll("([^A-Za-zА-Яа-я])", "").toLowerCase(), (freq == null ? 1 : freq + 1));
					m.put(string.replaceAll("([^A-Za-zА-Яа-я])", ""), (freq == null ? 1 : freq + 1));

				}

			}
		}
		System.out.println(m.size() + " distinct words:");
		System.out.println(m);
	}
}

// Method 1:
//
// private static void readFile1(File fin) throws IOException {
// FileInputStream fis = new FileInputStream(fin);
//
// //Construct BufferedReader from InputStreamReader
// BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//
// String line = null;
// while ((line = br.readLine()) != null) {
// System.out.println(line);
// }
//
// br.close();
// }
// Method 2:
//
// private static void readFile2(File fin) throws IOException {
// // Construct BufferedReader from FileReader
// BufferedReader br = new BufferedReader(new FileReader(fin));
//
// String line = null;
// while ((line = br.readLine()) != null) {
// System.out.println(line);
// }
//
// br.close();
// }
