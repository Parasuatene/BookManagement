package jp.co.benesse.dataaccess.value;

public class Book {

	/**
	 * 書籍ID
	 */
	private int id;

	/**
	 * 書籍名
	 */
	private String title;

	/**
	 * 著者名
	 */
	private String author;

	/**
	 * 出版社名
	 */
	private String publisher;

	/**
	 * 書籍の画像パス
	 */
	private String imgPath;

	/**
	 * 書籍の説明文
	 */
	private String discription;

	/**
	 * 貸出管理クラス
	 */
	private RentalControl rentalControl;

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
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author セットする author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher セットする publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return imgPath
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * @param imgPath セットする imgPath
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	/**
	 * @return discription
	 */
	public String getDiscription() {
		return discription;
	}

	/**
	 * @param discription セットする discription
	 */
	public void setDiscription(String discription) {
		this.discription = discription;
	}

	/**
	 * @return rentalControl
	 */
	public RentalControl getRentalControl() {
		return rentalControl;
	}

	/**
	 * @param rentalControl セットする rentalControl
	 */
	public void setRentalControl(RentalControl rentalControl) {
		this.rentalControl = rentalControl;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", imgPath="
				+ imgPath + ", discription=" + discription + ", rentalControl.id=" + rentalControl.getId() + "]";
	}
}
