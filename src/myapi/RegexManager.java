package myapi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexManager {
	/**
	 * 指定したパターンと文字列がマッチするかどうかを確認する
	 * @param regexPattern 正規表現パターン
	 * @param sequence 検査したい文字列
	 * @return マッチする場合はtrue、そうでない場合はfalseを返す
	 */
	public static boolean isPatternMatches(String regexPattern, String sequence) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(sequence);
		return matcher.matches();
	}
}
