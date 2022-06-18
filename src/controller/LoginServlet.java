package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import debugger.PrintChecker;

/**
 * ログイン管理クラス
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページへのフォワード処理
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("login_id");
		String password = request.getParameter("password");

		// // ログインIDやパスワードが条件を満たしていない場合はsignup.jspにフォワード
		// TODO: データベースとの照合処理
		if ("".equals(loginId) || "".equals(password)) {
			PrintChecker.print("login", "ログイン画面に戻す");
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}

		// ログインに成功した場合は、書籍一覧画面に移動する
		PrintChecker.print("login", "書籍一覧画面に移動");
		request.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(request, response);
		return;
	}

}
