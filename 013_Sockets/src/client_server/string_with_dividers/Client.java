package client_server.string_with_dividers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import client_server.one_by_one.Server;

public class Client {
	private Socket sock = null;
	private PrintWriter out = null;
	private BufferedReader in = null;

	// конструктор
	public Client(String ip, int port) throws IOException {
		// Устанавливаем соединение
		sock = new Socket(ip, port);
		// Получаем потоки ввода-вывода
		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		out = new PrintWriter(sock.getOutputStream(), true);
	}

	// отправить запрос серверу и получить ответ
	private int sendQuery(int operation, int value1, int value2) throws IOException {
		// формирую запрос
		String query = operation + "#" + value1 + "#" + value2;
		// отправляю запрос
		out.println(query);
		// получаю ответ
		String response = in.readLine();
		String[] fields = response.split("#");
		if (fields.length != 2)
			throw new IOException("Invalid response from server");
		try {
			// Код завершения
			int comp_code = Integer.valueOf(fields[0]);
			// Результат операции
			int result = Integer.valueOf(fields[1]);
			if (comp_code == 0)
				return result;
			else
				throw new IOException("Error while processing query");
		} catch (NumberFormatException e) {
			throw new IOException("Invalid response from server");
		}
	}

	// посчитать сумму чисел

	public int sum(int value1, int value2) throws IOException {
		return sendQuery(Server.ADD, value1, value2);
	}

	// посчитать разность чисел
	public int sub(int value1, int value2) throws IOException {
		return sendQuery(Server.SUBTRACT, value1, value2);
	}

	// посчитать разность чисел
	public int mult(int value1, int value2) throws IOException {
		return sendQuery(Server.MULTIPLY, value1, value2);
	}

	// посчитать разность чисел
	public int divide(int value1, int value2) throws IOException {
		return sendQuery(Server.DIVIDE, value1, value2);
	}

	// отсоединиться
	public void disconnect() throws IOException {
		sock.close();
	}

	// главный метод
	public static void main(String[] args) {
		try {
			Client client = new Client("localhost", 12345);
			System.out.println(client.sum(25, 3));
			System.out.println(client.mult(20, 3));
			System.out.println(client.divide(20, 2));
			System.out.println(client.sub(32, 32));
			client.disconnect();
		} catch (IOException e) {
			System.out.println("Возникла ошибка");
			e.printStackTrace();
		}
	}
}
