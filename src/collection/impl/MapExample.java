package collection.impl;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapExample {
	public static void main(String[] args) {
//		Map<Integer, String> lhm = new LinkedHashMap<>(Map.of(1, "A", 2, "B", 3, "C", 4, "D", 5, "E"));
		Map<Integer, String> lhm = new LinkedHashMap<>(5, .75f, true) {
			protected boolean removeEldestEntry(Map.Entry e) {
				return size()>5;
			}
		};
		lhm.put(1, "A");
		lhm.put(2, "B");
		lhm.put(3, "C");
		lhm.put(4, "D");
		lhm.put(5, "E");
		lhm.put(6, "F");
		lhm.put(7, "G");
		for(Map.Entry<Integer, String> e: lhm.entrySet())
		lhm.forEach((k, v) -> System.out.println(k + " " + v));
	}
}
