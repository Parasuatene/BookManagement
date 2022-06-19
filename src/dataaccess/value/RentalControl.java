package dataaccess.value;

import java.sql.Date;

/**
 * 貸出履歴の管理クラス
 * @author ryota_a
 */
public class RentalControl {

	/**
	 * 管理番号
	 */
	private int id;

	/**
	 * ユーザーID
	 */
	private String userId;

	/**
	 * 書籍番号
	 */
	private int bookId;

	/**
	 * 貸出開始日
	 */
	private Date startDate;

	/**
	 * 返却予定日
	 */
	private Date scheduleDate;

	/**
	 * 貸出終了日
	 */
	private Date endDate;

	/**
	 * コンストラクタ
	 */
	public RentalControl() {
		endDate = null;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * @param bookId セットする bookId
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate セットする startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return scheduleDate
	 */
	public Date getScheduleDate() {
		return scheduleDate;
	}

	/**
	 * @param scheduleDate セットする scheduleDate
	 */
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	/**
	 * @return endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate セットする endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
