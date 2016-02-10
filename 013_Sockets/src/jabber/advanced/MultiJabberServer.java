package jabber.advanced;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class MultiJabberServer {
	public static final int PORT = 8080;
	   private static String encoding = System.getProperty("file.encoding");
	   public static final Charset CS = Charset.forName(encoding);
	   // Создаем пул нитей с 10 рабочими нитями.
	   private static ThreadPool pool = new ThreadPool(10);
	   
	   public static void main(String[] args) throws IOException {
	      ServerSocketChannel ssc = ServerSocketChannel.open();
	      Selector sel = Selector.open();
	      try {
	         ssc.configureBlocking(false);
	         ssc.socket().bind(new InetSocketAddress(PORT));
	         SelectionKey key = ssc.register(sel, SelectionKey.OP_ACCEPT);
	         System.out.println("Server on port: " + PORT);
	         while (true) {
	            sel.select();
	            Iterator it = sel.selectedKeys().iterator();
	            while (it.hasNext()) {
	               SelectionKey skey = (SelectionKey) it.next();
	               it.remove();
	               if (skey.isAcceptable()) {
	                  SocketChannel channel = ssc.accept();
	                  System.out.println("Accepted connection from:"
	                        + channel.socket());
	                  channel.configureBlocking(false);
	                  // Отделяем события и ассоциированное действие
	                  pool.addTask(new ServeOneJabber(channel));
	               }
	            }
	         }
	      }
	      finally {
	         ssc.close();
	         sel.close();
	      }
	   }

}
