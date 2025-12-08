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

class ResultLargestRectangle {

	/*
	 * Complete the 'largestRectangle' function below.
	 *
	 * The function is expected to return a LONG_INTEGER.
	 * The function accepts INTEGER_ARRAY h as parameter.
	 */

	public static long largestRectangle(List<Integer> h) {
		// Write your code here
		//    	The algorithm is below
		//    	Take a hight from the left in order  and put it on  a stack along with an index of list. 
		//    	If the height is smaller than the one on top of the stack, pop and push the height.
		//    	When poping a height, caluculate the area of rectangular made with the hieght.

		Stack<Building> stack = new Stack<>();
		long maxArea = 0;
		long area = 0;
		h.add(0);

		for(int i = 0; i < h.size(); i++) {
			Building building = new Building(h.get(i), i);
			boolean stackFlag = false;
			while(!stackFlag){
				if(stack.empty() || stack.peek().height < building.height) {
					stack.push(building);
					stackFlag = true;
				} else if(stack.peek().height.equals(building.height)){
					stack.pop();
					if(stack.empty()) {
						area = building.height * (building.index + 1);
					}else {
						area = building.height * (building.index - stack.peek().index);						
					}
				}
				else {
					long height = stack.peek().height;
					stack.pop();
					if(stack.empty()) {
						area = height * (building.index);
					}else {
						area = height * (building.index - 1 - stack.peek().index);						
					}
				}
				if(area > maxArea) {
					maxArea = area;
				}
			}
		}
		return maxArea;
	}

	static class Building{
		Integer height;
		Integer index;
		public Building(Integer height, Integer index) {
			this.height = height;
			this.index = index;
		}
	}

}


public class LargestRectangle {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		long result = ResultLargestRectangle.largestRectangle(h);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
