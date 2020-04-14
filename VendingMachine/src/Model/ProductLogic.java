package Model;

import beans.ProductBeans;
import beans.UserBeans;

public class ProductLogic {
	public void execute(ProductBeans productBeans,UserBeans userBeans) {

		int id = productBeans.getId();
		int money = productBeans.getMoney();
		int stock = productBeans.getStock();

		int inputMoney = userBeans.getInputMoney();
		int change = userBeans.getChange();

		//購入した商品の在庫を１個減らす
		stock = stock - 1;
		productBeans.setStock(stock);

	}

}
