package logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = Tables.Supplies.TABLE_NAME)
public class Supplies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Tables.Supplies.SUPPLY_ID)
	private int supply_id;
	@Column(name = Tables.Supplies.DATE)
	private Date date;
	@Column(name = Tables.Supplies.SUPPLIER)
	private String supplier;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name=Tables.Stock.TABLE_NAME,
			joinColumns=@JoinColumn(name=Tables.Stock.SUPPLY_ID,
			referencedColumnName=Tables.Supplies.SUPPLY_ID),
			inverseJoinColumns=@JoinColumn(name=Tables.Stock.GOODS_ID,
			referencedColumnName=Tables.Goods.GOODS_ID))
	private List<Goods> goods;

	public Supplies() {
	}

	public Supplies(Supplies s) {

		this.date = s.getDate();
		this.supplier = s.getSupplier();
	}
	
	

	public Supplies(Date date, String supplier) {
		this.date = date;
		this.supplier = supplier;
	}


	public int getSupply_id() {
		return supply_id;
	}

	
	
	public List<Goods> getGoods() {
		return goods;
	}
	
	
	public Date getDate() {
		return date;
	}

	
	public String getSupplier() {
		return supplier;
	}

	public void setSupply_id(int supply_id) {
		this.supply_id = supply_id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		return "[ID: " + supply_id + "] "+ sdf.format(date)+ " "+ supplier;
	}
	
	
}
