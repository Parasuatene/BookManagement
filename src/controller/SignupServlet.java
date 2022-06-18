package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import debugger.PrintChecker;

/**
 * アカウント登録画面
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// アカウント登録画面へのフォワード
		request.getRequestDispatcher("WEB-INF/jsp/signup.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lastName = request.getParameter("last_name");
		String firstName = request.getParameter("first_name");
		String loginId = request.getParameter("login_id");
		String password = request.getParameter("password");

		// 確認用
		PrintChecker.print("signup", lastName, firstName, loginId, password);

		// ログインIDが条件を満たしていない場合はsignup.jspにフォワード
		if ("".equals(loginId)) {
			request.getRequestDispatcher("WEB-INF/jsp/signup.jsp").forward(request, response);
			return;
		}

		// 問題なかった場合はアカウント登録完了画面にフォワード
		request.getRequestDispatcher("WEB-INF/jsp/signupComplete.jsp").forward(request, response);
		return;
	}

}
