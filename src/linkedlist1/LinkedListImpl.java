package linkedlist1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class LinkedListImpl.
 *
 * @author omkumar
 */

public class LinkedListImpl {

	/**
	 * Adds the at start.
	 *
	 * @param head the head
	 * @param data the data
	 * @return the linked list node
	 */
	LinkedListNode<Integer> addAtStart(LinkedListNode<Integer> head, int data) {
		LinkedListNode<Integer> node = new LinkedListNode<>(data);
		if (head == null) {
			return node;
		}
		node.next = head;
		head = node;
		return head;
	}

	/**
	 * Removes the.
	 *
	 * @param head the head
	 * @param data the data
	 */
	void remove(LinkedListNode<Integer> head, int data) {

	}

	/**
	 * Adds the at last.
	 *
	 * @param head the head
	 * @param data the data
	 * @return the linked list node
	 */
	LinkedListNode<Integer> addAtLast(LinkedListNode<Integer> head, int data) {
		LinkedListNode<Integer> node = new LinkedListNode<>(data);
		LinkedListNode<Integer> temp = head;
		if (temp == null) {
			return node;
		}
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		return head;
	}

	/**
	 * Prints the.
	 *
	 * @param head the head
	 */
	void print(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> temp = head;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.next;
		}
	}

	/**
	 * Reverse.
	 *
	 * @param head the head
	 * @return the linked list node
	 */
	LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> prev, curr, fwd;
		prev = null;
		curr = head;
		fwd = head;
		while (curr != null) {
			fwd = curr.next;
			curr.next = prev;
			prev = curr;
			curr = fwd;
		}
		return prev;
	}

	/**
	 * Middle.
	 *
	 * @param head the head
	 * @return the linked list node
	 */
	LinkedListNode<Integer> middle(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> slow = head;
		LinkedListNode<Integer> fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	/**
	 * Merge two list.
	 *
	 * @param list1 the list 1
	 * @param list2 the list 2
	 * @return the linked list node
	 */
	LinkedListNode<Integer> mergeTwoList(LinkedListNode<Integer> list1, LinkedListNode<Integer> list2) {
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}
		while (list1 != null && list2 != null) {
			if (list1.getData() < list2.getData()) {
				if (head == null) {
					head = list1;
					tail = list1;
					list1 = list1.next;
				} else {
					tail.next = list1;
					tail = list1;
					list1 = list1.next;
				}
			} else {
				if (head == null) {
					head = list2;
					tail = list2;
					list2 = list2.next;
				} else {
					tail.next = list2;
					tail = list2;
					list2 = list2.next;
				}
			}
		}
		while (list1 != null) {
			tail.next = list1;
			tail = list1;
			list1 = list1.next;
		}
		while (list2 != null) {
			tail.next = list2;
			tail = list2;
			list2 = list2.next;
		}
		return head;
	}

	/**
	 * Removes the nth from end.
	 *
	 * @param head the head
	 * @param n    the n
	 * @return the linked list node
	 */
	LinkedListNode<Integer> removeNthFromEnd(LinkedListNode<Integer> head, int n) {
		if (head == null) {
			return head;
		}
		LinkedListNode<Integer> temp = new LinkedListNode<>();
		temp.next = head;
		LinkedListNode<Integer> slow = temp;
		LinkedListNode<Integer> fast = temp;
		int i = 0;
		while (i < n) {
			fast = fast.next;
			i++;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return temp.next;
	}

	/**
	 * Adds the two numbers.
	 *
	 * @param l1 the l 1
	 * @param l2 the l 2
	 * @return the linked list node
	 */
	public LinkedListNode<Integer> addTwoNumbers(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
		int rem = 0;
		LinkedListNode<Integer> head1 = new LinkedListNode<>();
		LinkedListNode<Integer> temp = head1;
		while (l1 != null && l2 != null) {
			int data = l1.getData() + l2.getData() + rem;
			l1 = l1.next;
			l2 = l2.next;
			int n = data % 10;
			LinkedListNode<Integer> node = new LinkedListNode<>(n);
			temp.next = node;
			temp = node;
			rem = data / 10;
		}
		while (l1 != null) {
			int data = l1.getData() + rem;
			l1 = l1.next;
			int n = data % 10;
			LinkedListNode<Integer> node = new LinkedListNode<>(n);
			temp.next = node;
			temp = node;
			rem = data / 10;
		}
		while (l2 != null) {
			int data = l2.getData() + rem;
			l2 = l2.next;
			int n = data % 10;
			LinkedListNode<Integer> node = new LinkedListNode<>(n);
			temp.next = node;
			temp = node;
			rem = data / 10;
		}
		if (rem != 0) {
			LinkedListNode<Integer> node = new LinkedListNode<>(rem);
			temp.next = node;
			temp = node;
		}
		return head1.next;
	}

	/**
	 * Gets the intersection node.
	 *
	 * @param headA the head A
	 * @param headB the head B
	 * @return the intersection node
	 */
	LinkedListNode<Integer> getIntersectionNode(LinkedListNode<Integer> headA, LinkedListNode<Integer> headB) {
		while (headB != null) {
			LinkedListNode<Integer> temp1 = headA;
			while (temp1 != null) {
				if (temp1 == headB) {
					return temp1;
				}
				temp1 = temp1.next;
			}
			headB = headB.next;
		}
		return null;
	}

	/**
	 * Gets the intersection node optimize.
	 *
	 * @param headA the head A
	 * @param headB the head B
	 * @return the intersection node optimize
	 */
	LinkedListNode<Integer> getIntersectionNodeOptimize(LinkedListNode<Integer> headA, LinkedListNode<Integer> headB) {
		Set<LinkedListNode<Integer>> set = new HashSet<>();
		while (headA != null) {
			set.add(headA);
			headA = headA.next;
		}
		while (headB != null) {
			if (set.contains(headB)) {
				return headB;
			}
			headB = headB.next;
		}
		return null;
	}

	/**
	 * Checks for cycle.
	 *
	 * @param head the head
	 * @return true, if successful
	 */
	boolean hasCycle(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> slow = head;
		LinkedListNode<Integer> fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the length.
	 *
	 * @param head the head
	 * @return the length
	 */
	int getLength(LinkedListNode<Integer> head) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
	}

	/**
	 * Reverse K group.
	 *
	 * @param head the head
	 * @param k    the k
	 * @return the linked list node
	 */
	public LinkedListNode<Integer> reverseKGroup(LinkedListNode<Integer> head, int k) {
		LinkedListNode<Integer> dummyHead = new LinkedListNode<>();
		LinkedListNode<Integer> prev = dummyHead;
		LinkedListNode<Integer> curr, fwd;
		dummyHead.next = head;
		int len = getLength(head);
		while (len >= k) {
			curr = prev.next;
			fwd = curr.next;
			for (int i = 1; i < k; i++) {
				curr.next = fwd.next;
				fwd.next = prev.next;
				prev.next = fwd;
				fwd = curr.next;
			}
			prev = curr;
			len = len - k;
		}
		return dummyHead.next;
	}

	/**
	 * Checks if is palindrome.
	 *
	 * @param head the head
	 * @return true, if is palindrome
	 */
	public boolean isPalindrome(LinkedListNode<Integer> head) {
		StringBuilder input = new StringBuilder();
		while (head != null) {
			input = input.append(head.getData());
			head = head.next;
		}
		return checkPalindrome(input);
	}

	/**
	 * Check palindrome.
	 *
	 * @param input the input
	 * @return true, if successful
	 */
	private boolean checkPalindrome(StringBuilder input) {
		int i = 0;
		int j = input.length() - 1;
		while (i < j) {
			if (input.charAt(i) != input.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	/**
	 * Checks if is palindrome optimize.
	 *
	 * @param head the head
	 * @return true, if is palindrome optimize
	 */
	public boolean isPalindromeOptimize(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> slow = head;
		LinkedListNode<Integer> fast = head;
		LinkedListNode<Integer> dummyHead = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = reverse(slow.next);
		slow = slow.next;
		while (slow != null) {
			if (slow.getData() != dummyHead.getData()) {
				return false;
			}
			slow = slow.next;
			dummyHead = dummyHead.next;
		}
		return true;
	}

	/**
	 * Detect cycle.
	 *
	 * @param head the head
	 * @return the linked list node
	 */
	LinkedListNode<Integer> detectCycle(LinkedListNode<Integer> head) {
		Set<LinkedListNode<Integer>> set = new HashSet<>();
		if (head == null) {
			return head;
		}
		while (head != null) {
			set.add(head);
			if (set.contains(head)) {
				return head;
			}
			head = head.next;
		}
		return null;
	}

	/**
	 * Detect cycle optimize.
	 *
	 * @param head the head
	 * @return the linked list node
	 */
	LinkedListNode<Integer> detectCycleOptimize(LinkedListNode<Integer> head) {
		if (head == null) {
			return head;
		}
		LinkedListNode<Integer> slow = head;
		LinkedListNode<Integer> fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				fast = head;
				while (fast != slow) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}

	/**
	 * Flatten.
	 *
	 * @param root the root
	 * @return the node next and bottom
	 */
	NodeNextAndBottom flatten(NodeNextAndBottom root) {
		NodeNextAndBottom head = null;
		NodeNextAndBottom tail = null;
		NodeNextAndBottom temp1 = root;
		while (temp1 != null) {
			if (head == null) {
				head = temp1;
				tail = temp1;
			} else {
				tail.next = temp1;
				tail = tail.next;
			}
		}
		temp1 = head;
		NodeNextAndBottom temp2 = root.next;
		NodeNextAndBottom temp3 = null;
		NodeNextAndBottom temp4 = null;
		while (temp2 != null) {
			temp3 = temp1;
			temp4 = temp2;
			while (temp3 != null && temp4 != null) {
				if (temp3.data < temp4.data) {
					if (head == null) {
						head = temp3;
						tail = temp3;
					} else {
						tail.next = temp3;
						tail = tail.next;
					}
					temp3 = temp3.next;
				} else {
					if (head == null) {
						head = temp4;
						tail = temp4;
					} else {
						tail.next = temp4;
						tail = tail.next;
					}
					temp4 = temp4.bottom;
				}
			}
			while (temp3 != null) {
				tail.next = temp3;
				tail = tail.next;
				temp3 = temp3.next;
			}
			while (temp4 != null) {
				tail.next = temp4;
				tail = tail.next;
				temp4 = temp4.bottom;
			}
			temp2 = temp2.next;
			temp1 = head;
		}
		return head;
	}

	/**
	 * Flatten optimize.
	 *
	 * @param root the root
	 * @return the node next and bottom
	 */
	NodeNextAndBottom flattenOptimize(NodeNextAndBottom root) {
		if (root == null || root.next == null) {
			return root;
		}
		root.next = flattenOptimize(root.next);
		root = mergeList(root, root.next);
		return root;
	}

	/**
	 * Merge list.
	 *
	 * @param prev the prev
	 * @param next the next
	 * @return the node next and bottom
	 */
	private NodeNextAndBottom mergeList(NodeNextAndBottom prev, NodeNextAndBottom next) {
		NodeNextAndBottom head = null;
		NodeNextAndBottom tail = null;
		while (prev != null && next != null) {
			if (prev.data < next.data) {
				if (head == null) {
					head = prev;
					tail = prev;
				} else {
					tail.bottom = prev;
					tail = tail.bottom;
				}
				prev = prev.bottom;
			} else {
				if (head == null) {
					head = next;
					tail = next;
				} else {
					tail.bottom = next;
					tail = tail.bottom;
				}
				next = next.bottom;
			}
		}
		if (prev != null) {
			tail.bottom = prev;
		}
		if (next != null) {
			tail.bottom = next;
		}
		return head;
	}

	/**
	 * Rotate by K.
	 *
	 * @param head is the starting pointer
	 * @param k    is the number by which we have to rotate
	 * @return return the first pointer
	 */
	LinkedListNode<Integer> rotateByK(LinkedListNode<Integer> head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}
		LinkedListNode<Integer> slow = head;
		LinkedListNode<Integer> fast = head;
		int n = getLength(head);
		if (k > n) {
			k = k % n;
		}
		if (k == n || k == 0) {
			return head;
		}
		int i = 0;
		while (fast != null && i < k) {
			fast = fast.next;
			i++;
		}
		while (fast != null && fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		LinkedListNode<Integer> temp = slow.next;
		slow.next = null;
		fast.next = head;
		return temp;
	}

	/**
	 * Copy random list.
	 *
	 * @param head the head
	 * @return the node next and bottom
	 */
	public NodeNextAndBottom copyRandomList(NodeNextAndBottom head) {
		if (head == null) {
			return null;
		}
		NodeNextAndBottom nhead = new NodeNextAndBottom(head.data);
		Map<NodeNextAndBottom, NodeNextAndBottom> nodeMap = new HashMap<>();
		NodeNextAndBottom temp = head;
		nodeMap.put(head, nhead);
		while (temp.next != null) {
			nhead.next = new NodeNextAndBottom(temp.next.data);
			nhead = nhead.next;
			temp = temp.next;
			nodeMap.put(temp, nhead);
		}
		temp = head;
		while (temp != null) {
			nodeMap.get(temp).bottom = nodeMap.get(temp.bottom);
			temp = temp.next;
		}
		return nodeMap.get(head);
	}

	/**
	 * Copy random list optimize.
	 *
	 * @param head the head
	 * @return the node next and bottom(Please consider bottom pointer as random
	 *         pointer)
	 */
	public NodeNextAndBottom copyRandomListOptimize(NodeNextAndBottom head) {
		if (head == null) {
			return null;
		}
		NodeNextAndBottom curr = head;
		NodeNextAndBottom temp = null;
		// adding same node in b/w two node
		while (curr != null) {
			temp = curr.next;
			curr.next = new NodeNextAndBottom(temp.data);
			curr.next.next = temp;
			curr = temp;
		}
		curr = head;
		// setting the next pointer ie here bottom
		while (curr != null) {
			if (curr.next != null) {
				curr.next.bottom = (curr.bottom != null) ? curr.bottom.next : curr.bottom;
			}
			curr = curr.next.next;
		}
		// restoring original
		// we are breaking the links while traversing.
		NodeNextAndBottom originalHead = head;
		NodeNextAndBottom copyHead = head.next;
		temp = copyHead;
		while (originalHead != null) {
			originalHead.next = originalHead.next.next;
			copyHead.next = (copyHead.next != null) ? copyHead.next.next : copyHead.next;
			originalHead = originalHead.next;
			copyHead = copyHead.next;
		}
		return temp;
	}

}
