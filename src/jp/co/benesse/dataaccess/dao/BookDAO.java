package jp.co.benesse.dataaccess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.benesse.dataaccess.value.Book;
import jp.co.benesse.dataaccess.value.RentalControl;

public class BookDAO extends BaseDAO {

	/**
	 * コンストラクタ
	 * @param connection
	 */
	public BookDAO(Connection connection) {
		super(connection);
	}

	/**
	 * Bookテーブルから全てのデータを取得する
	 * @return bookテーブル内の全てのデータ
	 */
	public List<Book> selectAll() {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// SQLの定義
			String sql = "SELECT tb.id AS tb_id, tb.title AS tb_title, tb.author AS tb_author"
						 + ", tb.publisher AS tb_publisher, tb.img_path AS tb_img_path, tb.discription AS tb_discription"
						 + ", vr.id AS vr_id, vr.user_id AS vr_user_id, vr.book_id AS vr_book_id"
						 + ", vr.start_date AS vr_start_date, vr.schedule_date AS vr_schedule_date, vr.end_date AS vr_end_date "
						 + "FROM t_book AS tb "
						 + "LEFT OUTER JOIN v_latest_rental_info AS vr "
						 + "ON tb.id = vr.book_id";
			// SQLの作成
			preparedStatement = getConnection().prepareStatement(sql);
			// SQLの実行
			resultSet = preparedStatement.executeQuery();
			// 結果を格納するためのリスト
			List<Book> bookList = new ArrayList<Book>();
			while(resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("tb_id"));
				book.setTitle(resultSet.getString("tb_title"));
				book.setAuthor(resultSet.getString("tb_author"));
				book.setPublisher(resultSet.getString("tb_publisher"));
				book.setImgPath(resultSet.getString("tb_img_path"));
				book.setDiscription(resultSet.getString("tb_discription"));

				RentalControl rentalControl = new RentalControl();
				rentalControl.setId(resultSet.getInt("vr_id"));  // TODO: 貸出管理番号が取得できるようにする
				rentalControl.setUserId(resultSet.getString("vr_user_id"));
				rentalControl.setBookId(resultSet.getInt("vr_book_id"));
				rentalControl.setStartDate(resultSet.getDate("vr_start_date"));
				rentalControl.setScheduleDate(resultSet.getDate("vr_schedule_date"));
				rentalControl.setEndDate(resultSet.getDate("vr_end_date"));
				book.setRentalControl(rentalControl);

				bookList.add(book);
			}
			return bookList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}


	/**
	 * 指定したIDに該当する書籍情報を取得する
	 * @param argId
	 * @return IDに該当する書籍。または該当しない場合はnullを返す。
	 */
	public Book selectById(int argId) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// SQLの定義
			String sql = "SELECT tb.id AS tb_id, tb.title AS tb_title, tb.author AS tb_author"
						 + ", tb.publisher AS tb_publisher, tb.img_path AS tb_img_path, tb.discription AS tb_discription"
						 + ", vr.id AS vr_id, vr.user_id AS vr_user_id, vr.book_id AS vr_book_id"
						 + ", vr.start_date AS vr_start_date, vr.schedule_date AS vr_schedule_date, vr.end_date AS vr_end_date "
						 + "FROM t_book AS tb "
						 + "LEFT OUTER JOIN v_latest_rental_info AS vr "
						 + "ON tb.id = vr.book_id "
						 + "WHERE tb.id = ?";
			// SQLの作成
			preparedStatement = getConnection().prepareStatement(sql);
			// 値の設定
			preparedStatement.setInt(1, argId);
			// SQLの実行
			resultSet = preparedStatement.executeQuery();

			Book book = null;
			// 問い合わせ結果の取得
			while(resultSet.next()) {
				book = new Book();
				book.setId(resultSet.getInt("tb_id"));
				book.setTitle(resultSet.getString("tb_title"));
				book.setAuthor(resultSet.getString("tb_author"));
				book.setPublisher(resultSet.getString("tb_publisher"));
				book.setImgPath(resultSet.getString("tb_img_path"));
				book.setDiscription(resultSet.getString("tb_discription"));

				RentalControl rentalControl = new RentalControl();
				rentalControl.setId(resultSet.getInt("vr_id"));  // TODO: 貸出管理番号が取得できるようにする
				rentalControl.setUserId(resultSet.getString("vr_user_id"));
				rentalControl.setBookId(resultSet.getInt("vr_book_id"));
				rentalControl.setStartDate(resultSet.getDate("vr_start_date"));
				rentalControl.setScheduleDate(resultSet.getDate("vr_schedule_date"));
				rentalControl.setEndDate(resultSet.getDate("vr_end_date"));
				book.setRentalControl(rentalControl);
			}
			return book;
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

	/**
	 * 指定したレンタルIDに該当する書籍情報を取得する
	 * @param argRentalId
	 * @return IDに該当する書籍。または該当しない場合はnullを返す。
	 */
	public Book selectByRentalId(int argRentalId) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// SQLの定義
			String sql = "SELECT tb.id AS tb_id, tb.title AS tb_title, tb.author AS tb_author"
						 + ", tb.publisher AS tb_publisher, tb.img_path AS tb_img_path, tb.discription AS tb_discription"
						 + ", vr.id AS vr_id, vr.user_id AS vr_user_id, vr.book_id AS vr_book_id"
						 + ", vr.start_date AS vr_start_date, vr.schedule_date AS vr_schedule_date, vr.end_date AS vr_end_date "
						 + "FROM t_book AS tb "
						 + "LEFT OUTER JOIN v_latest_rental_info AS vr "
						 + "ON tb.id = vr.book_id "
						 + "WHERE vr.id = ?";
			// SQLの作成
			preparedStatement = getConnection().prepareStatement(sql);
			// 値の設定
			preparedStatement.setInt(1, argRentalId);
			// SQLの実行
			resultSet = preparedStatement.executeQuery();

			Book book = null;
			// 問い合わせ結果の取得
			while(resultSet.next()) {
				book = new Book();
				book.setId(resultSet.getInt("tb_id"));
				book.setTitle(resultSet.getString("tb_title"));
				book.setAuthor(resultSet.getString("tb_author"));
				book.setPublisher(resultSet.getString("tb_publisher"));
				book.setImgPath(resultSet.getString("tb_img_path"));
				book.setDiscription(resultSet.getString("tb_discription"));

				RentalControl rentalControl = new RentalControl();
				rentalControl.setId(resultSet.getInt("vr_id"));  // TODO: 貸出管理番号が取得できるようにする
				rentalControl.setUserId(resultSet.getString("vr_user_id"));
				rentalControl.setBookId(resultSet.getInt("vr_book_id"));
				rentalControl.setStartDate(resultSet.getDate("vr_start_date"));
				rentalControl.setScheduleDate(resultSet.getDate("vr_schedule_date"));
				rentalControl.setEndDate(resultSet.getDate("vr_end_date"));
				book.setRentalControl(rentalControl);
			}
			return book;
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

	/**
	 * ユーザーの貸出中書籍リストを取得する
	 * @param ユーザーID
	 * @return
	 */
	public List<Book> selectRentalBookListByUserId(String argUserId) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// SQLの定義
			String sql = "SELECT tb.id AS tb_id, tb.title AS tb_title, tb.author AS tb_author"
					 + ", tb.publisher AS tb_publisher, tb.img_path AS tb_img_path, tb.discription AS tb_discription"
					 + ", tr.id AS tr_id, tr.user_id AS tr_user_id, tr.book_id AS tr_book_id"
					 + ", tr.start_date AS tr_start_date, tr.schedule_date AS tr_schedule_date, tr.end_date AS tr_end_date "
					 + "FROM (SELECT * FROM t_rental_control WHERE user_id=? AND start_date IS NOT NULL AND end_date IS NULL) AS tr "
					 + "INNER JOIN t_book AS tb "
					 + "ON tr.book_id = tb.id ";
			// SQLの作成
			preparedStatement = getConnection().prepareStatement(sql);
			// 値の設定
			preparedStatement.setString(1, argUserId);
			// SQLの実行
			resultSet = preparedStatement.executeQuery();

			// 結果を格納するためのリスト
			List<Book> bookList = new ArrayList<Book>();
			// 問い合わせ結果の取得
			while(resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("tb_id"));
				book.setTitle(resultSet.getString("tb_title"));
				book.setAuthor(resultSet.getString("tb_author"));
				book.setPublisher(resultSet.getString("tb_publisher"));
				book.setImgPath(resultSet.getString("tb_img_path"));
				book.setDiscription(resultSet.getString("tb_discription"));

				RentalControl rentalControl = new RentalControl();
				rentalControl.setId(resultSet.getInt("tr_id"));  // TODO: 貸出管理番号が取得できるようにする
				rentalControl.setUserId(resultSet.getString("tr_user_id"));
				rentalControl.setBookId(resultSet.getInt("tr_book_id"));
				rentalControl.setStartDate(resultSet.getDate("tr_start_date"));
				rentalControl.setScheduleDate(resultSet.getDate("tr_schedule_date"));
				rentalControl.setEndDate(resultSet.getDate("tr_end_date"));
				book.setRentalControl(rentalControl);

				bookList.add(book);
			}
			return bookList;
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
