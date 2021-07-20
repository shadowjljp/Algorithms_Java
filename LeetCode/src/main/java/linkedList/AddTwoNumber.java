package linkedList;

public class AddTwoNumber {
	
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int More=0;
		ListNode FirstLink =l1;
		ListNode SecondLink =l2;
		ListNode ThirdLink = new ListNode(0);
		ListNode result=ThirdLink;
		while(FirstLink !=null || SecondLink !=null) {
			int x =(FirstLink !=null)?FirstLink.val:0;
			int y =(SecondLink !=null)?SecondLink.val:0;
			int sum = x+y+More;
			More = sum/10;
			result.next=new ListNode(sum%10);
			result = result.next;
			if(l1.next != null) {
				FirstLink =FirstLink.next;
			}
			if(l2.next !=null) {
				SecondLink =SecondLink.next;	
			}
			
		
		}
		if(More >0) {
			 result.next = new ListNode(More);
		}
		 return ThirdLink.next;
	        
	    }

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next=new ListNode(4);
		l1.next.next=new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next=new ListNode(6);
		l2.next.next=new ListNode(4);
		ListNode result = addTwoNumbers(l1,l2);
		while(result !=null) {
			System.out.print(result.val); 
			result = result.next;
		}
		// TODO Auto-generated method stub

	}

}
