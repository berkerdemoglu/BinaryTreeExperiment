package tree;

public class TreeNode {
	private static String nodeLocation = "";

	private TreeNode left;
	private TreeNode right;
	private int data;

	public TreeNode(int data) {
		this.data = data;
	}

	public TreeNode(TreeNode left, int data, TreeNode right) {
		this(data);
		this.left = left;
		this.right = right;
	}

	public boolean searchData(int data) {
		// Searches for a specific data and returns true if it is in the tree.
		if (this.data == data) {
			System.out.println("This node contains the data you're looking for.");
			return true;
		} else if (searchLeftNode(data)) {
			nodeLocation = "0" + nodeLocation;
			System.out.println("nodeLocation = " + nodeLocation);
			return true;
		} else if (searchRightNode(data)) {
			nodeLocation = "1" + nodeLocation;
			System.out.println("nodeLocation = " + nodeLocation);
			return true;
		} else {
			return false;
		}
	}

	public boolean searchLeftNode(int data) {
		if (left != null) { // if node has left child
			if (left.getData() == data) { // if left child contains the data
				return true;
			} else {
				if (left.searchLeftNode(data)) {
					nodeLocation += "0";
					return true;
				} else if (left.searchRightNode(data)) {
					nodeLocation += "1";
					return true;
				} else {
					return false;
				}
			}
		} else { // if no left, check if the current node has the value
			if (this.data == data) {
				nodeLocation += "0";
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean searchRightNode(int data) {
		if (right != null) {
			if (right.getData() == data) {
				return true;
			} else {
				if (right.searchLeftNode(data)) {
					nodeLocation += "0";
					return true;
				} else if (right.searchRightNode(data)) {
					nodeLocation += "1";
					return true;
				} else {
					return false;
				}
			}
		} else {
			if (this.data == data) {
				nodeLocation += "1";
				return true;
			} else {
				return false;
			}
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
