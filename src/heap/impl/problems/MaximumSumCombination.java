package heap.impl.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
	private int x;
	private int y;
	private int sum;

	public Pair(int x, int y, int sum) {
		this.x = x;
		this.y = y;
		this.sum = sum;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

}

public class MaximumSumCombination {

	static ArrayList<Integer> maxSumCombination(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.getSum() - a.getSum());
		Collections.sort(A, Collections.reverseOrder());
		Collections.sort(B, Collections.reverseOrder());
		ArrayList<Integer> tempRes = new ArrayList<>();
		HashSet<ArrayList<Integer>> list = new HashSet<>();
		pq.add(new Pair(0, 0, A.get(0) + B.get(0)));
		tempRes.add(0);
		tempRes.add(0);
		int m = A.size();
		int n = B.size();
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < C; i++) {
			Pair p = pq.poll();
			int x = p.getX();
			int y = p.getY();
			res.add(p.getSum());
			if (x + 1 < m && !list.contains(Arrays.asList(x + 1, y))) {
				pq.add(new Pair(x + 1, y, A.get(x + 1) + B.get(y)));
				ArrayList<Integer> arr = new ArrayList<>();
				arr.add(x + 1);
				arr.add(y);
				list.add(arr);
			}
			if (y + 1 < n && !list.contains(Arrays.asList(x, y + 1))) {
				pq.add(new Pair(x, y + 1, A.get(x) + B.get(y + 1)));
				ArrayList<Integer> arr = new ArrayList<>();
				arr.add(x);
				arr.add(y + 1);
				list.add(arr);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(4);
		A.add(2);
		A.add(3);
		ArrayList<Integer> B = new ArrayList<>();
		B.add(2);
		B.add(5);
		B.add(1);
		B.add(6);
		ArrayList<Integer> ans = maxSumCombination(A, B, 4);
		ans.forEach(e -> System.out.println(e));
	}
}
