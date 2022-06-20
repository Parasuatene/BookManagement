package jp.co.benesse.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.benesse.dataaccess.value.RentalControl;
import jp.co.benesse.service.RentalControlService;

/**
 * Servlet implementation class ReturnCompleteServlet
 */
@WebServlet("/returnComplete")
public class ReturnCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final int SUCCESS_UPDATE = 1;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// パラメータの取得
		String rentalId = request.getParameter("rental_id");

		// 貸出終了日の日付を取得
        Date endDate = new Date(System.currentTimeMillis());

        RentalControl rentalControl = new RentalControl();
        rentalControl.setId(Integer.parseInt(rentalId));
        rentalControl.setEndDate(endDate);

        // 貸出終了日の更新
        RentalControlService rentalControlService = new RentalControlService();
        int result = rentalControlService.updateEndDate(rentalControl);

        // 更新処理に成功
        if (result == SUCCESS_UPDATE) {
        	request.getRequestDispatcher("WEB-INF/jsp/returnComplete.jsp").forward(request, response);
        	return;
        } else {
        	response.sendRedirect("errorReturnRequest");
        	return;
        }
	}

}
