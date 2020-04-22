package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ProductBeans;
import dao.ProductContentDAO;

@WebServlet("/ProductControll")

/**
 * 商品一覧画面から購入確認までのサーブレットクラス
 * @author yu199
 *
 */
public class ProductControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Home画面から商品一覧画面へgetで受け取るメソッド
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//商品一覧を取得
		ProductContentDAO productContentDAO = new ProductContentDAO();
		List<ProductBeans> proList = null;
		try {
			proList = productContentDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//リクエストスコープに保存
		request.setAttribute("proList", proList);

		//商品一覧画面に遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/lineup.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * lineup.jspで入力された商品番号と金額をpostで受け取るメソッド
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメーターを取得
		int inputId = Integer.parseInt(request.getParameter("inputId")); //商品番号
		int clientMoney = Integer.parseInt(request.getParameter("clientMoney")); //商品番号


		ProductBeans productBeans = null;
		//DBに接続
		ProductContentDAO productContentDAO = new ProductContentDAO();
		//リクエストパラメーターで取得した値をDAOのselectNameメソッドに引数として設定
		try {
			productBeans = productContentDAO.selectName(inputId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		productBeans.setClientMoney(clientMoney);

		//セッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("productBeans", productBeans);

		//商品確認画面に遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/check.jsp");
		dispatcher.forward(request, response);
	}

}
