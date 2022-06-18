package service;

import java.sql.Connection;
import java.util.List;

import dataaccess.dao.BookDAO;
import dataaccess.db.ConnectionManager;
import dataaccess.value.Book;

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

}
