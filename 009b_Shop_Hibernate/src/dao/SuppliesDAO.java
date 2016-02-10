package dao;

import java.sql.SQLException;
import java.util.List;

import logic.Supplies;

public interface SuppliesDAO {

	    public void addSupplies(Supplies supplies) throws SQLException;   //добавить товар
	    public void updateSupplies(Supplies supplies) throws SQLException;//обновить товар
	    public Supplies getSuppliesById(int id) throws SQLException;    //получить товар по id
	    public List getAllSupplies() throws SQLException;              //получить все товары
	    public void deleteSupplies(Supplies supplies) throws SQLException;//удалить товар
}
