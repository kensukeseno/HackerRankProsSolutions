package DataStructures.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//class Node {
//	Node left;
//	Node right;
//	int data;
//
//	Node(int data) {
//		this.data = data;
//		left = null;
//		right = null;
//	}
//}


class LevelOrderTraversal {


	/* 

    class Node 
    	int data;
    	Node left;
    	Node right;
	 */
	static Queue<Node> queue = new LinkedList<Node>();
	
	public static void levelOrder(Node root) {
		//		Use a queue when using levelOrder!
		if( root != null ){
			queue.add(root);
		}
		while( !queue.isEmpty() ){
			Node tree = queue.remove();
			System.out.print(tree.data + " ");

			if( tree.left != null ){
				queue.add( tree.left );
			}
			if( tree.right != null ){
				queue.add( tree.right );
			}
		}

	}

	public static Node insert(Node root, int data) {
		if(root == null) {
			return new Node(data);
		} else {
			Node cur;
			if(data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while(t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		levelOrder(root);
	}	
}