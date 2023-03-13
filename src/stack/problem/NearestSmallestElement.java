package stack.problem;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallestElement {

	public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
		Stack<Integer> st = new Stack<>();
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(-1);
		st.push(A.get(0));
		int size = A.size();
		for (int i = 1; i < size; i++) {
			while (!st.isEmpty() && A.get(i) <= st.peek()) {
				st.pop();
			}
			if (!st.isEmpty()) {
				ans.add(st.peek());
			} else {
				ans.add(-1);
			}
			st.push(A.get(i));
		}
		return ans;
	}

	public static void main(String[] args) {
		

	}

}
