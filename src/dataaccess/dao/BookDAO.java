package dataaccess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataaccess.value.Book;

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
			String sql = "SELECT id, title, author, publisher, img_path, discription "
						 + "FROM t_book";
			// SQLの作成
			preparedStatement = getConnection().prepareStatement(sql);
			// SQLの実行
			resultSet = preparedStatement.executeQuery();
			// 結果を格納するためのリスト
			List<Book> bookList = new ArrayList<Book>();
			while(resultSet.next()) {
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublisher(resultSet.getString("publisher"));
				book.setImgPath(resultSet.getString("img_path"));
				book.setDiscription(resultSet.getString("discription"));
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
			String sql = "SELECT id, title, author, publisher, img_path, discription "
					 	 + "FROM t_book "
					 	 + "WHERE id = ?";
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
				book.setId(resultSet.getInt("id"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setPublisher(resultSet.getString("publisher"));
				book.setImgPath(resultSet.getString("img_path"));
				book.setDiscription(resultSet.getString("discription"));
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
}
