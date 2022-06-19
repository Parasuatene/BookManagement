package jp.co.benesse.service;

import java.sql.Connection;

import jp.co.benesse.dataaccess.dao.RentalControlDAO;
import jp.co.benesse.dataaccess.db.ConnectionManager;
import jp.co.benesse.dataaccess.value.RentalControl;

public class RentalControlService {

	/**
	 * RentalControlテーブルにデータを追加する
	 * @param user
	 */
	public int addData(RentalControl rentalControl) {
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection connection = connectionManager.getConnection();
			RentalControlDAO rentalControlDAO = new RentalControlDAO(connection);
			int result = rentalControlDAO.insert(rentalControl);
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

}
