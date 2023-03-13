package string.impl;

public class LRUCacheImpl {

	public static void main(String[] args) {
		LRUCache l = new LRUCache(2);
//		["LRUCache","put","put","put","put","get","get"]
//				[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
		l.put(2, 1);
		l.put(1, 1);
		l.put(2, 3);
		l.put(4, 1);
		System.out.println(l.get(1));
		System.out.println(l.get(2));
	}

}
