package jp.co.benesse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jp.co.benesse.dataaccess.value.Book;
import jp.co.benesse.dataaccess.value.Category;
import jp.co.benesse.service.BookService;

/**
 * Servlet implementation class RegistrationCompleteServlet
 */
@WebServlet("/registrationComplete")
@MultipartConfig(fileSizeThreshold = 5000000, maxFileSize = 10000000)
public class RegistrationCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ファイル名を抽出する
	 * @param part
	 * @return
	 */
	private String getFileName(Part part) {
		String name = null;
		for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
			if (dispotion.trim().startsWith("filename")) {
				name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
				name = name.substring(name.lastIndexOf("\\") + 1);
				break;
			}
		}
		return name;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// パラメータの取得
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String discription = request.getParameter("discription");
		String categoryId = request.getParameter("category");

		// アップロードファイルデータの取得
		Part part = request.getPart("uploadfile");
		String filename = this.getFileName(part);

		// TODO: 画像を指定しなかった際にエラーになるので修正する
		if (filename != null) {
			part.write(getServletContext().getRealPath("/img") + "/" + filename);
			System.out.println("[ " + filename + " ]のアップロードが完了しました");
		} else {
			System.out.println("アップロードが失敗しました");
		}

		// Bookインスタンスの生成
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setDiscription(discription);
		book.setImgPath(filename);

		Category category = new Category();
		category.setId(Integer.parseInt(categoryId));
		book.setCategory(category);

		// データベースに書籍を追加する
		BookService bookService = new BookService();
		bookService.addBook(book);

		request.getRequestDispatcher("WEB-INF/jsp/registrationComplete.jsp").forward(request, response);
		return;
	}

}
