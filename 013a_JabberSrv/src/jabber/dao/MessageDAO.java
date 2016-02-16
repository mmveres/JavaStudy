package jabber.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jabber.entities.Message;
import jabber.entities.User;

public class MessageDAO {
	
	// Вспомогательный метод получения соединения
	private Connection getConnection() throws Exception {

		// Подгрузка драйвера БД Derby
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		// Получение соединения с БД
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/Jabber", "root", "Suchi2015");
	}
	
	/**
	 * Добавляет новое сообщение
	 * 
	 * @param userIDFrom, userIDTo, message
	 * @throws Exception
	 */
	public void addMessage(int userIDFrom,int userIDTo, String message) throws Exception {
		// Получение соединения с БД
		Connection con = getConnection();
		// Подготовка SQL-запроса
		PreparedStatement st = con.prepareStatement(
				"Insert into Messages (idUsers, MessageText, DateTime, idTo) " + "values (?, ?, ?, ?)");
		// Указание значений параметров запроса
		st.setInt(1, userIDFrom);
		st.setString(2, message);
		st.setDate(2, new Date(System.currentTimeMillis()));
		st.setInt(4, userIDTo);
		// Выполнение запроса
		st.executeUpdate();
		con.close();
	}
	
	/**
	 * Удаляет сообщение
	 * 
	 * @param idMessage
	 * @throws Exception
	 */
	public void removeMessage(int idMessage) throws Exception {
		// Получение соединения с БД
		Connection con = getConnection();
		// Подготовка SQL-запроса
		PreparedStatement st = con.prepareStatement("Delete from Messages Where idMessages = ?");
		// Указание значений параметров запроса
		st.setInt(1, idMessage);
		// Выполнение запроса
		st.executeUpdate();
		con.close();
	}
	
	/**
	 * Удаляет сообщение от пользователя
	 * 
	 * @param idMessage
	 * @throws Exception
	 */
	public void removeMessagesFrom(int idUser) throws Exception {
		// Получение соединения с БД
		Connection con = getConnection();
		// Подготовка SQL-запроса
		PreparedStatement st = con.prepareStatement("Delete from Messages Where idUsers = ?");
		// Указание значений параметров запроса
		st.setInt(1, idUser);
		// Выполнение запроса
		st.executeUpdate();
		con.close();
	}
	
	/**
	 * Удаляет сообщение к пользователю
	 * 
	 * @param idMessage
	 * @throws Exception
	 */
	public void removeMessagesTo(int idUser) throws Exception {
		// Получение соединения с БД
		Connection con = getConnection();
		// Подготовка SQL-запроса
		PreparedStatement st = con.prepareStatement("Delete from Messages Where idTo = ?");
		// Указание значений параметров запроса
		st.setInt(1, idUser);
		// Выполнение запроса
		st.executeUpdate();
		con.close();
	}
	
	
	/**
	 * возвращает набор сообщений от пользователя
	 * 
	 * @param idMessage
	 * @throws Exception
	 */
	public List<Message> findMessagesfromUser(int idUser) throws Exception{
		List<Message> messages = new ArrayList<>();
		// Получение соединения с БД
		Connection con = getConnection();
		// Подготовка SQL-запроса
		PreparedStatement st = con.prepareStatement("Select * from Messages Where idUsers = ?");
		// Указание значений параметров запроса
		st.setInt(1, idUser);
		// Выполнение запроса
		ResultSet rs = st.executeQuery();
		// Перечисляем результаты выборки
		while (rs.next()) {
			// Из каждой строки выборки выбираем результаты,// формируем новый
			// объект Product
			// и помещаем его в коллекцию
			int idMsg = rs.getInt(1);
			String message = rs.getString(2);
			Date date=rs.getDate(4);
			int idTo=rs.getInt(5);
			messages.add(new Message(idUser, idTo, date, message));
		}
		// Закрываем выборку и соединение с БД
		rs.close();
		con.close();
		return messages;
		
	}
	
	/**
	 * возвращает набор сообщений к пользователю
	 * 
	 * @param idMessage
	 * @throws Exception
	 */
	public List<Message> findMessagesToUser(int idUser) throws Exception{
		List<Message> messages = new ArrayList<>();
		// Получение соединения с БД
		Connection con = getConnection();
		// Подготовка SQL-запроса
		PreparedStatement st = con.prepareStatement("Select * from Messages Where idTo = ?");
		// Указание значений параметров запроса
		st.setInt(1, idUser);
		// Выполнение запроса
		ResultSet rs = st.executeQuery();
		// Перечисляем результаты выборки
		while (rs.next()) {
			// Из каждой строки выборки выбираем результаты,// формируем новый
			// объект Product
			// и помещаем его в коллекцию
			int idMsg = rs.getInt(1);
			String message = rs.getString(2);
			Date date=rs.getDate(4);
			int idTo=rs.getInt(5);
			messages.add(new Message(idUser, idTo, date, message));
		}
		// Закрываем выборку и соединение с БД
		rs.close();
		con.close();
		return messages;
		
	}
	
}
