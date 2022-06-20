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
	 * 指定したレンタルIDの貸出終了日を更新する
	 * @param argRentalId
	 * @param argEndDate
	 * @return 更新に成功すれば1を返す
	 */
	public int update(RentalControl rentalControl) {
		PreparedStatement preparedStatement = null;
		try {
			// SQLの定義
			String sql = "UPDATE t_rental_control "
						 + "SET end_date = ? "
						 + "WHERE id = ?";
			// SQLの作成
			preparedStatement = getConnection().prepareStatement(sql);
			// 値の設定
			preparedStatement.setDate(1, rentalControl.getEndDate());
			preparedStatement.setInt(2, rentalControl.getId());
			// SQLの実行
			int result = preparedStatement.executeUpdate();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException("RentalControlテーブルのUPDATEに失敗しました", e);
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
			throw new RuntimeException("RentalControlテーブルのINSERTに失敗しました", e);
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
