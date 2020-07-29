package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class InOrder_PostOrder_Construct_Tree {
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
	    if (inorder.length == 0 || postorder.length == 0) return null;
	    int ip = inorder.length - 1;
	    int pp = postorder.length - 1;
	    
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode prev = null;
	    TreeNode root = new TreeNode(postorder[pp]);
	    stack.push(root);
	    pp--;
	    
	    while (pp >= 0) {
	        while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
	            prev = stack.pop();
	            ip--;
	        }
	        TreeNode newNode = new TreeNode(postorder[pp]);
	        if (prev != null) {
	            prev.left = newNode;
	        } else if (!stack.isEmpty()) {
	            TreeNode currTop = stack.peek();
	            currTop.right = newNode;
	        }
	        stack.push(newNode);
	        prev = null;
	        pp--;
	    }
	    
	    return root;
	}
	 public TreeNode buildTreeRecursion(int[] inorder, int[] postorder) {
	        if (inorder == null || postorder == null || inorder.length != postorder.length)
			return null;
	        Map<Integer,Integer> map = new HashMap<>();
	        for(int i=0;i<inorder.length;i++){
	            map.put(inorder[i],i);
	        }
	        return helper(0,inorder.length-1,postorder,0,postorder.length-1,map);
	        
	    }
	    public TreeNode helper(int is,int ei,int[] postorder,int sp,int ep,Map<Integer,Integer> map){
	        if(is>ei || sp>ep) return null;
	        TreeNode root = new TreeNode(postorder[ep]);
	        int ri = map.get(postorder[ep]);
	        TreeNode left=  helper(is,ri-1,postorder,sp,sp+ri-is-1,map);
	        TreeNode right = helper(ri+1,ei,postorder,sp+ri-is,ep-1,map);
	        root.left = left;
	        root.right =right;
	        
	        return root;
	        
	    }
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> res=  new ArrayList<List<Integer>>();
	        if(root==null) return res;
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	       
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            List<Integer>  list = new ArrayList<>();
	            while(size>0){
	                TreeNode cur=  queue.poll();
	                if(cur.left !=null){
	                    queue.offer(cur.left);
	                }
	                if(cur.right !=null){
	                    queue.offer(cur.right);
	                }
	                list.add(cur.val);
	                size--;
	            }
	              res.add(list);
	        }
	        return res;
	    }
	public static void main(String[] args) {
		InOrder_PostOrder_Construct_Tree re = new InOrder_PostOrder_Construct_Tree();
		int[] inorder= {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		//re.buildTree(inorder,postorder);
	//	re.buildTreeRecursion(inorder, postorder);
		
		///
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(11);
		
		re.levelOrder(root);
		
	}

}
