package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB接続情報
 * @author yu199
 *
 */
public class DBConnector {

	/**
	 * DBユーザー情報
	 */
	private static final String driverName = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost/vendingmachine";
	private static final String user = "root";
	private static final String password = "";

	/**
	 * DB接続処理
	 * @return
	 */
	public Connection getConnection() {
		Connection con = null;

		try {
			Class.forName(driverName);
			con = (Connection) DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
