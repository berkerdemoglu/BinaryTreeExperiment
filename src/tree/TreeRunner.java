package tree;

public class TreeRunner {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(8));

		root.getLeft().setLeft(new TreeNode(1));
		root.getLeft().setRight(new TreeNode(10));

		root.getLeft().getLeft().setLeft(new TreeNode(11));
		root.getLeft().getLeft().setRight(new TreeNode(3));

		System.out.println("root = " + root);

		root.goDownLeft();
		System.out.println(root.searchData(5));
	}
}
