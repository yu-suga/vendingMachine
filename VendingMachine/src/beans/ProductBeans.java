package beans;

import java.io.Serializable;

public class ProductBeans implements Serializable {

	/**
	 * ProductBeans
	 **/

	private int id; //商品番号
	private String name; //商品名
	private int money; //料金
	private int stock; //在庫数
	private int clientMoney; //顧客が入力した料金
	private int change; //お釣り
	private int shortage; //不足金額

	public ProductBeans() {
	}

	//全商品を格納するコンストラクタ
	public ProductBeans(int id, String name, int money, int stock) {
		this.id = id;
		this.name = name;
		this.money = money;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getClientMoney() {
		return clientMoney;
	}

	public void setClientMoney(int clientMoney) {
		this.clientMoney = clientMoney;
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

	public int getShortage() {
		return shortage;
	}

	public void setShortage(int shortage) {
		this.shortage = shortage;
	}
}
