package jp.co.benesse.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.benesse.dataaccess.value.Category;
import jp.co.benesse.service.CategoryService;

/**
 * Servlet implementation class BookRegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// カテゴリ一覧を取得
		CategoryService categoryService = new CategoryService();
		List<Category> categoryList = categoryService.getCategoryList();

		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("WEB-INF/jsp/registration.jsp").forward(request, response);
		return;
	}

}
