package dao_impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dao.StockDAO;
import logic.Goods;
import logic.Stock;
import logic.Tables;
import util.HibernateUtil;

public class StockDAO_Impl implements StockDAO {

	@Override
	public void addRecord(Stock stockRecord) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(stockRecord);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public void updateRecord(Stock stockRecord) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(stockRecord);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public Stock getRecordById(int stock_id) throws SQLException {
		Session session = null;
		Stock stockRecord = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			stockRecord = (Stock) session.load(Stock.class, stock_id);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return stockRecord;
	}

	@Override
	public List getAllRecords() throws SQLException {
		Session session = null;
		List<Stock> stockRecords = new ArrayList<>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			stockRecords = session.createCriteria(Stock.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return stockRecords;
	}

	@Override
	public List getAllGoodsType(Goods goods) throws SQLException {
		Session session = null;
		String column = "GOODS_ID";
		List<Stock> stockRecords = new ArrayList<>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			stockRecords = session.createCriteria(Stock.class).add(Restrictions.eq(column, goods.getGoods_id())).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public void deleteRecord(Stock stockRecord) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(stockRecord);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

}
