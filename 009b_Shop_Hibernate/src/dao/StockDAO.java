package dao;

import java.sql.SQLException;
import java.util.List;

import logic.Goods;
import logic.Stock;

public interface StockDAO {

	    public void addRecord(Stock stockRecord) throws SQLException;   //добавить товар
	    public void updateRecord(Stock stockRecord) throws SQLException;//обновить товар
	    public Stock getRecordById(int stock_id) throws SQLException;    //получить товар по id
	    public List getAllRecords() throws SQLException;              //получить все товары
	    public List getAllGoodsType(Goods goods) throws SQLException;// получить список товаров определенного типа
	    public void deleteRecord(Stock stockRecord) throws SQLException;//удалить товар
}
