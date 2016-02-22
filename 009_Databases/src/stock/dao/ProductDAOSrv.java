package stock.dao;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import stock.products.Product;

public class ProductDAOSrv extends UnicastRemoteObject implements ProductDAO{
	
	public ProductDAOSrv() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	// Вспомогательный метод получения соединения
	private Connection getConnection() throws Exception {
		
		// Подгрузка драйвера БД Derby
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		// Получение соединения с БД
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/L10","root","Suchi2015");
	}

	/**
	 * Возвращает список идентификаторов товаров
	 *
	 * @return
	 */
	public List<Integer> getProductIds() throws Exception {
		List<Integer> productIds = new ArrayList<Integer>();
		// Получение соединения с БД
		Connection con = getConnection();
		// Выполнение SQL-запроса
		ResultSet rs = con.createStatement().executeQuery("Select id From products");
		// Перечисляем результаты выборки
		while (rs.next()) {
			// Из каждой строки выборки выбираем
			// результат и помещаем в коллекцию
			productIds.add(rs.getInt(1));
		}
		// Закрываем выборку и соединение с БД
		rs.close();
		con.close();
		return productIds;
	}

	/**
	 * Возвращает товар по идентификатору
	 *
	 * @return
	 */
	public List<Product> getProductById(int id) throws Exception {
		List<Product> products = new ArrayList<Product>();
		// Получение соединения с БД
		Connection con = getConnection();
		// Подготовка SQL-запроса
		PreparedStatement st = con
				.prepareStatement("Select description, rate, quantity " + "From products " + "Where id = ?");
		// Указание значений параметров запроса
		st.setInt(1, id);
		// Выполнение запроса
		ResultSet rs = st.executeQuery();
		Product product = null;
		// Перечисляем результаты выборки
		while (rs.next()) {
			// Из каждой строки выборки выбираем результаты,// формируем новый
			// объект Product
			// и помещаем его в коллекцию
			product = new Product(id, rs.getString(1), rs.getFloat(2), rs.getInt(3));
			products.add(product);
		}
		// Закрываем выборку и соединение с БД
		rs.close();
		con.close();
		return products;
	}

	/**
	 * Добавляет новый товар
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void addProduct(Product product) throws Exception {
		// Получение соединения с БД
		Connection con = getConnection();
		// Подготовка SQL-запроса
		PreparedStatement st = con.prepareStatement(
				"Insert into products " + "(id, description, rate, quantity) " + "values (?, ?, ?, ?)");
		// Указание значений параметров запроса
		st.setInt(1, product.getId());
		st.setString(2, product.getDescription());
		st.setFloat(3, product.getRate());
		st.setInt(4, product.getQuantity());
		// Выполнение запроса
		st.executeUpdate();
		con.close();
	}

	/**
	 * Обновляет данные о товаре
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void setProduct(Product product) throws Exception {
		// Получение соединения с БД
		Connection con = getConnection();
		// Подготовка SQL-запроса
		PreparedStatement st = con
				.prepareStatement("Update products " + "Set description=?, rate=?, quantity=? " + "Where id=?");
		// Указание значений параметров запроса
		st.setString(1, product.getDescription());
		st.setFloat(2, product.getRate());
		st.setInt(3, product.getQuantity());
		st.setInt(4, product.getId());
		// Выполнение запроса
		st.executeUpdate();
		con.close();
	}

	public void removeProduct(int id) throws Exception {
		// Получение соединения с БД
		Connection con = getConnection();
		// Подготовка SQL-запроса
		PreparedStatement st = con.prepareStatement("Delete from products " + "Where id = ?");
		// Указание значений параметров запроса
		st.setInt(1, id);
		// Выполнение запроса
		st.executeUpdate();
		con.close();
	}
	
	public static void main(String[] args) {
		ProductDAO server;
		try {
			server = new ProductDAOSrv();
			Registry registry = LocateRegistry.createRegistry(59001);
			registry.rebind("Products", server);
			System.out.println("Server started!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
