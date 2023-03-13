package linkedlist1;

import java.util.LinkedList;

public class Exercise {

	public static void main(String[] args) {
		LinkedListNode<Integer> head = null;
		LinkedListImpl l = new LinkedListImpl();
		for (int i = 1; i <= 5; i++) {
			head = l.addAtLast(head, i);
		}
		l.print(head);
		// head = l.removeNthFromEnd(head, 1);
		System.out.println("=====================================");

//		head = l.reverse(head);
//		l.print(head);
//		LinkedListNode<Integer> middle = l.middle(head);
//		System.out.println("===================middle data===============");
//		System.out.println(middle.getData());
		// l.print(head);
//		System.out.println("===================mergeTwoList data===============");
//		LinkedListNode<Integer> head1 = null;
//		for (int i = 6; i <= 10; i++) {
//			head1 = l.addAtLast(head1, i);
//		}
//		l.print(head1);
		System.out.println("================================");
//		head1 = l.mergeTwoList(head, head1);
//		l.print(head1);
//		LinkedListNode<Integer> addTwoNumbers = l.addTwoNumbers(head, head1);
//		l.print(addTwoNumbers);
		//head = l.reverseKGroup(head, 3);
		System.out.println(l.isPalindrome(head));
		l.print(head);
	}

}
