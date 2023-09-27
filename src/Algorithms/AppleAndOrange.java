package Algorithms;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class ResultAppleAndOrange {

	/*
	 * Complete the 'countApplesAndOranges' function below.
	 *
	 * The function accepts following parameters:
	 *  1. INTEGER s
	 *  2. INTEGER t
	 *  3. INTEGER a
	 *  4. INTEGER b
	 *  5. INTEGER_ARRAY apples
	 *  6. INTEGER_ARRAY oranges
	 */

	public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
		// Write your code here
		int aCount = 0;
		int oCount = 0;

		for(int i = 0; i < apples.size(); i++) {
			if(a + apples.get(i) >= s && a + apples.get(i) <= t) {
				aCount++;
			}
		}
		for(int i = 0; i < oranges.size(); i++) {
			if(b + oranges.get(i) >= s && b + oranges.get(i) <= t) {
				oCount++;
			}
		}
		System.out.println(aCount);
		System.out.println(oCount);

	}

}

public class AppleAndOrange {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int s = Integer.parseInt(firstMultipleInput[0]);

		int t = Integer.parseInt(firstMultipleInput[1]);

		String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int a = Integer.parseInt(secondMultipleInput[0]);

		int b = Integer.parseInt(secondMultipleInput[1]);

		String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int m = Integer.parseInt(thirdMultipleInput[0]);

		int n = Integer.parseInt(thirdMultipleInput[1]);

		List<Integer> apples = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		List<Integer> oranges = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		ResultAppleAndOrange.countApplesAndOranges(s, t, a, b, apples, oranges);

		bufferedReader.close();
	}
}