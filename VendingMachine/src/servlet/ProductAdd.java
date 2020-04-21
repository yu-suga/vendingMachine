package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ProductBeans;
import dao.ManagementDAO;
import dao.ProductContentDAO;

/**
 * 商品情報を追加するサーブレットクラス
 * @author yu199
 *
 */

@WebServlet("/ProductAdd")
public class ProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品一覧を受け取り商品追加手続き画面に遷移させるメソッド
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//在庫一覧を取得
		ProductContentDAO productContentDAO = new ProductContentDAO();
		List<ProductBeans> proList = null;
		try {
			proList = productContentDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//リクエストスコープに保存
		request.setAttribute("proList", proList);

		//商品追加画面に遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productAdd.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * 指定した商品情報を追加させ、手続き完了画面へ遷移させるメソッド
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//stockAdd.jspで入力された値を取得
		String inputName = request.getParameter("inputName"); //商品名
		int inputMoney = Integer.parseInt(request.getParameter("inputMoney")); //商品金額
		int inputStock = Integer.parseInt(request.getParameter("inputStock")); //在庫数

		//DAOからDBに接続
		ManagementDAO managementDAO = new ManagementDAO();

		//取得した値をManagementDAOのproductInsertメソッドの引数に設定
		managementDAO.productInsert(inputName, inputMoney, inputStock);

		//追加完了画面に遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/managementComplete.jsp");
		dispatcher.forward(request, response);

	}

}
