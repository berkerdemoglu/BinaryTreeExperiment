package tree;

public class TreeNode {
	private TreeNode left;
	private TreeNode right;
	private int data;

	public TreeNode(int data) {
		this.data = data;
	}

	public TreeNode(TreeNode left, int data, TreeNode right) {
		this.left = left;
		this.data = data;
		this.right = right;
	}

	public boolean searchData(int data) {
		// Searches for a specific data and returns true if it is in the tree.
		return this.data == data || searchLeftNode(data) || searchRightNode(data);
	}

	public boolean searchLeftNode(int data) {
		if (left != null) { // if node has left child
			if (left.getData() == data) {
				return true;
			} else {
				return left.searchLeftNode(data) || left.searchRightNode(data);
			}
		} else { // if no left, check if the current node has the value
			return this.data == data;
		}
	}

	public boolean searchRightNode(int data) {
		if (right != null) {
			if (right.getData() == data) {
				return true;
			} else {
				return right.searchLeftNode(data) || right.searchRightNode(data);
			}
		} else {
			return this.data == data;
		}
	}

	public void goDownLeft() {
		if (left != null && left.getLeft() != null) { // if node has a left child and it has a left child
			left.goDownLeft();
		} else {
			System.out.println(left);
		}
	}

	public void goDownRight() {
		if (right != null && right.getRight() != null) { // if node has a right child and it has a right child
			System.out.println();
		} else {
			System.out.println(right);
		}
	}

	public String toString() {
		String leftStr = (left == null ? "-" : left.toString());
		String rightStr = (right == null ? "-" : right.toString());

		return "{" + leftStr + ", " + data + ", " + rightStr + "}";
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
