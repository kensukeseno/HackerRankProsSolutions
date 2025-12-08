package DataStructures.Stacks;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

class ResultEqualStacks {

	/*
	 * Complete the 'equalStacks' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER_ARRAY h1
	 *  2. INTEGER_ARRAY h2
	 *  3. INTEGER_ARRAY h3
	 */

	public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
		// Write your code here
		//    	Repeat removing one cylinder on top from  the highest stack until hights are equalized
		Boolean equalFlag = false;
		int sumH1 = h1.stream().mapToInt(Integer::intValue).sum();
		int sumH2 = h2.stream().mapToInt(Integer::intValue).sum();
		int sumH3 = h3.stream().mapToInt(Integer::intValue).sum();

		//		Convert list to stack
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		Stack<Integer> stack3 = new Stack<>();
		for(int i = 0; i < h1.size(); i++) {
			stack1.push(h1.get(h1.size() - 1 - i));
		}
		for(int i = 0; i < h2.size(); i++) {
			stack2.push(h2.get(h2.size() - 1 - i));
		}
		for(int i = 0; i < h3.size(); i++) {
			stack3.push(h3.get(h3.size() - 1 - i));
		}

		while(!equalFlag) {
			if(sumH1 == sumH2 && sumH1 == sumH3 && sumH2 == sumH3) {
				equalFlag = true;
			}else {
				if(sumH1 >= sumH2 && sumH1 >= sumH3) {
					sumH1 -= stack1.peek();
					stack1.pop();
				}else if(sumH2 >= sumH1 && sumH2 >= sumH3) {
					sumH2 -= stack2.peek();
					stack2.pop();
				}else {
					sumH3 -= stack3.peek();
					stack3.pop();
				}
			}
		}
		return sumH1;
	}

}

public class EqualStacks {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n1 = Integer.parseInt(firstMultipleInput[0]);

		int n2 = Integer.parseInt(firstMultipleInput[1]);

		int n3 = Integer.parseInt(firstMultipleInput[2]);

		List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		int result = ResultEqualStacks.equalStacks(h1, h2, h3);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
