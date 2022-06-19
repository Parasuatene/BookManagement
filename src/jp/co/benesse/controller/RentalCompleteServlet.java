package jp.co.benesse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.benesse.service.BookService;

/**
 * Servlet implementation class RentalComplete
 */
@WebServlet("/rentalComplete")
public class RentalCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// パラメータの取得
		String startDate = request.getParameter("start_date");
		String scheduleDate = request.getParameter("schedule_date");
		String bookId = request.getParameter("book_id");

		// ユーザーIDの取得
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("id");

		// ユーザー情報が取得できなかった場合はエラーページにフォワードし、ログインするように促す
		if (userId == null) {
			System.out.println("ログインしてください");
			return;
		}

		// 貸出中かどうかを再度確かめ、貸出済みの場合、エラーページにリダイレクトする
		BookService bookService = new BookService();
		if (bookService.isRentalBookById(Integer.parseInt(bookId))) {
			response.sendRedirect("errorRentalRequest");
			return;
		}



		request.getRequestDispatcher("WEB-INF/jsp/rentalComplete.jsp").forward(request, response);
		return;
	}

}
