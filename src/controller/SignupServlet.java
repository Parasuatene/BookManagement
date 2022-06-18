package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataaccess.value.User;
import myapi.HashGenerator;
import myapi.RegexManager;
import service.UserService;

/**
 * アカウント登録画面
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final int USER_AUTHORITY = 0;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// パラメータの取得
		String lastName = request.getParameter("last_name");
		String firstName = request.getParameter("first_name");
		String loginId = request.getParameter("login_id");
		String password = request.getParameter("password");

		// パラメータをセッションに保存
		HttpSession session = request.getSession(true);
		session.setAttribute("lastName", lastName);
		session.setAttribute("firstName", firstName);
		session.setAttribute("loginId", loginId);
		session.setAttribute("password", password);


		// エラーメッセージの格納用
		List<String> errorMessages = new ArrayList<>();

		if (lastName == null || "".equals(lastName)) {
			errorMessages.add("姓が未入力です");
		}

		if (firstName == null || "".equals(firstName)) {
			errorMessages.add("名が未入力です");
		}

		// ログインIDに誤りがある場合
		// 5文字以上50文字以下、半角英数字、記号（@._-）
		if (loginId == null || !RegexManager.isPatternMatches("^[A-Za-z0-9@._-]{5,50}$", loginId)) {
			errorMessages.add("ログインIDは半角英数字、記号（@._-）で5文字以上、50文字以下で入力してください");
		}

		// パスワードが5文字以上、50文字以下を満たさない場合
		if (password == null || password.length() < 5 || 50 < password.length()) {
			errorMessages.add("パスワードは5文字以上、50文字以下で入力してください");
		}

		// 何らかの不具合がある場合は、signup.jspにフォワード
		if (!errorMessages.isEmpty()) {
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("WEB-INF/jsp/signup.jsp").forward(request, response);
			return;
		}


		// パスワードをハッシュ値に変換する
		password = HashGenerator.getHash(password);

		// ユーザーインスタンスの生成
		User user = new User();
		user.setId(loginId);
		user.setPassword(password);
		user.setLastName(lastName);
		user.setFirstName(firstName);
		user.setAuthority(USER_AUTHORITY);

		// ユーザーテーブルへのアカウント追加処理
		UserService userService = new UserService();
		int result = userService.addUser(user);

		// 一意制約違反の場合はエラーメッセージと共にsignup.jspにフォワードする
		// TODO: マジックナンバーになっているため、23505をEnumで扱いたい
		if (result == 23505) {
			errorMessages.add("入力されたログインIDは既に存在しています");
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("WEB-INF/jsp/signup.jsp").forward(request, response);
			return;
		}

		response.sendRedirect("signupComplete");
		return;

	}

}
