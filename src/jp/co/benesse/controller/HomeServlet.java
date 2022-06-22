package jp.co.benesse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.benesse.dataaccess.value.Book;
import jp.co.benesse.service.BookService;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 本の検索ワード
		String searchQuery = request.getParameter("q");

		// 検索クエリに応じて表示する書籍を変更する
		BookService bookService = new BookService();
		List<Book> bookList = new ArrayList<Book>();
		if (searchQuery == null || "".equals(searchQuery)) {
			// 全ての書籍を取得する
			bookList = bookService.getBookList();
		} else {
			// 検索クエリに該当する書籍を取得する
			bookList = bookService.getBookListByQuery(searchQuery);
		}

		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(request, response);
		return;
	}

}
