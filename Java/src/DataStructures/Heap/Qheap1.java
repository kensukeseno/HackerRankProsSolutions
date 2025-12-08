package DataStructures.Heap;

import java.io.IOException;
import java.util.Scanner;

public class Qheap1 {

//	!!!!Very important to understand the implementation of heap in Java
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Heap heap = new Heap();
		while(n-->0){
			int q = sc.nextInt();
			if(q==1){
				int v = Integer.parseInt(sc.next());
				heap.add(v);
			}
			else if(q==2){
				int v = Integer.parseInt(sc.next());
				heap.remove(v);
			}
			else{
				System.out.println(heap.getMin());
			}
		}

	}
	static class Heap{ int[] heap ; int size; Heap(){ heap = new int[1000000]; size=-1; }
//	!! The following 3 methods implement heap structure
	public int getParent(int childIndex){
		return (childIndex-1)/2;
	}
	public int getLeftChild(int parentIndex){
		return 2*parentIndex + 1;
	}
	public int getRightChild(int parentIndex){
		return 2*parentIndex + 2;
	}
	public boolean hasParent(int childIndex){
		int parent = (childIndex-1)/2;
		return parent>=0;
	}
	public boolean hasLeftChild(int parentIndex){
		int left = 2*parentIndex + 1;
		return left<=size;
	}
	public boolean hasRightChild(int parentIndex){
		int right = 2*parentIndex + 2;
		return right<=size;
	}

	public void add(int v){
		size++;
		heap[size]=v;
		heapifyUp();
	}
//	Remove the target number and put the number at the end of heap
//	in a place where the target number was lacated
//	Then, put the number down step by step
	public void remove(int v){
		// for(int i=0; i<=size; i++){
		//     System.out.print(heap[i]+" ");
		// }
		// System.out.println();
		int i=0; 
		while(i<=size){
			if(heap[i]==v) break;
			else i++;
		}
		heap[i]=heap[size];
		size--;
		heapifyDown(i);
	}

	public int getMin(){
		if(size==-1) return -1;

		// for(int i=0; i<=size; i++){
		//     System.out.print(heap[i]+" ");
		// }
		// System.out.println();
		return heap[0];
	}

	public void swap(int i, int j){
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public void heapifyUp(){
		int parent = getParent(size);
		int child = size;
		while(heap[parent]>heap[child]){
			swap(parent,child);
			child = parent;
			parent = getParent(parent);
		}
	}

	public void heapifyDown(int i){
		while(hasLeftChild(i)){
			int left = getLeftChild(i);
			int min = left;
			if(hasRightChild(i)){
				int right = getRightChild(i);
				if(heap[left]<=heap[right]) min = left;
				else min = right;
			}

			if(heap[i]<heap[min]) break;
			swap(i,min);
			i=min;
		}
	}
	}
}


/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//    	First, ignore time complexity problem
//    	For each query, take every numbers out of a queue, delete or add a number and put them back
//		Queue<Long> queue = new LinkedList<>();
//
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		int queries = scanner.nextInt();
//
//
//		for(int i = 0; i < queries; i++) {
//			int query = scanner.nextInt();
//
//			switch(query) {
//			case 1:
//				long add = scanner.nextLong();
//				if(queue.isEmpty()) {
//					queue.add(add);
//				}else {
//					int qSize = queue.size();
//					for(int t = 0; t < qSize; t++) {
//						long top = queue.remove();
//						if(add < top) {
//							queue.add(add);
//						}
//						queue.add(top);
//						if(add > top) {
//							queue.add(add);
//						}
//					}
//				}
//				break;
//			case 2:
//				long delete = scanner.nextLong();
//				int qSize = queue.size();
//				for(int t = 0; t < qSize; t++) {
//					long top = queue.remove();
//					if(top != delete) {
//						queue.add(top);						
//					}
//				}
//				break;
//			case 3:
//				bufferedWriter.write(String.valueOf(queue.peek()));
//				bufferedWriter.newLine();
//				break;
//			}
//
//		}
//		bufferedWriter.close();
//		scanner.close();

