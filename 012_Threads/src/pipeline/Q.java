package pipeline;

public class Q {
	public static void main(String[] args) {
//		MyPipeleine c = new MyPipeleine();
//		Node producer = new Node(null, c, 1);
//		Node consumer = new Node(c,null, 1);
		
		MyPipeleine pl1 = new MyPipeleine();
		MyPipeleine pl2 = new MyPipeleine();
		MyPipeleine pl3 = new MyPipeleine();
		Node producer = new Node(null, pl1, 1);
		Node node01 = new Node(pl1, pl2, 1);
		Node node02 = new Node(pl2, pl3, 2);
		Node consumer = new Node(pl3,null, 10);


	}
}

class MyPipeleine {
	private int contents;
	private boolean available = false;

	public synchronized int get() {
		while (available == false) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Node " + Thread.currentThread().getId()+ " got " + contents );
		available = false;
		notify();
//		notifyAll(); - if work in parallel
		return contents;
	}

	public synchronized void put(int value) {
		while (available == true) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Node " + Thread.currentThread().getId()+ " put " + value );
		contents = value;
		available = true;
		notify();
//		notifyAll(); - if work in parallel
	}
}


class Node implements Runnable {
	private MyPipeleine from;
	private MyPipeleine to;
	private int number;

	public Node( MyPipeleine from, MyPipeleine to, int number) {
		this.to = to;
		this.from=from;
		this.number = number;
		new Thread(this).start();
	}

	public void run() {
		if (from==null&&to!=null){
			int i = 0;
			while (i<25) {
				to.put(i);
				i++;
			}
			to.put(-1);
		}if(to==null&&from!=null){
			int value = 0;
			while (value>-1) {
				value = from.get();
				
			}
		}else{
			int value = 0;
			while (value>-1) {
				if(from==null)break;
				value = from.get();			
				to.put(value);

			}
		}
	}
}
