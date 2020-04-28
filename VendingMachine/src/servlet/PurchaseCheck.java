package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ProductBeans;
import dao.ProductContentDAO;
import model.PurchaseLogic;

/**
 * 購入完了処理サーブレットクラス
 */
@WebServlet("/PurchaseCheck")
public class PurchaseCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//HttpSessionインスタンスの追加
		HttpSession session = request.getSession();

		//セッションスコープからproductBeansを取得
		ProductBeans productBeans = (ProductBeans) session.getAttribute("productBeans");

		//purchaseLogicをインスタンス化し引数にproductbensを設定
		PurchaseLogic purchaseLogic = new PurchaseLogic();
		purchaseLogic.changeLogic(productBeans);

		//入力金額が不足していなければ以下の処理を実行
		if (productBeans.getChange() >= 0) {

			//1つ減らした在庫をDBに格納、在庫数を更新
			ProductContentDAO productContentDAO = new ProductContentDAO();
			try {
				productBeans = productContentDAO.updateStock(productBeans);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			session.setAttribute("productBeans", productBeans);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/purchaseDone.jsp");
			dispatcher.forward(request, response);

			//入力金額が表示金額より不足している場合エラーページへ遷移
		} else if (productBeans.getChange() < 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/moneyError.jsp");
			dispatcher.forward(request, response);
		}

	}

}
