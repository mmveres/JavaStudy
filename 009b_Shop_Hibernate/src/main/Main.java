package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import application.ShopApplication;
import dao.Factory;
import logic.Goods;
import logic.Supplies;
import util.HibernateUtil;

public class Main {
	
	public static void main(String[] args) {
		
ShopApplication.getShopApplication().start();

		try {
//			List<Goods> g1;
//			Factory.getInstance().getGoodsDAO().addGoods(new Goods("pivo", 1000));
//			Factory.getInstance().getGoodsDAO().addGoods(new Goods("sugar", 1000));
//			Factory.getInstance().getGoodsDAO().addGoods(new Goods("cat", 1));
//			g1=Factory.getInstance().getGoodsDAO().getAllGoods();
//
//
//			System.out.println(g1);
//			Supplies product=new Supplies(new Date(), "dfhsdfhsdf");
//			product.setGoods(g1);
//			Factory.getInstance().getSuppliesDAO().addSupplies(product);
//			System.out.println("done!");
//			List<Supplies> ss = Factory.getInstance().getSuppliesDAO().getAllSupplies();
//			for (Supplies supplies : ss) {
//				System.out.println(supplies + " goods" + supplies.getGoods());
//			}
//			Supplies s=Factory.getInstance().getSuppliesDAO().getSuppliesById(1);
//			System.out.println(s);
//			System.out.println(s.getGoods());
//			System.out.println("done!");
//			

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		
	}
}
