package ex_registrartion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ex_registrartion.entities.Participant;





public class ParticipantDAO {
	// Вспомогательный метод получения соединения
		private Connection getConnection() throws Exception {
			
			// Подгрузка драйвера БД Derby
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Получение соединения с БД
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/Conference","root","Suchi2015");
		}

		/**
		 * Возвращает всех пользователей
		 *
		 * @return
		 */
		public List<Participant> getAllParticipants() throws Exception {
			List<Participant> part = new ArrayList<>();
			// Получение соединения с БД
			Connection con = getConnection();
			// Выполнение SQL-запроса
			ResultSet rs = con.prepareStatement("SELECT * FROM Participant").executeQuery();
			// Перечисляем результаты выборки
			while (rs.next()) {
				// Из каждой строки выборки выбираем
				// результат и помещаем в коллекцию
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email=rs.getString(4);
				String reportTheme=rs.getString(5);
				String organization=rs.getString(5);

				
				
				part.add(new Participant(firstName, lastName, organization, reportTheme, email));
			}
			// Закрываем выборку и соединение с БД
			rs.close();
			con.close();
			return part;
		}

		/**
		 * Возвращает пользователя по ID
		 *
		 * @return
		 */
//		public Participant getUserById(int id) throws Exception {
//			Participant Participant=null;
//			// Получение соединения с БД
//			Connection con = getConnection();
//			// Подготовка SQL-запроса
//			PreparedStatement st = con
//					.prepareStatement("Select * from Users Where idUsers = ?");
//			// Указание значений параметров запроса
//			st.setInt(1, id);
//			// Выполнение запроса
//			ResultSet rs = st.executeQuery();
//			// Перечисляем результаты выборки
//			if(rs.isBeforeFirst()){
//				rs.next();
//				String name = rs.getString(2);
//				String comments=rs.getString(3);
//				int pwd=rs.getInt(4);
//				Participant=new Participant(id,name,comments,pwd);
//			}
//			// Закрываем выборку и соединение с БД
//			rs.close();
//			con.close();
//			return Participant;
//		}

		/**
		 * Возвращает пользователя по имени
		 *@param String username
		 * @throws Exception
		 *
		 * @return List <Participant>
		 */
		
		
//		public List<Participant> getUsersByName(String name) throws Exception {
//			List<Participant> users = new ArrayList<>();
//			// Получение соединения с БД
//			Connection con = getConnection();
//			// Подготовка SQL-запроса
//			PreparedStatement st = con
//					.prepareStatement("Select * from Users Where Name = ?");
//			// Указание значений параметров запроса
//			st.setString(1, name);
//			// Выполнение запроса
//			ResultSet rs = st.executeQuery();
//			// Перечисляем результаты выборки
//			while (rs.next()) {
//				// Из каждой строки выборки выбираем результаты,// формируем новый
//				// объект Product
//				// и помещаем его в коллекцию
//				int id = rs.getInt(1);
//				String temp_name = rs.getString(2);
//				String comments=rs.getString(3);
//				int pwd=rs.getInt(4);
//				
//				users.add(new Participant(id,temp_name,comments,pwd));
//			}
//			// Закрываем выборку и соединение с БД
//			rs.close();
//			con.close();
//			return users;
//		}
		
		
		
		/**
		 * Добавляет нового пользователя
		 * 
		 * @param Participant
		 * @throws Exception
		 */
		public void addParticipant(Participant Participant) throws Exception {
			// Получение соединения с БД
			Connection con = getConnection();
			// Подготовка SQL-запроса
			PreparedStatement st = con.prepareStatement(
					"Insert into Participant (FirstName, SecondName, email, ReportTheme, Organization) values (?, ?, ?, ?, ?)");
			// Указание значений параметров запроса
			st.setString(1, Participant.getFirstName());
			st.setString(2, Participant.getLastName());
			st.setString(3, Participant.getEmail());
			st.setString(4, Participant.getReportTheme());
			st.setString(5, Participant.getOrganization());

			// Выполнение запроса
			st.executeUpdate();
			con.close();
		}

		/**
		 * Обновляет данные о товаре
		 * 
		 * @param Participant
		 * @throws Exception
		 */
//		public void setUser(Participant Participant) throws Exception {
//			// Получение соединения с БД
//			Connection con = getConnection();
//			// Подготовка SQL-запроса
//			PreparedStatement st = con
//					.prepareStatement("Update Users Set Name=?, Comments=?, password=? Where idUsers=?");
//			// Указание значений параметров запроса
//			st.setString(1, Participant.getName());
//			st.setString(2, Participant.getComments());
//			st.setInt(3, Participant.getPwd());
//			st.setInt(4, Participant.getId());
//			// Выполнение запроса
//			st.executeUpdate();
//			con.close();
//		}
//
//		
//		
//		/**
//		 * Удаляет данные о товаре
//		 * 
//		 * @param id
//		 * @throws Exception
//		 */
//	public void removeUser(int id) throws Exception {
//			// Получение соединения с БД
//			Connection con = getConnection();
//			// Подготовка SQL-запроса
//			PreparedStatement st = con.prepareStatement("Delete from Users Where idUsers = ?");
//			// Указание значений параметров запроса
//			st.setInt(1, id);
//			// Выполнение запроса
//			st.executeUpdate();
//			con.close();
//		}
	
}
