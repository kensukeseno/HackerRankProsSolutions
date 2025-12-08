package Algorithms;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ResultNonDivisibleSubset {

	/*
	 * Complete the 'nonDivisibleSubset' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER k
	 *  2. INTEGER_ARRAY s
	 */

	public static int nonDivisibleSubset(int k, List<Integer> s) {
		// Write your code here
		//    	When a number is devided by k, there are k possible remainder.
		//    	if k is an even number, k/2 pairs make k by adding those numbers.
		//    	if k is an odd number, (k-1)/2 pairs make k by adding those numbers.
		int count = 0;

		List<Integer> remainderS = s.stream().map(num -> num % k).collect(Collectors.toList());
		int[] remainderArray = new int[k];
		for(int remainder: remainderS) {
			remainderArray[remainder]++;
		}

		if(k%2 == 0) {
//    		Only one of numbers that can be evenly devided by k can be in the subarray
			if(remainderArray[0] > 0) {
				count++;
			}
			for(int i = 1; i < k/2; i++) {
				if(remainderArray[i] >= remainderArray[k - i]) {
					count += remainderArray[i];
				}else{
					count += remainderArray[k - i];
				}
//			Only one of numbers that produces half of k as remainder when devided by k can be in the subarray
			}
			if(remainderArray[k/2] > 0) {
				count ++;
			}
		}
		if(k%2 == 1) {
			if(remainderArray[0] > 0) {
				count++;
			}
			for(int i = 1; i < (k - 1)/2 + 1; i++) {
				if(remainderArray[i] >= remainderArray[k - i]) {
					count += remainderArray[i];
				}else{
					count += remainderArray[k - i];
				}
			}
		}

		return count;

	}

}

public class NonDivisibleSubset {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		int result = ResultNonDivisibleSubset.nonDivisibleSubset(k, s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
