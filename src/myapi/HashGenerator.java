package myapi;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ハッシュ値を生成するクラス
 * @author ryota_a
 *
 */
public class HashGenerator {

	/**
	 * SHA3-256をもとにハッシュ値を生成する
	 * @param text ハッシュ値にしたい文字列
	 * @return ハッシュ値
	 * @throws NoSuchAlgorithmException
	 */
	public static String getHash(String text) throws NoSuchAlgorithmException {
		// SHA3-256（SHA-3）
		MessageDigest sha3_256 = MessageDigest.getInstance("SHA3-256");
		byte[] sha3_256_result = sha3_256.digest("aa".getBytes());
		return String.format("%040x", new BigInteger(1, sha3_256_result));
	}
}
