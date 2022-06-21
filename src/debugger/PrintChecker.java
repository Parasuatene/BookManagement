package debugger;

public class PrintChecker {

	public static void print(String label, int message) {
		System.out.println("【" + label + "】" + message);
	}

	public static void print(String label, String message) {
		System.out.println("【" + label + "】" + message);
	}

	public static void print(String label, String... messages) {
		for (String m: messages) {
			System.out.println("【" + label + "】" + m);
		}
	}
}
