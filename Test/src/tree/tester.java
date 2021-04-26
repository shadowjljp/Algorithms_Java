package tree;
 class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
public class Tester {


	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return null;
		}
		if (root1 == null) {
			return root2;
		}
		if (root2 == null) {
			return root1;
		}
		TreeNode root3 = new TreeNode(root1.val + root2.val);
		root3.left = mergeTrees(root1.left, root2.left);
		root3.right = mergeTrees(root1.right, root2.right);
		return root3;
	}

//	public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
//		if (root1 == null && root2 == null) {
//			return null;
//		}
//		TreeNode root3 = new TreeNode(root1.val + root2.val);
//		TreeNode node = root3;
//		helper(root1.left, root2.left, node.left);
//		helper(root1.right, root2.right, node.right);
//		return root3;
//	}
//
//	public void helper(TreeNode node1, TreeNode node2, TreeNode node3) {
//		if (node1 != null && node2 != null) {
//			node3 = new TreeNode(node1.val + node2.val);
//		} else if (node1 != null) {
//			node3 = new TreeNode(node1.val);
//		} else if (node2 != null) {
//			node3 = new TreeNode(node2.val);
//		}
//	}

	public static void main(String[] args) {
		Tester t = new Tester();
//		[1,3,2,5]
//				[2,1,3,null,4,null,7]
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.left.left = new TreeNode(5);
		root1.right = new TreeNode(2);
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(3);
		root2.left.right = new TreeNode(4);
		root2.right.right = new TreeNode(7);
		t.mergeTrees(root1, root2);
		// System.out.println("Test");

	}

}
