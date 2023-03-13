package practice;

public class Main {

	public static void main(String[] args) {
		for (LocationTypes s : LocationTypes.values()) {
			System.out.println(s.valueOf("hc"));
		}
		System.out.println("Winter value " + LocationTypes.valueOf("HOT_COLD"));
		System.out.println("Winter index " + LocationTypes.valueOf("HOT_COLD").ordinal());
	}

}
