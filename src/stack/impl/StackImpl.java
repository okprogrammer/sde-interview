package stack.impl;

public class StackImpl {

	public static void main(String[] args) {
		StackUsingArray st = new StackUsingArray(13);
		for (int i = 0; i < 100; i++) {
			try {
				st.add(i+1);
			} catch (StackUnderFlowException e) {
				System.out.println(e.getMessage());
			}
		}
		for (int i = 0; i < 100; i++) {
			int data = st.pop();
			System.out.println("Pop up data "+(data != -1?data:"Stack is empty!"));
		}
		
	}

}
