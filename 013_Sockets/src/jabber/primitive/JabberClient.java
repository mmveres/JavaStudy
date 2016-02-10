package jabber.primitive;

//: c15:JabberClient.java
//Очень простой клиент, который просто посылает
//строки на сервер и читает строки,
//посылаемые сервером.
//{RunByHand}
import java.net.*;
import java.io.*;

public class JabberClient {
public static void main(String[] args) throws IOException {
   // Передаем null в getByName(), получая
   // специальный IP адрес "локальной заглушки"
   // для тестирования на машине без сети:
   InetAddress addr = InetAddress.getByName(null);
   // Альтернативно, вы можете использовать
   // адрес или имя:
   // InetAddress addr =
   // InetAddress.getByName("127.0.0.1");
   // InetAddress addr =
   // InetAddress.getByName("localhost");
   System.out.println("addr = " + addr);
   Socket socket = new Socket("127.0.0.1", JabberServer.PORT);
   // Помещаем все в блок try-finally, чтобы
   // быть уверенным, что сокет закроется:
   try {
      System.out.println("socket = " + socket);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket
            .getInputStream()));
      // Вывод автоматически Output быталкивается PrintWriter'ом.
      PrintWriter out = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(socket.getOutputStream())), true);
      BufferedReader kbd=new BufferedReader(new InputStreamReader(System.in));
      String str="";
      while(!str.equals("END")){
               out.println(kbd.readLine());
         str = in.readLine();
         System.out.println(str);
      }
      out.println("END");
   }
   finally {
      System.out.println("closing...");
      socket.close();
   }
}
} // /:~
