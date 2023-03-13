package stack.problem;

import java.util.Stack;

public class CelebrityProblem {

	static void findCelebrity(int[][] arr) {
		Stack<Integer> st = new Stack<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			st.push(i);
		}
		while (st.size() >= 2) {
			int i = st.pop();
			int j = st.pop();
			if (arr[i][j] == 1) {
				// if i knows j then i is not celebrity
				st.push(j);
			} else {
				st.push(i);
			}
		}
		int pot = st.pop();
		for (int i = 0; i < n; i++) {
			if (i != pot && (arr[i][pot] == 0 || arr[pot][i] == 1)) {
				System.out.println("Noone");
				return;
			}
		}
		System.out.println(pot);
	}

	public static void main(String[] args) {
		int[][] arr = { {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0} };
		findCelebrity(arr);
	}

}
