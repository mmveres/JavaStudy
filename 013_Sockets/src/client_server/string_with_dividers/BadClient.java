package client_server.string_with_dividers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BadClient {
	private Socket sock = null;
	private PrintWriter out = null;
	private BufferedReader in = null;

	public void test(String ip, int port) throws IOException {
		// Устанавливаем соединение
		sock = new Socket(ip, port);
		// Получаем потоки ввода-вывода
		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		out = new PrintWriter(sock.getOutputStream(), true);
		// Отправляю тестовые запросы, получаю ответы,
		// вывожу их на экран
		out.println("бубубу");
		System.out.println(in.readLine());
		out.println("xxx#yyy#zzz");
		System.out.println(in.readLine());
		out.println("10#20#30");
		System.out.println(in.readLine());
		out.println("0#5#7");
		System.out.println(in.readLine());
		out.println("1#5#7");
		System.out.println(in.readLine());
	}

	public static void main(String[] args) throws IOException {
		(new BadClient()).test("localhost", 12345);
	}
}
