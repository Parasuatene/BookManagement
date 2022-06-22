package jp.co.benesse.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.benesse.dataaccess.value.RentalControl;
import jp.co.benesse.service.BookService;
import jp.co.benesse.service.RentalControlService;

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

		// TODO: ユーザー情報が取得できなかった場合はエラーページにフォワードし、ログインするように促す
		if (userId == null) {
			response.sendRedirect("login");
			return;
		}

		// 貸出中かどうかを再度確かめ、貸出済みの場合、エラーページにリダイレクトする
		BookService bookService = new BookService();
		if (bookService.isRentalBookById(Integer.parseInt(bookId))) {
			response.sendRedirect("errorRentalRequest");
			return;
		}

		// 貸出管理テーブルにデータを追加する
		RentalControlService rentalControlService = new RentalControlService();
		RentalControl rentalControl = new RentalControl();
		rentalControl.setUserId(userId);
		rentalControl.setBookId(Integer.parseInt(bookId));
		rentalControl.setStartDate(Date.valueOf(startDate));
		rentalControl.setScheduleDate(Date.valueOf(scheduleDate));
		rentalControlService.addData(rentalControl);

		request.getRequestDispatcher("WEB-INF/jsp/rentalComplete.jsp").forward(request, response);
		return;
	}

}
