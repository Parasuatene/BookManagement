package dataaccess.dao;

import java.sql.Connection;

/**
 * BaseDAOクラス
 * @author ryota_a
 */
public class BaseDAO {

	/**
	 * コネクション
	 */
	private Connection connection;

	/**
	 * コンストラクタ
	 * @param connection
	 */
	public BaseDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * コネクションのゲッター
	 * @return connection
	 */
	public Connection getConnection() {
		return connection;
	}
}
