package dataStructure;

public class MyLinkedList {
	private static class Node{
		int data;
		Node next;
		Node(int data,Node next){
			this.data =data;
			this.next = next;
		}
	}
	private Node head;
	private Node tail;
	int size;

	public void swap(int index1,int index2) {
		if (index1 == index2) return; 
		if(index1<0 || index2<0 ||index1>size-1 ||index2> size-1) {
			System.out.println("Index out of range");
			return;
		}
		Node left=head;
		Node preLeft=null;
		Node right = head;
		Node preRight=null;
		Node temp;
		//find the previous of left node and left node itself.
		while(left != null&&left.data != index1 ) {
			preLeft = left;
			left = left.next;
		}
		//find the previous of right node and right node itself.
		while(right !=null && right.data !=index2 ) {
			preRight =right;
			right = right.next;
		}
		if (left == null || right == null) 
            return; 
		
		//set the previous node from left
		if(preLeft !=null) {
			preLeft.next = right;
		}else {
			
			head=right ;
		}
		//set the previous node from right
		if(preRight !=null) {
			preRight.next = left;
		}else {
			head=left;
		}
		temp = left.next;
		left.next=right.next;
		right.next=temp;
		
	}
	public void shift(int k) {
		
		Node temp=null;
		if(k==0)
			return;
		if(k>0) {
			Node kthNode=head;
			while(k>1) {
				kthNode = kthNode.next;
				k--;
				
			}
			Node preNode=head;
			while(preNode.next != null) {
				preNode =preNode.next;
			}

			preNode.next= head;
			head = kthNode.next;
			tail = kthNode;
			tail.next=null;
		}else if(k<0) {
			while(k<0) {
				Node preNode=head;
				while(preNode.next != tail) {
					preNode =preNode.next;
				}

				tail.next = head;
				head =tail;
				tail = preNode;
				tail.next=null;
				k++;
			}
		}
	}
	public void erase(int index,int number) {
		if((index+number)>size) {
			System.out.println("out of range!");
			return;
		}
			Node guideStart=head;
			Node guideEnd = head;
			Node preGuideStart =head;
			int count =index;
			int total = index+number;
			
			while(count>1) {
				preGuideStart = preGuideStart.next;
				count--;
			}
			guideStart = preGuideStart.next;
			  count = total;
			while(count>1) {
				guideEnd = guideEnd.next;
				count--;
			}
			if(index==0) {
				head=guideEnd;
			}else if(total == size) {
				tail = preGuideStart;
				tail.next=null;
			}else {
				preGuideStart.next = guideEnd.next;
			}
			
		
	}
	public void add(int i) {
		if(head==null) {
			head=new Node(i,null);
			tail=head;
		}else {
			tail.next=new Node(i,null);
			 tail = tail.next;
		}
		size++;
	}
	public void printList() 
    { 
        Node tNode = head; 
        while (tNode != null) 
        { 
            System.out.print(tNode.data+" "); 
            tNode = tNode.next; 
        } 
    } 
	public void  insertList(MyLinkedList m2,int index) {
		int count =index;
		Node preGuideStart = head;
		Node temp;
		while(count>1) {
			preGuideStart = preGuideStart.next;
			count--;
		}
		temp=preGuideStart.next;
		preGuideStart.next = m2.head;
		m2.tail.next= temp;
	}
	
	public static void main(String[] args) {
		MyLinkedList ml = new MyLinkedList();
		ml.add(0);
		ml.add(1);
		ml.add(2);
		ml.add(3);
		ml.add(4);
		ml.add(5);
		System.out.println("Original linked list:");
		ml.printList();
		System.out.println("");
		System.out.println("Swap : ");
		ml.swap(2, 4);
		ml.printList();
		System.out.println("");
		
		System.out.println("Shift 2 : ");
		ml.shift(2);
		ml.printList();

		System.out.println("");
		System.out.println("Shift -1 : ");
		ml.shift(-1);
		ml.printList();
		System.out.println("");
		
		System.out.println("Original linked list:");
		ml.printList();
		System.out.println("erase : ");
		ml.erase(2, 2);
		ml.printList();
		System.out.println("");
		MyLinkedList m2 = new MyLinkedList();
		m2.add('a');
		m2.add(6);
		m2.add(7);
		m2.add(8);
		m2.add(9);
		m2.add('b');
		m2.printList();
		System.out.println("\ninsertList: ");
		ml.insertList(m2,2);
		ml.printList();

	}

}
