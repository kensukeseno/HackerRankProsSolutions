package DataStructures.Trees;

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

class TopView {
	/* 

    class Node 
    	int data;
    	Node left;
    	Node right;
	 */

	static class NodeWithHandX{
		Node node;
		int height;
		int x;

		NodeWithHandX(Node node, int height, int x){
			this.node = node;
			this.height = height;
			this.x = x;
		}
	}
	//		Prepare a list of nodes with neccesary information
	static NodeWithHandX[] nodeList = new NodeWithHandX[500];

	public static void topView(Node root) {

		//		Give each node height and x-axis location
		nodes(root, 1, 0);

		for(int i = 0; i < 500; i++) {
			if(nodeList[i] != null) {
				System.out.print(nodeList[i].node.data + " ");			
			}

		}

	}

	public static void nodes(Node node, int heihgt, int x) {
		//		TODO: add condition!
		if(nodeList[x + 250] == null) {
			nodeList[x + 250] = new NodeWithHandX(node, heihgt, x + 250);			
		}else {
			if(nodeList[x + 250].height > heihgt) {
				nodeList[x + 250] = new NodeWithHandX(node, heihgt, x + 250);
			}
		}


		if(node.left != null) {
			nodes(node.left, heihgt + 1, x - 1);
		}
		if(node.right != null) {
			nodes(node.right, heihgt + 1, x + 1);
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
		topView(root);
	}	
}