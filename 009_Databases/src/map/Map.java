package map;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Map {
//	private Connection con = null; // соединение с БД
	private Connection con=null;
	private Statement stmt = null; // оператор
	// Конструктор

	public Map(String DBName, String ip, int port) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String url = "jdbc:mysql://" + ip + ":" + port + "/" + DBName;
		con = DriverManager.getConnection(url, "root", "Suchi2015");
		stmt = con.createStatement();
	}// Завершение работы

	public void stop() throws SQLException {
		con.close();
	}

	// Добавление страны
	public boolean addCountry(int id, String name) {
		String sql = "INSERT INTO COUNTRIES (ID_CO, NAME)" + "VALUES (" + id + ", '" + name + "')";
		try {
			stmt.executeUpdate(sql);
			
			System.out.println("Страна " + name + " успешно добавлена!");
			return true;
		} catch (SQLException e) {
			System.out.println("ОШИБКА! Страна " + name + " не добавлена!");
			System.out.println(">> " + e.getMessage());
			return false;
		}
	}

	// Удаление страны
	public boolean deleteCountry(int id) throws SQLException {
		String sql = "DELETE FROM COUNTRIES WHERE ID_CO = " + id;
		try {
			int c = stmt.executeUpdate(sql);
			if (c > 0) {
				System.out.println("Страна с идентификатором " + id + " успешно удалена!");
				return true;
			} else {
				System.out.println("Страна с идентификатором " + id + " не найдена!");
				return false;
			}
		} catch (SQLException e) {
			System.out.println("ОШИБКА при удалении страны с идентификатором " + id);
			System.out.println(">> " + e.getMessage());
			return false;
		}
	}// Запрос
		// всех
		// стран

	public void showCountries() {
		String sql = "SELECT ID_CO, NAME FROM COUNTRIES";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("СПИСОК СТРАН:");
			while (rs.next()) {
				int id = rs.getInt("ID_CO");
				String name = rs.getString("NAME");
				System.out.println(" >> " + id + " - " + name);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("ОШИБКА при получении списка стран");
			System.out.println(">> " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Map m;
		try {
			m = new Map("MAP","localhost",3306);
			m.showCountries();
			m.addCountry(1, "RUSSIA");
			m.addCountry(5, "JAPAN");
			m.addCountry(6, "UKRAINE");
			m.deleteCountry(3);
			m.deleteCountry(7);
			m.showCountries();
			m.stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}