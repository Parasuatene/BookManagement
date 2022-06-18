package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataaccess.value.Book;
import service.BookService;

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

		// 書籍一覧を取得する
		BookService bookService = new BookService();
		List<Book> bookList = bookService.getBookList();

		// リクエストにセット
		request.setAttribute("bookList", bookList);

		// フォワード処理
		request.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(request, response);
		return;

	}

}
