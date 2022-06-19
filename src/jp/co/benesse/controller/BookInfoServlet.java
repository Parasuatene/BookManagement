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
 * Servlet implementation class BookInfoServlet
 */
@WebServlet("/bookInfo")
public class BookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 書籍IDの取得
		String bookId = request.getParameter("id");

		// bookIdがnull、または空文字の場合は「お探しのページは見つかりませんでした」と表示する
		if (bookId == null || "".equals(bookId)) {
			request.getRequestDispatcher("WEB-INF/jsp/bookInfo.jsp").forward(request, response);
			return;
		}

		// IDに紐づく書籍情報をDBから取得する
		BookService bookService = new BookService();
		Book book = bookService.getBookById(Integer.parseInt(bookId));

		// bookがnullの時は「お探しのページは見つかりませんでした」と表示する
		if (book == null) {
			request.getRequestDispatcher("WEB-INF/jsp/bookInfo.jsp").forward(request, response);
			return;
		}

		// bookをリクエストにセットし、bookInfoへフォワードする
		request.setAttribute("book", book);
		request.getRequestDispatcher("WEB-INF/jsp/bookInfo.jsp").forward(request, response);
		return;
	}

}
