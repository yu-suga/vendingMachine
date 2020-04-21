package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.DBConnector;

/**
 * 管理者側DAO
 * @author yu199
 *
 */
public class ManagementDAO {

	//DB接続
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	/**
	 * 入力された在庫数に変更
	 * @param inputId
	 * @param inputStock
	 */
	public void stockUpdate(int inputId, int inputStock) {

		String sql = "update productcontent set stock = ? where id = ?";

		try {
			PreparedStatement pStmt = con.prepareStatement(sql);

			//パラメーターをセット
			pStmt.setInt(1, inputStock);
			pStmt.setInt(2, inputId);

			//SQLを実行
			int i = pStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 入力された商品情報を追加
	 * @param inputName
	 * @param inputMoney
	 * @param inputStock
	 */
	public void productInsert(String inputName, int inputMoney, int inputStock) {

		String sql = "insert into productcontent values(?,?,?,?)";

		try {
			PreparedStatement pStmt = con.prepareStatement(sql);

			//パラメーターをセット
			pStmt.setInt(1, 0);
			pStmt.setString(2, inputName);
			pStmt.setInt(3, inputMoney);
			pStmt.setInt(4, inputStock);

			//SQLを実行
			int i = pStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//入力された商品情報を削除
	public void productDelete(int inputId) {

		String sql = "delete from productcontent where id = ?";

		try {
			PreparedStatement pStmt = con.prepareStatement(sql);

			//パラメーターをセット
			pStmt.setInt(1, inputId);

			//SQLを実行
			int i = pStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//データーベース接続解除
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