package jabber.advanced;

//: c15:JabberClient.java
//Очень простой клиент, который просто посылает
//строки на сервер и читает строки,
//посылаемые сервером.
//{RunByHand}
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.io.*;

public class JabberClient {
	private static int port_counter=60_000;
	private final int clPrt;

	public JabberClient() {
		this(port_counter++);
	}
	
	public JabberClient(int clPrt) {
		this.clPrt = clPrt;
	}
	

	

	public static void main(String[] args) throws IOException {
		// if (args.length < 1) {
		// System.out.println("Usage: java JabberClient1 <client-port>");
		// System.exit(1);
		// }
		// int clPrt = Integer.parseInt(args[0]);
		new JabberClient(60002).start();
	}

	public void start() throws IOException {
		SocketChannel sc = SocketChannel.open();
		Selector sel = Selector.open();
		try {
			sc.configureBlocking(false);
			sc.socket().bind(new InetSocketAddress(clPrt));
			sc.register(sel, SelectionKey.OP_READ | SelectionKey.OP_WRITE | SelectionKey.OP_CONNECT);
			int i = 0;
			// По причине ассинхронной природы, вы не знаете
			// когда чтение и запись закончены, поэтому вам необходимо
			// следить за этим, переменная boolean written используется для
			// переключения между чтением и записью. Во время записи
			// отосланные назад символы должны быть прочитаны.
			// Переменная boolean done используется для проверки, когда нужно
			// прервать цикл.
			boolean written = false, done = false;
			// JabberServer.java, которому этот клиент подсоединяется, пишет с
			// помощью
			// BufferedWriter.println(). Этот метод выполняет
			// перекодировку в соответствии с кодовой страницей по умолчанию
			String encoding = System.getProperty("file.encoding");
			Charset cs = Charset.forName(encoding);
			ByteBuffer buf = ByteBuffer.allocate(16);
			BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
			while (!done) {
				sel.select();
				Iterator it = sel.selectedKeys().iterator();
				while (it.hasNext()) {
					SelectionKey key = (SelectionKey) it.next();
					it.remove();
					sc = (SocketChannel) key.channel();
					if (key.isConnectable() && !sc.isConnected()) {
						InetAddress addr = InetAddress.getByName(null);
						boolean success = sc.connect(new InetSocketAddress(addr, MultiJabberServer.PORT));
						if (!success)
							sc.finishConnect();
					}
					if (key.isReadable() && written) {
						if (sc.read((ByteBuffer) buf.clear()) > 0) {
							written = false;
							String response = cs.decode((ByteBuffer) buf.flip()).toString();
							System.out.print(response);
							if (response.indexOf("END") != -1)
								done = true;
						}
					}
					if (key.isWritable() && !written) {
						sc.write(ByteBuffer.wrap(kbd.readLine().getBytes()));
						written = true;

					}
				}
			}
		} finally {
			sc.close();
			sel.close();
		}

	}

}