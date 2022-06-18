package service;

import java.sql.Connection;

import dataaccess.dao.UserDAO;
import dataaccess.db.ConnectionManager;
import dataaccess.value.User;

public class UserService {
	/**
	 * Userテーブルにデータを追加する
	 * @param user
	 */
	public int addUser(User user) {
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection connection = connectionManager.getConnection();
			UserDAO userDAO = new UserDAO(connection);
			int result = userDAO.insert(user);
			connectionManager.commit();
			System.out.println("コミットしました");
			return result;
		} catch (RuntimeException e) {
			connectionManager.rollback();
			throw e;
		} finally {
			connectionManager.closeConnection();
		}
	}
}
