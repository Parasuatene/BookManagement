package jp.co.benesse.dataaccess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.benesse.dataaccess.value.Category;

public class CategoryDAO extends BaseDAO {

	/**
	 * コンストラクタ
	 * @param connection
	 */
	public CategoryDAO(Connection connection) {
		super(connection);
	}

	/**
	 * Bookテーブルから全てのデータを取得する
	 * @return bookテーブル内の全てのデータ
	 */
	public List<Category> selectAll() {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// SQLの定義
			String sql = "SELECT id, name FROM t_category";
			// SQLの作成
			preparedStatement = getConnection().prepareStatement(sql);
			// SQLの実行
			resultSet = preparedStatement.executeQuery();
			// 結果を格納するためのリスト
			List<Category> categoryList = new ArrayList<Category>();
			while(resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("name"));

				categoryList.add(category);
			}
			return categoryList;
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

}
