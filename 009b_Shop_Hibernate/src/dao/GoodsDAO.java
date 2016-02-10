package dao;

import java.sql.SQLException;
import java.util.List;

import logic.Goods;

public interface GoodsDAO {

	    public void addGoods(Goods goods) throws SQLException;   //добавить товар
	    public void updateGoods(Goods goods) throws SQLException;//обновить товар
	    public Goods getGoodsById(int id) throws SQLException;    //получить товар по id
	    public List getAllGoods() throws SQLException;              //получить все товары
	    public void deleteGoods(Goods goods) throws SQLException;//удалить товар
}
