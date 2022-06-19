package jp.co.benesse.dataaccess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.co.benesse.dataaccess.value.RentalControl;

public class RentalControlDAO extends BaseDAO {

	/**
	 * コンストラクタ
	 * @param connection
	 */
	public RentalControlDAO(Connection connection) {
		super(connection);
	}

	/**
	 * RentalControlテーブルにデータを追加する
	 * @param rentalControl
	 * @return 追加に成功すれば1を返す
	 */
	public int insert(RentalControl rentalControl) {
		PreparedStatement preparedStatement = null;
		try {
			// SQLの定義
			String sql = "INSERT INTO t_rental_control "
						 + "(user_id, book_id, start_date, schedule_date) "
						 + "VALUES (?,?,?,?)";
			// SQLの作成
			preparedStatement = getConnection().prepareStatement(sql);
			// 値の設定
			preparedStatement.setString(1, rentalControl.getUserId());
			preparedStatement.setInt(2, rentalControl.getBookId());
			preparedStatement.setDate(3, rentalControl.getStartDate());
			preparedStatement.setDate(4, rentalControl.getScheduleDate());
			// SQLの実行
			int result = preparedStatement.executeUpdate();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException("EMPLOYEEテーブルのINSERTに失敗しました", e);
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
