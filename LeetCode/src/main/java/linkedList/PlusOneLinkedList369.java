package linkedList;

import java.util.Stack;
class ListNode {
    int val;
   ListNode next;
   ListNode(int x) { val = x; }
}
public class PlusOneLinkedList369 {
	public ListNode plusOne(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		ListNode cur = head;
		while(cur !=null) {
			stack.push(cur);
			cur= cur.next;
		}
		ListNode node = stack.pop();
		int carry  = (node.val+1)/10;
		node.val = (node.val+1)%10;
		while(carry !=0 && !stack.isEmpty()) {
			node = stack.pop();
			carry = (carry+node.val)/10;
			node.val = (node.val+carry)%10;
		}
		return head;
		
	}
	public static void main(String[] args) {
		PlusOneLinkedList369 re = new PlusOneLinkedList369();
		ListNode head = new ListNode(1);
		ListNode cur = head;
		cur.next = new ListNode(2);
		cur.next.next = new ListNode(3);
		ListNode result = re.plusOne(head);
		while(result !=null) {
			System.out.println(result.val);
			result = result.next;
		}
		
	}

}
