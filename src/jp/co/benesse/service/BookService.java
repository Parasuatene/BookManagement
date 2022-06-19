package jp.co.benesse.service;

import java.sql.Connection;
import java.util.List;

import jp.co.benesse.dataaccess.dao.BookDAO;
import jp.co.benesse.dataaccess.db.ConnectionManager;
import jp.co.benesse.dataaccess.value.Book;

public class BookService {

	/**
	 * データベースから書籍一覧を取得する
	 * @return データベース内の書籍リスト
	 */
	public List<Book> getBookList() {
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection connection = connectionManager.getConnection();
			BookDAO bookDAO = new BookDAO(connection);
			return bookDAO.selectAll();
		} finally {
			connectionManager.closeConnection();
		}
	}

	/**
	 * 指定したIDに該当する書籍情報を取得する
	 * @param argId
	 * @return IDに該当する書籍。または該当しない場合はnullを返す。
	 */
	public Book getBookById(int argId) {
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection connection = connectionManager.getConnection();
			BookDAO bookDAO = new BookDAO(connection);
			return bookDAO.selectById(argId);
		} finally {
			connectionManager.closeConnection();
		}
	}

	/**
	 * 指定した書籍IDが貸出中かどうかを確認する
	 * @param argId
	 * @return trueは貸出中、falseは貸出されていないことを示す
	 */
	public boolean isRentalBookById(int argId) {
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection connection = connectionManager.getConnection();
			BookDAO bookDAO = new BookDAO(connection);
			Book book = bookDAO.selectById(argId);

			// 取得できなかった場合はfalseを返す
			if (book == null) {
				return true;
			}

			// 貸出開始日に日付情報があり、且つ貸出終了日がnullのとき
			if (book.getRentalControl().getStartDate() != null
					&& book.getRentalControl().getEndDate() == null) {
				return true;
			}

			return false;
		} finally {
			connectionManager.closeConnection();
		}
	}

}
