package lab4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import lab4.MyResource.Generator;

/*Задача о читателях и писателях. Базу данных разделяют два типа процессов – читатели и писатели. 
 * Читатели выполняют транзакции, которые просматривают записи базы данных, 
 * транзакции писателей и просматривают и изменяют записи. 
Создать многопоточное приложение, работающее с общим файлом.
Для защиты операций с общим файлом использовать блокировки чтения-записи. 
Файл содержит последовательность записей вида: Ф.И.О.1 – телефон1, Ф.И.О.2 – телефон2… 
В приложении должны работать следующие потоки:
1) потоки, находящие телефоны по указанной фамилии; 
2) потоки, находящие Ф.И.О. по указанному телефону;
3) потоки, удаляющие и добавляющие записи в файл.*/

public class FileReadersWriters {

	public static void main(String[] args) {
		String filename = "/home/d2e/workspace/030_Threads_labs/src/lab4/db.txt";
		MyResource mfr = new MyResource(filename);
		ResourceWriter rw = new ResourceWriter(mfr, 0);

	ResourceReader rr01=new ResourceReader(mfr, ResourceReader.SEARCH_BY_NAME);
		ResourceReader rr02=new ResourceReader(mfr, ResourceReader.SEARCH_BY_PHONE);
		new Thread(rw).start();
		new Thread(rr01).start();
	new Thread(rr02).start();
	
		

	}

}

// add N random records to database, if N=0 works infinitely
class ResourceWriter implements Runnable {
	private static int counter = 1;
	private final int id;
	private MyResource myResourse;
	private int numOfRecords;

	public ResourceWriter(MyResource myResourse, int numOfRecords) {
		this.myResourse = myResourse;
		this.numOfRecords = numOfRecords;
		id = counter++;
	}

	@Override
	public void run() {
		int counter = 0;
		while (numOfRecords==0||counter < numOfRecords) {
			String name = Generator.getRandomPersonName();
			int number = (int) (Math.random() * 1_000_001);
			System.out.println("-------------------------------------------------------------- " + counter);
			System.out.println(toString()+ " is adding " + name + " - "+ number);
			myResourse.addRecord(name, number);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter++;
		}

	}

	@Override
	public String toString() {
		return "ResourceWriter [id=" + id + "]";
	}
	
	
}

// gets first N records from DB then imitates work, searching data either by
// Name or by PhoneNumber
class ResourceReader implements Runnable {
	private static int counter = 1;
	public static final int NUM_OF_RECORDS = 20;
	public static final int SEARCH_BY_PHONE = 1;
	public static final int SEARCH_BY_NAME = 2;
	private final int id;
	private MyResource myFileResource;
	private String[] lines;
	private String[] names;
	private int[] phoneNums;
	private int searchType;

	public ResourceReader(MyResource myFileResource, int searchType) {
		this.myFileResource = myFileResource;
		id = counter++;
		this.searchType = searchType;
		lines = myFileResource.getFirstLines(NUM_OF_RECORDS);
		names = new String[NUM_OF_RECORDS];
		phoneNums = new int[NUM_OF_RECORDS];
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].equals(""))
				continue;
			names[i] = lines[i].split("-")[0];
			phoneNums[i] = Integer.parseInt(lines[i].split("-")[1]);
		}

	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch (searchType) {
			case SEARCH_BY_NAME: {
				String name = names[(int) (Math.random() * names.length)];
				System.out.println("--------------------------------------------------------------");
				System.out.println(toString() + " is searching for phone number belonging to " + name);
				System.out.println("found " + myFileResource.getPhoneByName(name));
				break;
			}

			default: {
				int num = phoneNums[(int) (Math.random() * names.length)];
				System.out.println("--------------------------------------------------------------");
				System.out.println(toString() + " is searching for owner of number " + num);
				System.out.println("found " + myFileResource.getNameByPhone(num));
				break;

			}
			}

		}

	}

	@Override
	public String toString() {
		return "ResourceReader [id=" + id + "]";
	}

}

class MyResource {
	private String filename;
	private File file;
	private boolean occupied;

	public MyResource(String filename) {
		this.filename = filename;
		file = new File(filename);

	}

	public boolean isOccupied() {
		return occupied;
	}

	public synchronized void addRecord(String name, int phoneNum) {
		occupied = true;
		PrintWriter pw = null;
		String myName = name;
		int myPhoneNum = phoneNum;
		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			if (myName == null)
				myName = "DEFAULT";
			if (myPhoneNum < 0)
				myPhoneNum = myPhoneNum * -1;
			// pw.printf("%s-%010d", myName, myPhoneNum);
			pw.println(myName + "-" + myPhoneNum);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null)
				pw.close();
			occupied = true;
		}

	}

	public synchronized String getNameByPhone(int phoneNum) {
		occupied = true;
		String name = "NO_ENTRY_FOUND";
		BufferedReader br = null;
		FileReader fr;
		try {
			String line;
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String[] currentdata;
			while ((line = br.readLine()) != null) {
				currentdata = line.split("-");
				int curentNum = Integer.parseInt(currentdata[1]);
				if (curentNum == phoneNum) {
					name = currentdata[0];
					break;
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			occupied = false;
		}
		return name;
	}

	public synchronized String[] getFirstLines(int numOfLines) {
		occupied = true;
		String[] lines = new String[numOfLines];
		BufferedReader br = null;
		FileReader fr;
		try {
			String line;
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			int counter = 0;
			while (counter < numOfLines && (line = br.readLine()) != null) {
				lines[counter] = line;
				counter++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			occupied = false;
		}
		return lines;

	}

	public synchronized int getPhoneByName(String name) {
		occupied = true;
		int phone = 0;
		BufferedReader br = null;
		FileReader fr;
		try {
			String line;
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String[] currentdata;
			while ((line = br.readLine()) != null) {
				currentdata = line.split("-");
				if (currentdata[0].equals(name)) {
					phone = Integer.parseInt(currentdata[1]);
					break;
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			occupied = false;
		}
		return phone;
	}

	static class Generator {
		private static final String alphabet = "QWERTYUIOPASDFGHJKLZXCVBNM";
		private static final String firstNames = "JOHN MARY ANN LENA JEAN BORIS CHUCK BYNNY CLAUDE PAKO VLAD";
		private static final String secondNames = "SMITH DOE MARX HETFIELD ULRICH TRUHILLO ARAYA HANEMMAN KING GATES";

		static String getRandomPersonName() {
			String[] fNames = firstNames.split(" ");
			String[] sNames = secondNames.split(" ");
			return fNames[(int) (Math.random() * fNames.length)] + " " + sNames[(int) (Math.random() * sNames.length)];
		}

		static String getRandomString(int length) {
			char[] abcArray = alphabet.toCharArray();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < length; i++) {
				sb.append(abcArray[(int) (Math.random() * abcArray.length)]);

			}
			return sb.toString();
		}

	}

}