package jp.co.benesse.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.benesse.dataaccess.value.User;
import jp.co.benesse.service.UserService;
import myapi.HashGenerator;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// パラメータの取得
		String loginId = request.getParameter("login_id");
		String password = request.getParameter("password");

		// ログインID・パスワードの組み合わせがDBに存在するかを確認する
		UserService userService = new UserService();
		// パスワードをハッシュ値に変換
		password = HashGenerator.getHash(password);
		User user = userService.getUserByIdAndPassword(loginId, password);

		// userがnullの時はログイン処理に失敗したとき
		if (user == null) {
			String errorMessage = "※ログインID、またはパスワードに誤りがあります";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}

		// ログインに成功した場合は、ログインIDと権限をセッションに保持し、書籍一覧画面に移動する
		HttpSession session = request.getSession(true);
		session.setAttribute("id", user.getId());
		session.setAttribute("authority", user.getAuthority());

		// ログインに成功した場合は、書籍一覧画面に移動する
		response.sendRedirect("home");
		return;
	}

}
