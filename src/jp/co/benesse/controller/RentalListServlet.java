package jp.co.benesse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.benesse.dataaccess.value.Book;
import jp.co.benesse.service.BookService;

/**
 * Servlet implementation class RentalListServlet
 */
@WebServlet("/rentalList")
public class RentalListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッションからユーザーIDを抽出
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("id");

		// TODO: 取得に失敗した場合はエラーページにフォワードする
		if ("".equals(userId)) {
			System.out.println("エラー");
			return;
		}

		// 貸出中の書籍一覧を取得する
		BookService bookService = new BookService();
		List<Book> rentalBookList = bookService.getRentalBookListByUserId(userId);

		// リクエストに値をセット
		request.setAttribute("rentalBookList", rentalBookList);
		request.getRequestDispatcher("WEB-INF/jsp/rentalList.jsp").forward(request, response);
		return;
	}

}
