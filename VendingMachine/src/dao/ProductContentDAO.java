package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ProductBeans;


public class ProductContentDAO {
	public List<ProductBeans> findAll(){

		Connection conn = null;
		List<ProductBeans> proList = new ArrayList<ProductBeans>();

		try {

			//JDBCドライバーを読み込み
			Class.forName("com.mysql.jdbc.Driver");

			//データーベースへの接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost/vendingmachine","root","");

			//SELECT文を準備
			String sql ="select id,name,money,stock from productcontent";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容をProductContentに設定し、ArrayListインスタンスに追加
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int  money = rs.getInt("money");
				int stock = rs.getInt("stock");

				ProductBeans productBeans = new ProductBeans(id,name,money,stock);
				proList.add(productBeans);

			}



		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}finally {
			//データーベース切断
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return proList;
	}
}
