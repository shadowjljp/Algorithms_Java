package dataStructure;

import java.util.NoSuchElementException;

public class LinkList {
	private static class Node{
		int data;
		Node next;
			
		Node(int d,Node n){
			data =d;
			next=n;
			
		}
	}
	
	int size;
	private Node head;
	private Node tail;
		public void addFront(int d) {
				if(head==null) {
					head = new Node(d,null);
					tail = head;
				}else {
					head = new Node(d,head);
					
				}
				size++;
		}
		public void addBack(int d) {
			if(head==null) {
				head = new Node(d,null);
				tail = head;
			}else {
				tail.next = new Node(d,null);
				 tail = tail.next;
			}
			 
			size++;	
		}
		
		public int removeFront() {
			int olddata;
			
			if(head == null) {
				throw new NoSuchElementException();
				
			}else if(head==tail) {
				olddata=head.data;
				head=tail=null;
			}else {
				olddata = head.data;
				head = head.next;
			}
			size--;
			return olddata;
			
			
			
		}
		
		public int removeBack() {
			Node temp = head;
			int olddata;
			if(tail==null) {
				throw new NoSuchElementException();
				
			}else if(head==tail) {
				olddata=tail.data;
				head=tail=null;
			}else {
				while(temp.next != tail) {
					temp = temp.next;
				}
				tail =temp;
				temp.next = null;
				olddata=tail.data;
				
			}
			size--;
			return olddata;
		}
		
		public int get(int i) { //out of the range or in range
			if(i<0||i>size-1) {
				throw new ArrayIndexOutOfBoundsException("Index"+i+"size"+size);
			}else {
				Node p =head;
				for(int k=0;k<i;k++) {
					p = p.next;
					
				}
				return p.data;
			}
		}
		 public void reverse()
		    {
		       if (head == null || head == tail) // 0 or 1 nodes
		           return;

		       Node p1 = null;
		       Node p2 = head;
		       Node p3 = head.next;

		       while (p3 != null)
		       {
		          p2.next = p1;
		          p1 = p2;
		          p2 = p3;
		          p3 = p3.next;
		       }
		       p2.next = p1;

		       Node temp = head;
		       head = tail;
		       tail = temp;

		    }
		
			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder("[");
				Node p =head;
				while(p != null) {
					sb.append(p.data+" ");
					p=p.next;
				}
				sb.append("]");
				
				return new String(sb);
				
			}
			
			Node dummy = new Node(-1,null);
	        Node p =dummy;
	        int sum =0;
	    public Node addTwoNumbers(Node l1, Node l2) {
	    
	    	while(l1 !=null || l2 !=null){
	            sum /=10;
	            if(l1 !=null){
	                sum+=l1.data;
	                
	            }
	            if(l2 !=null){
	                sum+= l2.data;                
	            }
	            p.next = new Node(sum%10,null);
	            p = p.next;
	            
	                l1 = l1.next==null ? null : l1.next;
	                l2 = l2.next==null ? null : l2.next;
	        }
	        if(sum != 0){
	            p.next = new Node(sum/10,null);
	        }
	        
	        
	      
	    return dummy.next;
	    }
	    
	    public Node flatten(Node head) {
	    	flattentail(head);
	    	return head;
	    }
	    private Node flattentail(Node head) {
	    	if (head == null) return head; // CASE 1
	    		if (head.next == null) return head; // CASE 2
	    		return flattentail(head.next); // CASE 3
	    	
	    }
	    static int printFun(int test) 
	    { 
	        if (test < 1) 
	            return 6; 
	  
	        else { 
	            System.out.printf("%d ", test); 
	  
	            // Statement 2 
	            int r =printFun(test - 1); 
	            System.out.println("r= "+r);
	            System.out.printf("%d ", test); 
	            return 5; 
	        } 
	        }
	public static void main(String[] args) {
		LinkList list = new LinkList();
		LinkList list2 = new LinkList();
		
		/*for(int i = 0;i<5;i++) {
			list.addBack(i);
		}
		System.out.println(list);
		
		for(int i=0;i<5;i++) {
			list.addFront(i);
		}
		System.out.println(list);
		
		list.reverse();
		System.out.println(list);
		
		int f = list.removeFront();
		int b =list.removeBack();
		System.out.println(list);*/
		list.addBack(1);
		list2.addBack(1);
		list2.addBack(2);
		list2.addBack(3);
		list2.addBack(4);/*
	list.addTwoNumbers(list.head,list2.head);
				while(list.dummy.next !=null) {
					list.dummy = list.dummy.next;
System.out.println(list.dummy.data);	
				}*/
		//list.printFun(3);
	}
	}		

