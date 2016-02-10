package jabber.advanced;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class ServeOneJabber implements Runnable {
		   private SocketChannel channel;
		   private Selector sel;
		   
		   public ServeOneJabber(SocketChannel ch) throws IOException {
		      channel = ch;
		      sel = Selector.open();
		   }
		   
		   public void run() {
		      ByteBuffer buffer = ByteBuffer.allocate(16);
		      boolean read = false, done = false;
		      String response = null;
		      try {
		         channel.register(sel, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
		         while (!done) {
		            sel.select();
		            Iterator it = sel.selectedKeys().iterator();
		            while (it.hasNext()) {
		               SelectionKey key = (SelectionKey) it.next();
		               it.remove();
		               if (key.isReadable() && !read) {
		                  if (channel.read(buffer) > 0)
		                     read = true;
		                  CharBuffer cb = MultiJabberServer.CS
		                        .decode((ByteBuffer) buffer.flip());
		                  response = cb.toString();
		               }
		               if (key.isWritable() && read) {
		                  System.out.print("Echoing : " + response);
		                  channel.write((ByteBuffer) buffer.rewind());
		                  if (response.indexOf("END") != -1)
		                     done = true;
		                  buffer.clear();
		                  read = false;
		               }
		            }
		         }
		      }
		      catch (IOException e) {
		         // будет поймано Worker.java и залогировано.
		         // Необходимо выбросить исключение времени выполнения, так как мы не
		         // можем
		         // оставить IOException
		         throw new RuntimeException(e);
		      }
		      finally {
		         try {
		            channel.close();
		         }
		         catch (IOException e) {
		            System.out.println("Channel not closed.");
		            // Выбрасываем это, чтобы рабочая нить могла залогировать.
		            throw new RuntimeException(e);
		         }
		      }
		   }
		}

