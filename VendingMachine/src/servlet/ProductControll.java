package servlet;

import java.io.IOException;
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


/**
 * Servlet implementation class ProductControll
 */
@WebServlet("/ProductControll")
public class ProductControll extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//商品一覧を取得
		ProductContentDAO productContentDAO = new ProductContentDAO();
		List<ProductBeans> proList = null;
		try {
			proList = productContentDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//リクエストスコープに保存
		request.setAttribute("proList",proList );

		//商品一覧画面に遷移
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/lineup.jsp");
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメーターを取得
		int id =Integer.parseInt(request.getParameter("id"));	//商品番号
		int inputMoney =Integer.parseInt(request.getParameter("inputMoney"));	//入力金額

		//入力値をプロパティに設定
		ProductBeans productBeans = new ProductBeans();
		productBeans.setId(id);
		productBeans.setId(inputMoney);

		//DB
		ProductContentDAO productContentDAO = new ProductContentDAO();

		try {
		productBeans = productContentDAO.SelectName();
		}catch (Exception e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		session.setAttribute("productBeans", productBeans);


		//商品確認画面に遷移
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/check.jsp");
		dispatcher.forward(request, response);


	}

}
