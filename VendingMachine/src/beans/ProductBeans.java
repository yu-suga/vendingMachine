package beans;

import java.io.Serializable;


public class ProductBeans implements Serializable {

	private int id;	//商品番号
	private String name;	//商品名
	private int money;		//料金
	private int stock;		//在庫数


	public ProductBeans() {}

	public ProductBeans(int id,String name,int money,int stock) {
		this.id = id;
		this.name = name;
		this.money = money;
		this.stock = stock;
	}

	public int getId() {return id;}
	public void setId(int id) {this.id=id; }

	public String getName() {return name;}
	public void setName(String name) {this.name=name; }

	public int getMoney() {return money;}
	public void setMoney(int money) {this.money=money; }

	public int getStock() {return stock;}
	public void setStock(int stock) {this.stock=stock; }
}
