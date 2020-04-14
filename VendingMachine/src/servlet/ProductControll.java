package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ProductLogic;
import beans.ProductBeans;
import beans.UserBeans;
import dao.ProductContentDAO;
import dao.ProductLogicDAO;


/**
 * Servlet implementation class ProductControll
 */
@WebServlet("/ProductControll")
public class ProductControll extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//商品一覧を取得
		ProductContentDAO productContentDAO = new ProductContentDAO();
		List<ProductBeans> proList=productContentDAO.findAll();

		//リクエストスコープに保存
		request.setAttribute("proList",proList );

		//商品一覧画面に遷移
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/lineup.jsp");
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメーターを取得
		int id =Integer.parseInt(request.getParameter("id"));	//商品番号
		int inputMoney =Integer.parseInt(request.getParameter("inputMoney"));	//金額

		//入力値をプロパティに設定
		ProductBeans productBeans = new ProductBeans();
		productBeans.setId(id);

		UserBeans userBeans = new UserBeans();
		userBeans.setInputMoney(inputMoney);

		//入力値の金額処理、在庫処理を行うビジネスロジックに受け渡し
		ProductLogic productLogic = new ProductLogic();
		productLogic.execute(productBeans,userBeans);

		//リクエストスコープに保存
		request.setAttribute("productBeans",productBeans);

		//DB内の在庫数の更新
		ProductLogicDAO productLogicDAO = new ProductLogicDAO();


		//商品確認画面に遷移
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/completed.jsp");
		dispatcher.forward(request, response);


	}

}
