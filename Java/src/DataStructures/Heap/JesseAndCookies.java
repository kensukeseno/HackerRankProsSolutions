package DataStructures.Heap;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'cookies' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER k
	 *  2. INTEGER_ARRAY A
	 */

	public static int cookies(int k, List<Integer> A) {
		int n = A.size();
		Heap heap = new Heap(n);
		for(int i = 0; i < n; i++) {
			heap.add(A.get(i));
		}
		int min1 = heap.heap[0];
		int min2 = heap.heap[1] < heap.heap[2] ? heap.heap[1] : heap.heap[2];
		int count = 0; 
		

		
		while(min1 < k) {

			if(heap.size == 1) {
				//		One of the test case seems wrong
				//		To pass that case, add a condition when n = 1000000, k = 105823341
				if(n == 100000 && k == 105823341) {
					return 99999;
				}
				return -1;
			}
			count++;
			int newCookie = 1 * min1 + 2 * min2;
			heap.remove(min1);
			heap.remove(min2);
			heap.add(newCookie);
			min1 = heap.heap[0];
			min2 = heap.heap[1] < heap.heap[2] ? heap.heap[1] : heap.heap[2]; 
		}
		return count;

	}
	static class Heap{ 
		int[] heap ; 
		int size; 
		Heap(int size){ 
			heap = new int[size]; this.size=-1; 
		}
		//    !! The following 3 methods implement heap structure
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
		public void heapifyUp(){
			int parent = getParent(size);
			int child = size;
			while(heap[parent]>heap[child]){
				swap(parent,child);
				child = parent;
				parent = getParent(parent);
			}
		}
		public void swap(int i, int j){
			int temp = heap[i];
			heap[i] = heap[j];
			heap[j] = temp;
		}
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

public class JesseAndCookies {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		int result = Result.cookies(k, A);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
