package DataStructures.Stacks.Unsolved;

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
	 * Complete the 'poisonousPlants' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts INTEGER_ARRAY p as parameter.
	 */

	public static int poisonousPlants(List<Integer> p) {
		// Write your code here
		// Look for plant to die and delete it
		// Put null when deleted
		//		Solution 1
		//		int listSize = p.size();
		//		boolean deleteFlag = true;
		//		int count = -1;
		//
		//		while(deleteFlag) {
		//			count++;
		//			int nextNum = p.get(0);
		//			for(int i = 0; i < listSize - 1; i++) {
		//				int leftNum = nextNum;
		//				nextNum = p.get(i + 1);
		//
		//				if(leftNum < p.get(i + 1)) {
		//						p.set(i + 1, null);
		//					}
		//
		//			}
		//			deleteFlag = p.removeIf(i -> i == null);	
		//			listSize = p.size();
		//		}
		//
		//		return count;

//		//		Solution2 fali
//		//		Cout how many time in a row right number is bigger than left one
//
//		//		Prepare a variable that is current number in loop
//		int currentNum = p.get(0);
//		//		Prepare a variable that is next number in loop		
//		int nextNum = p.get(1);
//		//		Prepare a variable that is compared to next number
//		int numToCompare = p.get(0);
//		//		Prepare a variable that reflect max days in row plants die
//		int maxCounter = 0;
//		//		Prepare a variable that reflect days in row plants die		
//		int counter = 0;
//
//		for(int i = 0; i < p.size() - 1; i++) {
//			currentNum = p.get(i);
//			nextNum = p.get(i+ 1);
//			//			Right one dies on the first day
//			if(currentNum < nextNum) {
//				if(counter == 0) {
//					numToCompare = currentNum;
//				}
//				counter = 1;
//				if(maxCounter < counter) {
//					maxCounter = counter;
//
//				}
//			//			Right one does not die on the fst day	
//			}else {
//				if(numToCompare < nextNum) {
//					counter++;
//					if(maxCounter < counter) {
//						maxCounter = counter;
//
//					}
//				}else {
//					counter = 0;
//					numToCompare = nextNum;
//				}
//			}
//		}
//		return maxCounter;
		return 1;
	}

}

public class StackPoisonousPlants {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		int result = Result.poisonousPlants(p);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
