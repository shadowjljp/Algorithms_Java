package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class Populating_Next_Right_Pointers {

	    public void connect(Node root) {
	    	 Node dummyHead = new Node(0);
	    	    Node pre = dummyHead;
	    	    while (root != null) {
	    		    if (root.left != null) {
	    			    pre.next = root.left;
	    			    pre = pre.next;
	    		    }
	    		    if (root.right != null) {
	    			    pre.next = root.right;
	    			    pre = pre.next;
	    		    }
	    		    root = root.next;
	    		    if (root == null) {
	    			    pre = dummyHead;
	    			    root = dummyHead.next;
	    			    dummyHead.next = null;
	    		    }
	    	    }
	    }
	    
	    public String serialize(Node root) {
	        return serial(new StringBuilder(), root).toString();
	    }
	    
	    // Generate preorder string
	    private StringBuilder serial(StringBuilder str, Node root) {
	        if (root == null) return str.append("#");
	        str.append(root.val).append(",");
	        serial(str, root.left).append(",");
	        serial(str, root.right);
	        return str;
	    }

	    public Node deserialize(String data) {
	        return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
	    }
	    
	    // Use queue to simplify position move
	    private Node deserial(Queue<String> q) {
	        String val = q.poll();
	        if ("#".equals(val)) return null;
	        Node root = new Node(Integer.valueOf(val));
	        root.left = deserial(q);
	        root.right = deserial(q);
	        return root;
	    }
	public static void main(String[] args) {
		Populating_Next_Right_Pointers re = new Populating_Next_Right_Pointers();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.right = new Node(5);
		root.right.left =new Node(4);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
//		root.right.right = new Node(7);
//		re.connect(root);
		System.out.println(re.serialize(root));
	}

}
