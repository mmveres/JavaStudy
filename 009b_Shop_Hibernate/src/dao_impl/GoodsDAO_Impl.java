package dao_impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dao.GoodsDAO;
import logic.Goods;
import util.HibernateUtil;

public class GoodsDAO_Impl implements GoodsDAO {
    
    public void addGoods(Goods goods) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(goods);
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public void updateGoods(Goods goods) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(goods);
                session.getTransaction().commit();
            } catch (Exception e) {
            	e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public Goods getGoodsById(int id) throws SQLException {
            Session session = null;
            Goods goods = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                goods = (Goods) session.load(Goods.class, id);
            } catch (Exception e) {
            	e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return goods;
      }

      public List<Goods> getAllGoods() throws SQLException {
            Session session = null;
            List<Goods> goods = new ArrayList<Goods>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                goods = session.createCriteria(Goods.class).list();
            } catch (Exception e) {
            	e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return goods;
      }

      public void deleteGoods(Goods goods) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(goods);
                session.getTransaction().commit();
            } catch (Exception e) {
            	e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

}
