package jp.co.benesse.dataaccess.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * データベースとのコネクション管理クラス
 * @author ryota_a
 */
public class ConnectionManager {

	/**
	 * 接続ドライバー名
	 */
	private static final String DRIVER_NAME = "org.postgresql.Driver";

	/**
	 * リソースファイルのファイルパス
	 */
	private final String RESOURCE_PATH = "resources/settings";

	static {
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("ドライバーのロードに成功しました");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("ドライバーのロードに失敗しました", e);
        }
	}

	/**
	 * コネクション
	 */
	private Connection connection;

	/**
	 * JDBCドライバーを利用して、データベースへの接続を実行する
	 * @return connection
	 */
	public Connection getConnection() {
		// 一度しか実行させないようにする
		if (connection == null) {
			try {
				ResourceBundle rb = readResourceBundle(RESOURCE_PATH);
				String url = rb.getString("url");
				String user = rb.getString("user");
				String password = rb.getString("password");

				connection = DriverManager.getConnection(url, user, password);
				// コミットモードを手動化
				connection.setAutoCommit(false);
				System.out.println("データベースの接続に成功しました");
			} catch (Exception e) {
				throw new RuntimeException("データベースの接続に失敗しました", e);
			}
		}
		return connection;
	}

	/**
	 * ResourceBundleを利用して、ログインに関する設定ファイルを読み込む
	 */
	public ResourceBundle readResourceBundle(String resourcePath) {
		try {
			ResourceBundle rb = ResourceBundle.getBundle(resourcePath);
			System.out.println("設定ファイルの読み込みに成功しました");
			return rb;
		} catch (Exception e) {
			throw new RuntimeException("設定ファイルの読み込みに失敗しました", e);
		}
	}

	/**
	 * JDBCドライバーを利用して、データベースとの接続を切断する
	 */
	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
				System.out.println("データベースの切断に成功しました");
			}
		} catch (Exception e) {
			throw new RuntimeException("データベースの切断に失敗しました", e);
		}
	}

	/**
	 * トランザクションをコミットする
	 */
	public void commit() {
		try {
			if (connection != null) {
				connection.commit();
				System.out.println("トランザクションのコミットに成功しました");
			}
		} catch (SQLException e) {
			throw new RuntimeException("トランザクションのコミットに失敗しました");
		}
	}

	/**
	 * トランザクションをロールバックする
	 */
	public void rollback() {
		try {
			if (connection != null) {
				connection.rollback();
				System.out.println("トランザクションのロールバックに成功しました");
			}
		} catch (SQLException e) {
			throw new RuntimeException("トランザクションのロールバックに失敗しました", e);
		}
	}

}
