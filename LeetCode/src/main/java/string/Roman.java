package string;

public class Roman {
	
	 //Definition for singly-linked list.
	 public class ListNode {
	     int val;
	      ListNode next;
	     ListNode(int x) { val = x; }
	  }
	 	ListNode head;
	 	ListNode tail;
	 	ListNode temp1;
	 	ListNode temp2;
	    ListNode l3 ;
	    int size = 0;
	    
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	   
	    	 head=l1;
    		 l3 = head;
    		 tail = head;
    		 //set pointer for both ListNode
    		 temp1=l1;
	    	 temp2 = l2;
	             while(l1 !=null && l2 !=null) {
	            	 
	            	 add(temp1.val);
	            	 if(temp1.next !=null)
	            	 temp1 = temp1.next;
	            	 
	            	 add(l2.val);
	            	 if(temp2.next !=null)
		            	 temp2 = temp2.next;
	            	/* 	//store l2
	            		 tail.next = temp2;
	            		 temp2= temp2.next;
	            		 tail = tail.next;
	            		 //store l1
	            		 tail.next = temp1;
	            		 temp1 = temp1.next;
	            		 tail = tail.next;*/
	            		size++;
	             }
	        // }
	        return head;
	    }
	    public void add(int i) {
	    	if(head ==null) {
	    		head = new ListNode(i);
	    		tail =head;
	    	}else {
	    		tail.next =new ListNode(i);
	    		tail = tail.next;
	    	}
	    	size++;
	    	
	    }
	    public static void main(String[] args) {
	    	
	    }

}
