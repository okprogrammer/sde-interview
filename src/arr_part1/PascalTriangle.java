package arr_part1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PascalTriangle {

	static List<List<Integer>> pascalTriangle(List<List<Integer>> list, int n) {
		for (int i = 0; i < n; i++) {

			if (i == 0) {
				
				list.add(new ArrayList<>());
				List<Integer> l = new ArrayList<>();
				l.add(0,1);
				list.set(0,l);
				
			} else {
				List<Integer> l = list.get(i - 1);
				List<Integer> newList = new ArrayList<>();
				list.add(new ArrayList<>());
				for (int j = 0; j <= i; j++) {
					if (j == 0 || j == i) {
						newList.add(1);
					} else {
						newList.add(j, l.get(j - 1) + l.get(j));
					}
				}
				list.set(i, newList);

			}

		}
		// System.out.println(list.toString());
		return list;

	}

	public static void main(String[] args) {
		int n = 30;
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			list.add(null);
		}
		list = pascalTriangle(list, n);
		for (int i = 0; i < list.size(); i++) {
			List<Integer> l = list.get(i);
			int space = 0;
			while(space<n-i-1) {
				System.out.print(" ");
				space++;
			}
			for (int j = 0; j < l.size(); j++) {

				System.out.print(l.get(j) + " ");
			}
			System.out.println();
		}
	}

}
