package dataStructure;

public class LinkList_practice {
	  int size=0;
	     Node head;
	    Node tail;
	    /** Initialize your data structure here. */
	    public LinkList_practice(){
	        
	    }
	  
	    private static class Node{
	          int val;
	            Node next;
	       
	        public Node(int val,Node next){
	         this.val = val;
	            this.next = next;
	        
	        }
	    }
	    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	    public int get(int index) {
	        if(index>=size) return -1;
	        Node pointer = head;
	        while(index>0){
	            index--;
	            pointer = pointer.next;
	        }
	        return pointer.val;
	        
	    }
	    
	    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	    public void addAtHead(int val) {
	        if(head==null) {
	            head = new Node(val,null);
	             size++;
	        }else{
	            Node newNode =  new Node(val,head);
	        head = newNode;
	        size++;
	        }
	        
	       
	    }
	    
	    /** Append a node of value val to the last element of the linked list. */
	    public void addAtTail(int val) {
	        if(head==null) {
	            head = new Node(val,null);
	             size++;
	        }
	        
	       Node newNode = new Node(val,null);
	        Node cur= head;
	        while(cur.next!=null){
	            cur=  cur.next;
	        }
	        cur.next = newNode;
	        size++;
	    }
	    
	    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	    public void addAtIndex(int index, int val) {
	        if(index == size-1){
	            addAtTail(val);
	        }else if(index==0){
	            addAtHead(val);
	        }else if(index < size-1){
	            Node pointer = head;
	            while(index-1>0){
	                pointer = pointer.next;
	                index--;
	            }
	            Node newNode = new Node(val,pointer.next);
	            pointer.next = newNode;
	            size++;
	        }
	    }
	    
	    /** Delete the index-th node in the linked list, if the index is valid. */
	    public void deleteAtIndex(int index) {
	        if(index==0){
	            head = head.next;
	            size--;
	        }else if(index <size){
	            size--;
	             Node pointer = head;
	            while(index-1>0){
	                pointer = pointer.next;
	                index--;
	            }
	            if(pointer.next !=null){
	                 pointer.next = (pointer.next).next;
	           
	            }else{
	                pointer.next = null;
	            }
	           
	        }
	        
	    }
	    public boolean hasCycle(Node head) {
	        if(head==null || head.next == null) return false;
	        Node fast=head,slow=head;
	        while(fast.next !=null  ){
	                fast = fast.next.next;
	                slow = slow.next;
	                if(fast == slow){
	                    return true;
	            }
	        }
	        return false;
	    }
	    public Node reverseList(Node head) {
	        if(head==null || head.next==null) return null;
	        Node f =head.next;
	        Node s =head;
	        while(f !=null){
	            head.next = f.next;
	            f.next = s;
	            f= f.next;
	            s=s.next;
	        }
	        return s;
	    }
	    
	    public Node oddEvenList(Node head) {
	        if(head==null) return null;
	        Node odd = head;
	        Node even = head.next;
	        Node evenHead = even;
	        while(even !=null && even.next !=null){
	            odd.next = odd.next.next;
	           
	            even.next =even.next.next;
	             odd = odd.next;
	            even = even.next;
	            
	        }
	        odd.next = head.next;
	      
	        return head;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*["MyLinkedList","addAtHead","get","addAtHead","addAtHead","deleteAtIndex","addAtHead","get","get","get","addAtHead","deleteAtIndex"]
[[],[4],[1],[1],[5],[3],[7],[3],[3],[3],[1],[4]]*/
		LinkList_practice l = new LinkList_practice();
		//l.addAtHead(1);
Node head = new Node(1,null);
		l.addAtTail(3);
		l.addAtTail(4);
		l.addAtTail(5);
		System.out.println(l.oddEvenList(head));
		/*
		l.get(1);
		l.addAtHead(1);
		l.addAtHead(5);
		l.deleteAtIndex(3);
		l.addAtHead(7);
		l.get(3);
		l.get(3);
		l.get(3);
		l.addAtHead(1);
		l.deleteAtIndex(4);
		*/
	}

}
