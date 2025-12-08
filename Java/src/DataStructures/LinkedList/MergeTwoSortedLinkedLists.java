package DataStructures.LinkedList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergeTwoSortedLinkedLists {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	// Complete the mergeLists function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode {
	 *     int data;
	 *     SinglyLinkedListNode next;
	 * }
	 *
	 */
	 static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

//		 set current nodes of each LinkedList
		 SinglyLinkedListNode currentNode1 = head1;
		 SinglyLinkedListNode currentNode2 = head2;
		 
		 SinglyLinkedListNode resultLinkedListHead = null;
		 
//		 set resultLinkedList head
		 if(head1 == null && head2 == null) {
		 }else if(head1 == null){
			 resultLinkedListHead = head2;
		 }else if(head2 == null){
			 resultLinkedListHead = head1;
		 }else {
//			 set result LinkedList to null;
			 SinglyLinkedListNode currrentResulstNode = null;
			 
			 if(head1.data < head2.data) {
				 currrentResulstNode = head1;
				 currentNode1 = currentNode1.next;
				 resultLinkedListHead = head1;
			 }else {
				 currrentResulstNode = head2;
				 currentNode2 = currentNode2.next;
				 resultLinkedListHead = head2;
			 }
			 while (currentNode1 != null && currentNode2 != null) {
				 if(currentNode1.data < currentNode2.data) {
					 currrentResulstNode.next = currentNode1;
					 currentNode1 = currentNode1.next;
					 currrentResulstNode =  currrentResulstNode.next;
				 }else {
					 currrentResulstNode.next = currentNode2;
					 currentNode2 = currentNode2.next;
					 currrentResulstNode =  currrentResulstNode.next;
				 }
			 }
			 if(currentNode1 != null) {
				 currrentResulstNode.next = currentNode1;
			 }else if(currentNode2 != null){
				 currrentResulstNode.next = currentNode2;				 
			 }
		 }
		 
		 return resultLinkedListHead;
	 }

	 private static final Scanner scanner = new Scanner(System.in);

	 public static void main(String[] args) throws IOException {
		 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		 int tests = scanner.nextInt();
		 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		 for (int testsItr = 0; testsItr < tests; testsItr++) {
			 SinglyLinkedList llist1 = new SinglyLinkedList();

			 int llist1Count = scanner.nextInt();
			 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			 for (int i = 0; i < llist1Count; i++) {
				 int llist1Item = scanner.nextInt();
				 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				 llist1.insertNode(llist1Item);
			 }

			 SinglyLinkedList llist2 = new SinglyLinkedList();

			 int llist2Count = scanner.nextInt();
			 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			 for (int i = 0; i < llist2Count; i++) {
				 int llist2Item = scanner.nextInt();
				 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				 llist2.insertNode(llist2Item);
			 }

			 SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

			 printSinglyLinkedList(llist3, " ", bufferedWriter);
			 bufferedWriter.newLine();
		 }

		 bufferedWriter.close();

		 scanner.close();
	 }
}
