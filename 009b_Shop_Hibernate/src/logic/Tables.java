package logic;

public class Tables {

	public static class Goods {
		public static final String TABLE_NAME = "GOODS";
		public static final String GOODS_ID = "GOODS_ID";
		public static final String NAME="NAME";
		public static final String UNIT="UNIT";

	}
	
	public static class Supplies{
		public static final String TABLE_NAME="SUPPLIES";
		public static final String SUPPLY_ID="SUPPLY_ID";
		public static final String DATE="DATE";
		public static final String SUPPLIER="SUPPLIER";
	}
	
	public static class Stock{
		public static final String TABLE_NAME="STOCK";
		public static final String STOCK_ID="STOCK_ID";
		public static final String SUPPLY_ID="SUPPLY_ID";
		public static final String GOODS_ID = "GOODS_ID";
		public static final String IN_PRICE="IN_PRICE";
		public static final String QTY="QTY";
	}
	
	public static class Check{
		public static final String TABLE_NAME="CHECK";
		public static final String CHECK_ID="CHECK_ID";
		public static final String STOCK_ID="STOCK_ID";
		public static final String QTY="QTY";
		public static final String SELL_PRICE="SELL_PRICE";
	}
	
	public static class Sales{
		public static final String TABLE_NAME="SALES";
		public static final String SALE_ID="SALE_ID";
		public static final String CHECK_ID="CHECK_ID";
		public static final String STOCK_ID="STOCK_ID";
		public static final String DATE="DATE";
	}
	
}
