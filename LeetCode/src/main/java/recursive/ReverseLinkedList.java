package recursive;

public class ReverseLinkedList {
	
	  public ListNode reverseList(ListNode head) {
	        return helper(head,null);
	    }
	    public ListNode helper(ListNode head,ListNode newHead){
	        if(head ==null) return newHead;
	        ListNode next = head.next;
	        head.next = newHead;
	        ListNode res = helper(next,head);
	        return res;
	    }
	    public void printList(ListNode head) {
	    	while( head!=null) {
	    		System.out.println(head.val);
	    		head = head.next;
	    	}
	    }
	public static void main(String[] args) {
		ReverseLinkedList re = new ReverseLinkedList();
		ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
		ListNode res = re.reverseList(head);
		re.printList(res);
		
	  }
}
  class ListNode {
	      int val;
	      ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }