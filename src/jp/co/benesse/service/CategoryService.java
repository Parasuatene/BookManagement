package jp.co.benesse.service;

import java.sql.Connection;
import java.util.List;

import jp.co.benesse.dataaccess.dao.CategoryDAO;
import jp.co.benesse.dataaccess.db.ConnectionManager;
import jp.co.benesse.dataaccess.value.Category;

public class CategoryService {

	/**
	 * データベースから書籍一覧を取得する
	 * @return データベース内の書籍リスト
	 */
	public List<Category> getCategoryList() {
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection connection = connectionManager.getConnection();
			CategoryDAO categoryDAO = new CategoryDAO(connection);
			return categoryDAO.selectAll();
		} finally {
			connectionManager.closeConnection();
		}
	}

}
