package client_server.one_by_one;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	private Socket sock = null;
	private DataOutputStream out = null;
	private DataInputStream in = null;

	// конструктор
	public Client(String ip, int port) throws IOException {
		// Устанавливаем соединение
		sock = new Socket(ip, port);
		// Получаем потоки ввода-вывода
		in = new DataInputStream(sock.getInputStream());
		out = new DataOutputStream(sock.getOutputStream());
	}

	// отправить запрос серверу и получить ответ
	private int sendQuery(int operation, int value1, int value2) throws IOException {
		// отправляю запрос
		out.writeInt(operation);
		out.writeInt(value1);
		out.writeInt(value2);
		// получаю ответ
		int res = in.readInt();
		return res;
	}// посчитать сумму чисел

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
			System.out.println(client.sum(2, 3));
			System.out.println(client.mult(2, 3));
			System.out.println(client.divide(10, 2));
			System.out.println(client.sub(34, 32));
			client.disconnect();
		} catch (IOException e) {
			System.out.println("Возникла ошибка");
		}
	}

}
