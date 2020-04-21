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
import dao.ProductContentDAO;;

@WebServlet("/StockController")

/**
 * 在庫数を変更するサーブレットクラス
 * @author yu199
 *
 */
public class StockController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品一覧を受け取り在庫数変更手続き画面に遷移させるメソッド
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/stockView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * 指定した商品の在庫数を変更させ、手続き完了画面へ遷移させるメソッド
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//stockView.jspから送られてきた変更する商品番号と在庫名を取得

		int inputId = Integer.parseInt(request.getParameter("inputId")); //商品番号
		int inputStock = Integer.parseInt(request.getParameter("inputStock")); //変更希望の在庫数

		//DAOからDBに接続
		ManagementDAO managementDAO = new ManagementDAO();

		//取得した商品番号と在庫名をManagementDAOのstockUpdateの引数に設定
		managementDAO.stockUpdate(inputId, inputStock);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/managementComplete.jsp");
		dispatcher.forward(request, response);

	}

}
