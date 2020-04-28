package model;

import beans.ProductBeans;

/**
 * お釣りを処理するクラス
 * @author yu199
 *
 */
public class PurchaseLogic {

	/**
	 * お釣り処理メソッド
	 * @param productBeans
	 */
	public ProductBeans changeLogic(ProductBeans productBeans) {
		int clientMoney = productBeans.getClientMoney();//入力金額
		int money = productBeans.getMoney(); //表示金額

		int change = clientMoney - money; //お釣りを計算し変数changeに格納

		productBeans.setChange(change);
		return productBeans;
	}

	/**
	 * 購入した商品の在庫を１つ減らすメソッド
	 */
	public ProductBeans stockLogic(ProductBeans productBeans) {
		int inputStock = productBeans.getStock();
		int stock = inputStock - 1;

		//1つ減らした在庫をproductBeansのsetStock()に格納
		productBeans.setStock(stock);
		return productBeans;
	}

}
