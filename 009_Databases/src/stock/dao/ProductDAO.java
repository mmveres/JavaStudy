package stock.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import stock.products.Product;

public interface ProductDAO extends Remote{
	
	/**
	 * Возвращает список идентификаторов товаров
	 *
	 * @return
	 */
	public List<Integer> getProductIds() throws Exception;

	/**
	 * Возвращает товар по идентификатору
	 *
	 * @return
	 */
	public List<Product> getProductById(int id) throws Exception;

	/**
	 * Добавляет новый товар
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void addProduct(Product product) throws Exception;
	/**
	 * Обновляет данные о товаре
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void setProduct(Product product) throws Exception;

	public void removeProduct(int id) throws Exception;
}
