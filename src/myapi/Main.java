package myapi;

public class Main {

	public static void main(String[] args) {
//		User user = new User();
//		user.setId("@ryota_a");
//		user.setPassword("aaa");
//		user.setLastName("Ando");
//		user.setFirstName("Ryota");
//		user.setAuthority(0);
//
//		UserService userService = new UserService();
//		int result = userService.addUser(user);
//		System.out.println(result);


//		String id_1 = "@ryota_a";
//		String id_2 = "@,ryota_a";
//		String id_3 = "abcd_ed";
//		// 5文字以上50文字以下、半角英数字、記号（@._-）
//		Pattern pattern = Pattern.compile("^[A-Za-z0-9@._-]{5,50}$");
//		Matcher matcher = pattern.matcher(id_1);
//		System.out.println(pattern.matcher(id_1).matches());
//		System.out.println(pattern.matcher(id_2).matches());
//		System.out.println(pattern.matcher(id_3).matches());

//        long miliseconds = System.currentTimeMillis();
//        Date date = new Date(miliseconds);
//        System.out.println(date);

		System.out.println(HashGenerator.getHash("admin"));
	}

}
