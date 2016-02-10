package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Tables.Stock.TABLE_NAME)
public class Stock {
	private int stock_id;
	private int goods_id;
	private int supply_id;
	private float in_price;
	private int qty;

	public Stock() {
	}

	public Stock(Goods goods, Supplies supplies, float in_price, int qty) {
		this.goods_id = goods.getGoods_id();
		this.supply_id = supplies.getSupply_id();
		this.in_price = in_price;
		this.qty = qty;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Tables.Stock.STOCK_ID)
	public int getStock_id() {
		return stock_id;
	}

	@Column(name = Tables.Stock.GOODS_ID)
	public int getGoods_id() {
		return goods_id;
	}

	@Column(name = Tables.Stock.SUPPLY_ID)
	public int getSupply_id() {
		return supply_id;
	}

	@Column(name = Tables.Stock.IN_PRICE)
	public float getIn_price() {
		return in_price;
	}

	@Column(name = Tables.Stock.QTY)
	public int getQty() {
		return qty;
	}

	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public void setSupply_id(int supply_id) {
		this.supply_id = supply_id;
	}

	public void setIn_price(float in_price) {
		this.in_price = in_price;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
