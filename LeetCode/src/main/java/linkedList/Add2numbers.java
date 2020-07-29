package linkedList;

public class Add2numbers {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode root=null;
	        ListNode cur=root;
	        int carry=0;
	        int sum=0;
	        while(l1!=null && l2!=null){
	            sum = l1.val+l2.val+carry;
	            carry=sum/10;
	            if(root==null){
	                root =new ListNode(sum%10);
	                cur= root;
	            }else{
	                cur.next = new ListNode(sum%10);
	                cur=cur.next;
	            }
	            l1=l1.next;
	            l2 =l2.next;
	        }
	        while(l1!=null){
	            sum = (l1.val+carry);
	            carry=sum/10;
	            cur.next = new ListNode(sum%10);
	            cur=cur.next;
	            l1=l1.next;
	        }
	        while(l2!=null){
	            sum = (l2.val+carry);
	            carry=sum/10;
	            cur.next = new ListNode(sum%10);
	            cur=cur.next;
	            l2=l2.next;
	        }
	        if(carry !=0){
	            cur.next = new ListNode(carry);
	        }
	      return root;
	        
	    }
	public static void main(String[] args) {
		Add2numbers re = new Add2numbers();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		re.addTwoNumbers(l1, l2);
	}

}
