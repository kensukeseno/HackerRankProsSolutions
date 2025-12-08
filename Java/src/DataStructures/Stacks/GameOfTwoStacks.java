package DataStructures.Stacks;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ResultGameOfTwoStacks {

	/*
	 * Complete the 'twoStacks' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER maxSum
	 *  2. INTEGER_ARRAY a
	 *  3. INTEGER_ARRAY b
	 */

	public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
		// Write your code here
		//    	Set score to zero
		int score = 0;

		//    	Create two stacks
		Stack<Integer> stackA = new Stack<>() ;
		Stack<Integer> stackB = new Stack<>() ;
		for(int i = 0; i < a.size(); i++) {
			stackA.push(a.get(a.size() - 1 - i));
		}
		for(int i = 0; i < b.size(); i++) {
			stackB.push(b.get(b.size() - 1 - i));
		}

		//    	First, count score when taking numbers only from stack a
		Stack<Integer> pushedFromstackA = new Stack<>() ;
		boolean exceedFlagA = false;
		int sum = 0;
		int scoreA = 0;
		while(!exceedFlagA) {
			if(stackA.empty()) {
				break;
			}  else {
				if(sum + stackA.peek() <= maxSum) {
					sum += stackA.peek();
					pushedFromstackA.push(stackA.peek());
					stackA.pop();
					scoreA++;
				}else {
					exceedFlagA = true;
				}
			}
		}
		score = scoreA;

		//    	Next, add value from the top of stack b to sum if sum exceed maxSum, remove value derived from a
		int scoreB = scoreA;
		boolean exceedFlagB = false;
		while(!exceedFlagB) {
			if(stackB.empty()) {
				break;
			}  else {
				//    		When adding next value from stack b exceed sumMax, remove value of stack a
				while(sum + stackB.peek() > maxSum) {
					if(pushedFromstackA.empty()) {
						break;
					}else {
						sum -= pushedFromstackA.peek();
						pushedFromstackA.pop();
						scoreB--;}
				}
				if(sum + stackB.peek() <= maxSum) {
					sum += stackB.peek();
					stackB.pop();
					scoreB++;
					if(scoreB > score) {
						score = scoreB;
					}
				}else {
					exceedFlagB = true;
				}
			}
		}
		return score;
	}	
}

public class GameOfTwoStacks {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int g = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, g).forEach(gItr -> {
			try {
				String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				int n = Integer.parseInt(firstMultipleInput[0]);

				int m = Integer.parseInt(firstMultipleInput[1]);

				int maxSum = Integer.parseInt(firstMultipleInput[2]);

				List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt)
						.collect(toList());

				List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt)
						.collect(toList());

				int result = ResultGameOfTwoStacks.twoStacks(maxSum, a, b);

				bufferedWriter.write(String.valueOf(result));
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
