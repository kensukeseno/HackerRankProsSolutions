package DataStructures.Stacks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

class Result {

	/*
	 * Complete the 'isBalanced' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts STRING s as parameter.
	 */

	public static String isBalanced(String s) {
		// Write your code here
		String yesNo = "YES";

		Stack<Character> openingBrakcet = new Stack<>();
		boolean breakFlag = false;

		for(int i = 0; i < s.length(); i++){
			//			Push opening bracket into Stack
			char bracket = s.charAt(i);
			//			if bracket is opening bracket, push to stack
			if(bracket == '{' || bracket == '(' || bracket == '[') {
				openingBrakcet.push(bracket);
				//			If not, compare top of stack and bracket. If they make a pair, string is balanced. 
				//			And pop one on top out.
			}else {
				if(openingBrakcet.empty()) {
					yesNo = "NO";
					breakFlag = true;
				}else {
					switch (openingBrakcet.peek()) {
					case ('{'):
						yesNo = bracket == '}' ? "YES" : "NO";
					openingBrakcet.pop();
					break;
					case ('('):
						yesNo = bracket == ')' ? "YES" : "NO";
					openingBrakcet.pop();
					break;
					case ('['):
						yesNo = bracket == ']' ? "YES" : "NO";
					openingBrakcet.pop();
					break;
					}}

				if(yesNo =="NO") {
					breakFlag = true;
					break;
				}
			}
		}

		//		If loop was not ended in the middle, and stack is not empty, string is not balenced
		if(!breakFlag && !openingBrakcet.empty()) {
			yesNo = "NO";
		}

		return yesNo;
	}

}

public class BalancedBrackets {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				String s = bufferedReader.readLine();

				String result = Result.isBalanced(s);

				bufferedWriter.write(result);
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
