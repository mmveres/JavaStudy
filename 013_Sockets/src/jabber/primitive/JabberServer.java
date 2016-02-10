package jabber.primitive;

//: c15:JabberServer.java
// Очень простой сервер, который просто отсылает
// назад все, что посылает клиент.
// {RunByHand}
import java.io.*;

import java.net.*;

public class JabberServer {
	// Выбираем порт за пределами диапазона 1-1024:
	   public static final int PORT = 8080;
	   
	   public static void main(String[] args) throws IOException {
	      ServerSocket s = new ServerSocket(PORT);
	      System.out.println("Started: " + s);
	      try {
	         // Блокируем до возникновения соединения:
	         Socket socket = s.accept();
	         try {
	            System.out.println("Connection accepted: " + socket);
	            BufferedReader in = new BufferedReader(new InputStreamReader(
	                  socket.getInputStream()));
	            // Вывод автоматически выталкивается PrintWriter'ом:
	            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
	                  socket.getOutputStream()));
	            while (true) {
	               String str = in.readLine();
	               System.out.println("Echoing: " + str);
	               out.write(str, 0, str.length());
	               out.newLine();
	               out.flush();
	               if (str.equals("END"))
	                  break;
	            }
	            // Всегда закрываем два сокета...
	         }
	         finally {
	            System.out.println("closing...");
	            socket.close();
	         }
	      }
	      finally {
	         s.close();
	      }
	   }
	} // /:~