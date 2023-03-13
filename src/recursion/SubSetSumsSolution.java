package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SubSetSumsSolution {
	static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
		ArrayList<Integer> ans = new ArrayList<>();
		subsetSums(arr, N, 0, 0, ans);
		return ans;
	}

	static private void subsetSums(ArrayList<Integer> arr, int n, int i, int sum, ArrayList<Integer> ans) {
		if (i == n) {
			ans.add(sum);
			return;
		}
		subsetSums(arr, n, i + 1, sum + arr.get(i), ans);
		subsetSums(arr, n, i + 1, sum, ans);
	}


	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(2);
		list.add(1);
		ArrayList<Integer> ans = subsetSums(list, list.size());
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
		System.out.println("==============================");
	}
}
