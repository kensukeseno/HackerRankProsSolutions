package DataStructures.Stacks;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class ResultMaximumElement {

	/*
	 * Complete the 'getMax' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY.
	 * The function accepts STRING_ARRAY operations as parameter.
	 */

	public static List<Integer> getMax(List<String> operations) {
		// Write your code here
//		Everytime having 3, pop all out to find out the max number
		List<Integer> printResults = new ArrayList<>();
		List<Integer> stack = new ArrayList<>();

		for(int i = 0 ; i < operations.size(); i++) {
			int query = Integer.parseInt(operations.get(i).substring(0, 1));
			switch(query) {
			case 1:
				int element = Integer.parseInt(operations.get(i).substring(2, operations.get(i).length()));
				stack.add(element);
				break;
			case 2: 
				stack.remove(stack.size() - 1);
				break;
			case 3:
				int max = stack.stream().mapToInt(Integer::intValue).max().getAsInt();
				printResults.add(max);
				break;
			}
		}
		return printResults;

	}

}

public class MaximumElement {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> ops = IntStream.range(0, n).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		})
				.collect(toList());

		List<Integer> res = ResultMaximumElement.getMax(ops);

		bufferedWriter.write(
				res.stream()
				.map(Object::toString)
				.collect(joining("\n"))
				+ "\n"
				);

		bufferedReader.close();
		bufferedWriter.close();
	}
}
