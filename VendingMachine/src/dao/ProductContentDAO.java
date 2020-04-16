package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ProductBeans;
import model.DBConnector;


public class ProductContentDAO {

	//DB接続
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	List<ProductBeans> proList = new ArrayList<ProductBeans>();
	ProductBeans productBeans = new ProductBeans();


		//商品テーブルから全カラムを抽出
		public List<ProductBeans> findAll() throws Exception{

			//SELECT文を準備
			String sql ="select id,name,money,stock from productcontent";
			PreparedStatement pStmt = con.prepareStatement(sql);

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容をArrayListインスタンスに追加
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int  money = rs.getInt("money");
				int stock = rs.getInt("stock");

				ProductBeans productBeans = new ProductBeans(id,name,money,stock);
				proList.add(productBeans);

			}
			return proList;

		}

		//商品テーブルから顧客が入力した商品番号と一致する商品名を照合
		public ProductBeans SelectName() throws SQLException{


			int inputId = productBeans.getId();
			String sql = "select name, money from productcontent where id = ?";

			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, inputId);


			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				productBeans.setName(rs.getNString("name"));
				productBeans.setMoney(rs.getInt("money"));
			}


			return productBeans;

		}






		//データーベース解除
		public void close() {
			try {
				if(this.con != null) {
					this.con.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}







		}

}
















