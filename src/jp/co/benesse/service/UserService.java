package jp.co.benesse.service;

import java.sql.Connection;

import jp.co.benesse.dataaccess.dao.UserDAO;
import jp.co.benesse.dataaccess.db.ConnectionManager;
import jp.co.benesse.dataaccess.value.User;

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

	/**
	 * IDとパスワードをもとにユーザー情報を取得する
	 * @param argId
	 * @param argPassword
	 * @return 該当するユーザーのインスタンスを返す。取得できなかった場合はnullを返す
	 */
	public User getUserByIdAndPassword(String argId, String argPassword) {
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection connection = connectionManager.getConnection();
			UserDAO userDAO = new UserDAO(connection);
			User user = userDAO.selectByIdAndPassword(argId, argPassword);
			return user;
		} finally {
			connectionManager.closeConnection();
		}
	}
}
