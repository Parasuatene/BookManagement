package dataaccess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dataaccess.value.User;

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

}
