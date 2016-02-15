package client_server.one_by_one;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket server = null;
	private Socket sock = null;
	private DataOutputStream out = null;
	private DataInputStream in = null;
	public static final int ADD=0;
	public static final int SUBTRACT=1;
	public static final int MULTIPLY=2;
	public static final int DIVIDE=3;

	// запустить сервер
	public void start(int port) throws IOException {
		server = new ServerSocket(port);
		System.out.println("Int server started...");
		while (true) {
			// Принимаем соединение от нового клиента
			sock = server.accept();
			// Получаем потоки ввода-вывода
			in = new DataInputStream(sock.getInputStream());
			out = new DataOutputStream(sock.getOutputStream());
			// Пока соединение активно, обрабатываем запросы
			while (processQuery())
				;
		}
	}

	// обработка запроса
	private boolean processQuery() {
		try {
			// Получаю запрос от клиента
			int oper = in.readInt(); // Операция
			int v1 = in.readInt(); // Число 1
			int v2 = in.readInt(); // Число 2
			// Считаю результат
			int result=0;
			// Результат операции
			switch (oper) {
			case ADD:{
				result=v1+v2;
				break;}
			case SUBTRACT:{
				result=v1-v2;
				break;}
			case MULTIPLY:{
				result=v1*v2;
				break;}
			case DIVIDE:{
				result=v1/v2;
				break;}
			default:
				break;
			}
			// Отправляю результат клиенту
			out.writeInt(result);
			return true;
		} catch (IOException e) {
			return false;
		}
	}// главный метод

	public static void main(String[] args) {
		try {
			Server srv = new Server();
			srv.start(12345);
		} catch (IOException e) {
			System.out.println("Возникла ошибка");
		}
	}
}
