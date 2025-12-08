package DataStructures.Trees;

import java.util.Scanner;

class HeightOfABinaryTree {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
      	// Write your code here.
//Editorial answer
//	    if (root == null){
//	        return -1;
//	    }
//	    else{
//	        return 1 + Math.max( height(root.left), height(root.right) );
//	    }	
//Own anser
		return levelAdd(0, root);		
    }
	
	/*
    class levelAdd
    	input: current level
    	output: result level
	*/
	public static int levelAdd(int level, Node root) {
		int leftLevel = level;
		int rightLevel = level;
		
		if(root.left != null) {
			leftLevel ++;
			leftLevel = levelAdd(leftLevel, root.left);
		}
		if(root.right != null) {
			rightLevel ++;
			rightLevel = levelAdd(rightLevel, root.right);
		}
		
		return leftLevel > rightLevel ? leftLevel : rightLevel;
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
        int height = height(root);
        System.out.println(height);
    }	
}