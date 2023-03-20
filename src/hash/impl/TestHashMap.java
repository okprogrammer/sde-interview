package hash.impl;

public class TestHashMap {

	public static void main(String[] args) throws Exception {
		CustomHashMap<String, String> map = new CustomHashMap<>();
		for (int i = 1; i < 100; i++) {
			map.put(i + "_Key", i + "_Value");
		}
		for (Node<String, String> e : map.getEntrySet()) {
			System.out.println(e);
		}
	}

}
