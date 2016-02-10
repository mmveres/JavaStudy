package dao;

import dao_impl.GoodsDAO_Impl;
import dao_impl.StockDAO_Impl;
import dao_impl.SuppliesDAO_Impl;

public class Factory {
	private static GoodsDAO goodsDAO = null;
	private static SuppliesDAO suppliesDAO=null;
	private static StockDAO stockDAO=null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
          if (instance == null){
            instance = new Factory();
          }
          return instance;
    }

    public GoodsDAO getGoodsDAO(){
          if (goodsDAO == null){
        	  goodsDAO = new GoodsDAO_Impl();
          }
          return goodsDAO;
    }

	public SuppliesDAO getSuppliesDAO() {
		if (suppliesDAO == null){
			suppliesDAO = new SuppliesDAO_Impl();
        }
		return suppliesDAO;
	}
    
	public StockDAO getStockDAO() {
		if (stockDAO == null){
			stockDAO = new StockDAO_Impl();
        }
		return stockDAO;
	}

}
