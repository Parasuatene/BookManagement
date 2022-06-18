package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignupCompleteServlet
 */
@WebServlet("/signupComplete")
public class SignupCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// アカウント登録画面で保存したセッション属性を削除する
		HttpSession session = request.getSession(false);
		session.removeAttribute("lastName");
		session.removeAttribute("firstName");
		session.removeAttribute("loginId");
		session.removeAttribute("password");

		request.getRequestDispatcher("WEB-INF/jsp/signupComplete.jsp").forward(request, response);
		return;
	}

}
