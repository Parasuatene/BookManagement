package jp.co.benesse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.benesse.dataaccess.value.Book;
import jp.co.benesse.service.BookService;

/**
 * Servlet implementation class ReturnRequestServlet
 */
@WebServlet("/returnRequest")
public class ReturnRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// パラメータの取得
		String rentalId = request.getParameter("id");

		// レンタルIDに紐づく書籍を取得
		BookService bookService = new BookService();
		Book book = bookService.getBookByRentalId(Integer.parseInt(rentalId));

		// TODO: bookがnullの時は「お探しのページは見つかりませんでした」と表示する
		if (book == null) {
			request.getRequestDispatcher("WEB-INF/jsp/rentalRequest.jsp").forward(request, response);
			return;
		}

		// bookをリクエストし、フォワードする
		request.setAttribute("book", book);
		request.getRequestDispatcher("WEB-INF/jsp/returnRequest.jsp").forward(request, response);
		return;
	}

}
