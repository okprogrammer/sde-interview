package bit.problems;

public class SwappingOfTwoVariable {
	static void swap(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("value of a: " + a + " Value of b :" + b);
	}

	public static void main(String[] args) {
		swap(4, 5);
	}

}
