package jabber.advanced;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Worker extends Thread {
	   public static final Logger logger = Logger.getLogger("Worker");
	   private String workerId;
	   private Runnable task;
	   // Необходима ссылка на пул нитей в котором существует нить, чтобы
	   // нить могла добавить себя в пул нитей по завершению работы.
	   private ThreadPool threadpool;
	   static {
	      try {
	         logger.setUseParentHandlers(false);
	         FileHandler ferr = new FileHandler("WorkerErr.log");
	         ferr.setFormatter(new SimpleFormatter());
	         logger.addHandler(ferr);
	      }
	      catch (IOException e) {
	         System.out.println("Logger not initialized..");
	      }
	   }
	   
	   public Worker(String id, ThreadPool pool) {
	      workerId = id;
	      threadpool = pool;
	      start();
	   }
	   
	   // ThreadPool, когда ставит в расписание задачу, использует этот метод
	   // для делегирования задачи Worker-нити. Кроме того для установки
	   // задачи (типа Runnable) он также переключает ожидающий метод
	   // run() на начало выполнения задачи.
	   public void setTask(Runnable t) {
	      task = t;
	      synchronized (this) {
	         notify();
	      }
	   }
	   
	   public void run() {
	      try {
	         while (!threadpool.isStopped()) {
	            synchronized (this) {
	               if (task != null) {
	                  try {
	                     task.run(); // Запускаем задачу
	                  }
	                  catch (Exception e) {
	                     logger.log(Level.SEVERE,
	                           "Exception in source Runnable task", e);
	                  }
	                  // Возвращает себя в пул нитей
	                  threadpool.putWorker(this);
	               }
	               wait();
	            }
	         }
	         System.out.println(this + " Stopped");
	      }
	      catch (InterruptedException e) {
	         throw new RuntimeException(e);
	      }
	   }
	   
	   public String toString() {
	      return "Worker : " + workerId;
	   }
	}