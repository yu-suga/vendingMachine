package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ProductBeans;
import model.DBConnector;

/**
 * 顧客側DAOクラス
 * @author yu199
 *
 */
public class ProductContentDAO {

	//DB接続
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	/**
	 * 商品テーブルから全カラムを抽出
	 * @return
	 * @throws Exception
	 */
	public List<ProductBeans> findAll() throws Exception {

		List<ProductBeans> proList = new ArrayList<ProductBeans>();

		//SELECT文を準備
		String sql = "select id,name,money,stock from productcontent";
		try {
			PreparedStatement pStmt = con.prepareStatement(sql);

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容をArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int money = rs.getInt("money");
				int stock = rs.getInt("stock");

				ProductBeans productBeans = new ProductBeans(id, name, money, stock);
				proList.add(productBeans);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proList;
	}

	/**
	 * 商品テーブルから顧客が入力した商品番号と一致する商品名を照合
	 * @param inputId
	 * @return
	 * @throws SQLException
	 */
	public ProductBeans selectName(int inputId) throws SQLException {

		ProductBeans productBeans = null;

		//商品一覧画面で入力された商品番号と一致する商品名と金額を抽出
		String sql = "select name,money from productcontent where id = ?";

		try {
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, inputId);

			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int money = rs.getInt("money");
				int stock = rs.getInt("stock");

				productBeans = new ProductBeans(id, name, money, stock);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return productBeans;
	}

	/**
	 * データーベース接続解除
	 */
	public void close() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
