package dao_impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dao.SuppliesDAO;
import logic.Goods;
import logic.Supplies;
import util.HibernateUtil;

public class SuppliesDAO_Impl implements SuppliesDAO {
    
    public void addSupplies(Supplies supplies) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(supplies);
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public void updateSupplies(Supplies supplies) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(supplies);
                session.getTransaction().commit();
            } catch (Exception e) {
            	e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public Supplies getSuppliesById(int id) throws SQLException {
            Session session = null;
            Supplies supplies = null;
            List<Goods> goods=new ArrayList<>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                supplies = (Supplies) session.load(Supplies.class, id);
                for(Goods g: supplies.getGoods()){
                	goods.add(g);
                }
            } catch (Exception e) {
            	e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            supplies.setGoods(goods);
            return supplies;
      }

      public List<Supplies> getAllSupplies() throws SQLException {
            Session session = null;
            List<Supplies> supplies = new ArrayList<Supplies>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                supplies = session.createCriteria(Supplies.class).list();
            } catch (Exception e) {
            	e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return supplies;
      }

      public void deleteSupplies(Supplies supplies) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(supplies);
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
