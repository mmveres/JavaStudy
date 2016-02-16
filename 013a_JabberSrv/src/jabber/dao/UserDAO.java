package jabber.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jabber.entities.User;




public class UserDAO {
	// Вспомогательный метод получения соединения
		private Connection getConnection() throws Exception {
			
			// Подгрузка драйвера БД Derby
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Получение соединения с БД
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/Jabber","root","Suchi2015");
		}

		/**
		 * Возвращает всех пользователей
		 *
		 * @return
		 */
		public List<User> getAllUsers() throws Exception {
			List<User> users = new ArrayList<>();
			// Получение соединения с БД
			Connection con = getConnection();
			// Выполнение SQL-запроса
			ResultSet rs = con.prepareStatement("SELECT * FROM Users").executeQuery();
			// Перечисляем результаты выборки
			while (rs.next()) {
				// Из каждой строки выборки выбираем
				// результат и помещаем в коллекцию
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String comments=rs.getString(3);
				int pwd=rs.getInt(4);
				
				users.add(new User(id,name,comments,pwd));
			}
			// Закрываем выборку и соединение с БД
			rs.close();
			con.close();
			return users;
		}

		/**
		 * Возвращает пользователя по ID
		 *
		 * @return
		 */
		public User getUserById(int id) throws Exception {
			User user=null;
			// Получение соединения с БД
			Connection con = getConnection();
			// Подготовка SQL-запроса
			PreparedStatement st = con
					.prepareStatement("Select * from Users Where idUsers = ?");
			// Указание значений параметров запроса
			st.setInt(1, id);
			// Выполнение запроса
			ResultSet rs = st.executeQuery();
			// Перечисляем результаты выборки
			if(rs.isBeforeFirst()){
				rs.next();
				String name = rs.getString(2);
				String comments=rs.getString(3);
				int pwd=rs.getInt(4);
				user=new User(id,name,comments,pwd);
			}
			// Закрываем выборку и соединение с БД
			rs.close();
			con.close();
			return user;
		}

		/**
		 * Возвращает пользователя по имени
		 *@param String username
		 * @throws Exception
		 *
		 * @return List <User>
		 */
		
		
		public List<User> getUsersByName(String name) throws Exception {
			List<User> users = new ArrayList<>();
			// Получение соединения с БД
			Connection con = getConnection();
			// Подготовка SQL-запроса
			PreparedStatement st = con
					.prepareStatement("Select * from Users Where Name = ?");
			// Указание значений параметров запроса
			st.setString(1, name);
			// Выполнение запроса
			ResultSet rs = st.executeQuery();
			// Перечисляем результаты выборки
			while (rs.next()) {
				// Из каждой строки выборки выбираем результаты,// формируем новый
				// объект Product
				// и помещаем его в коллекцию
				int id = rs.getInt(1);
				String temp_name = rs.getString(2);
				String comments=rs.getString(3);
				int pwd=rs.getInt(4);
				
				users.add(new User(id,temp_name,comments,pwd));
			}
			// Закрываем выборку и соединение с БД
			rs.close();
			con.close();
			return users;
		}
		
		
		
		/**
		 * Добавляет нового пользователя
		 * 
		 * @param user
		 * @throws Exception
		 */
		public void addUser(User user) throws Exception {
			// Получение соединения с БД
			Connection con = getConnection();
			// Подготовка SQL-запроса
			PreparedStatement st = con.prepareStatement(
					"Insert into Users (Name, Comments, password) values (?, ?, ?)");
			// Указание значений параметров запроса
			st.setString(1, user.getName());
			st.setString(2, user.getComments());
			st.setInt(3, user.getPwd());
			// Выполнение запроса
			st.executeUpdate();
			con.close();
		}

		/**
		 * Обновляет данные о товаре
		 * 
		 * @param user
		 * @throws Exception
		 */
		public void setUser(User user) throws Exception {
			// Получение соединения с БД
			Connection con = getConnection();
			// Подготовка SQL-запроса
			PreparedStatement st = con
					.prepareStatement("Update Users Set Name=?, Comments=?, password=? Where idUsers=?");
			// Указание значений параметров запроса
			st.setString(1, user.getName());
			st.setString(2, user.getComments());
			st.setInt(3, user.getPwd());
			st.setInt(4, user.getId());
			// Выполнение запроса
			st.executeUpdate();
			con.close();
		}

		
		
		/**
		 * Удаляет данные о товаре
		 * 
		 * @param id
		 * @throws Exception
		 */
	public void removeUser(int id) throws Exception {
			// Получение соединения с БД
			Connection con = getConnection();
			// Подготовка SQL-запроса
			PreparedStatement st = con.prepareStatement("Delete from Users Where idUsers = ?");
			// Указание значений параметров запроса
			st.setInt(1, id);
			// Выполнение запроса
			st.executeUpdate();
			con.close();
		}
	
}
