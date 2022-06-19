package jp.co.benesse.dataaccess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.benesse.dataaccess.value.User;

/**
 * UserテーブルのDAO
 * @author ryota_a
 */
public class UserDAO extends BaseDAO {

	/**
	 * コンストラクタ
	 * @param connection
	 */
	public UserDAO(Connection connection) {
		super(connection);
	}

	/**
	 * ユーザーテーブルにデータを追加する
	 * @param user
	 * @return 追加に成功すれば1を返す
	 * 		   一意性制約に違反した場合は23505を返す
	 */
	public int insert(User user) {
		PreparedStatement preparedStatement = null;
		try {
			// SQLの定義
			String sql = "INSERT INTO t_user "
						 + "(id, password, last_name, first_name, authority) "
						 + "VALUES (?,?,?,?,?)";
			// SQLの作成
			preparedStatement = getConnection().prepareStatement(sql);
			// 値の設定
			preparedStatement.setString(1, user.getId());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getFirstName());
			preparedStatement.setInt(5, user.getAuthority());
			// SQLの実行
			int result = preparedStatement.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO: 例外処理のラッパークラスを作成する（まさおに聞く）
			return Integer.parseInt(e.getSQLState());
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}


	/**
	 * IDとパスワードをもとにユーザー情報を取得する
	 * @param argId
	 * @param argPassword
	 * @return 取得できなかった場合はnullを返す
	 */
	public User selectByIdAndPassword(String argId, String argPassword) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// SQLの定義
			String sql = "SELECT id, password, last_name, first_name, authority "
						 + "FROM t_user "
						 + "WHERE id = ? AND password = ?";
			// SQLの作成
			preparedStatement = getConnection().prepareStatement(sql);
			// 値の設定
			preparedStatement.setString(1, argId);
			preparedStatement.setString(2, argPassword);
			// SQLの実行
			resultSet = preparedStatement.executeQuery();

			User user = null;
			// 問い合わせ結果の取得
			while(resultSet.next()) {
				String id = resultSet.getString("id");
				String password = resultSet.getString("password");
				String lastName = resultSet.getString("last_name");
				String firstName = resultSet.getString("first_name");
				int authority = resultSet.getInt("authority");

				user = new User();
				user.setId(id);
				user.setPassword(password);
				user.setLastName(lastName);
				user.setFirstName(firstName);
				user.setAuthority(authority);
			}
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

}
