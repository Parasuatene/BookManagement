package dataaccess.value;

/**
 * ユーザー情報を操作するクラス
 * @author ryota_a
 */
public class User {
	/**
	 * ログインID
	 */
	private String id;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * 姓
	 */
	private String lastName;

	/**
	 * 名
	 */
	private String firstName;

	/**
	 * 権限（0:一般ユーザー、1:管理者ユーザー）
	 */
	private int authority;

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName セットする lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName セットする firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return authority
	 */
	public int getAuthority() {
		return authority;
	}

	/**
	 * @param authority セットする authority
	 */
	public void setAuthority(int authority) {
		this.authority = authority;
	}

}
