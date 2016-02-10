package logic;


import java.util.HashSet;
import java.util.Set;

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
@Table(name=Tables.Goods.TABLE_NAME)
public class Goods {
	public static final String DEFAULT_NAME="UNSPECIFIED_GOODIE";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name=Tables.Goods.GOODS_ID)
	private int goods_id;
	@Column(name=Tables.Goods.NAME)
	private String name;
	@Column(name=Tables.Goods.UNIT)
	private int unit;
	
	
	public Goods() {
		name=DEFAULT_NAME;
	}

	public Goods(Goods g) {
		this.name = g.getName();
	}
	
	

	public Goods(String name, int unit) {
		super();
		this.name = name;
		this.unit = unit;
	}


	public int getGoods_id() {
		return goods_id;
	}
	
	
	
	public String getName() {
		return name;
	}
	
	@Column(name=Tables.Goods.UNIT)
	public int getUnit() {
		return unit;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}
	
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	

	@Override
	public String toString() {
		return name + "(ID:" + goods_id + ")";
	}
	
	
	
}
