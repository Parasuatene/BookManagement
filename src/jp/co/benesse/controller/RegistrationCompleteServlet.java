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
 * Servlet implementation class RegistrationCompleteServlet
 */
@WebServlet("/registrationComplete")
public class RegistrationCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// パラメータの取得
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String discription = request.getParameter("discription");

		// Bookインスタンスの生成
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setDiscription(discription);

		// データベースに書籍を追加する
		BookService bookService = new BookService();
		bookService.addBook(book);

		request.getRequestDispatcher("WEB-INF/jsp/registrationComplete.jsp").forward(request, response);
		return;
	}

}
