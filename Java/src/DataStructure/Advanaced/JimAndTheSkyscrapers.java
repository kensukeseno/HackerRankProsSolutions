package DataStructure.Advanaced;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultJimAndTheSkyscrapers {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long solve(List<Integer> arr) {
    // Write your code here
//    	Plan1 (Runtime limit over)
//    	Stack<Integer> stack = new Stack<>();
//    	int counter = 0;
//    	Stack<Integer> sameNumStack = new Stack<>();
//    	
//    	for(int i = 0; i < arr.size(); i++) {
//    		int num = arr.get(i);
//    		while(!stack.isEmpty()) {
//    			if(stack.peek() > num) {
//    				break;
//    			}else if(stack.peek() == num) {
//    				counter++;
//    				sameNumStack.push(stack.pop());
//    			}else {
//    				stack.pop();
//    			}
//    		}
//    		while(!sameNumStack.isEmpty()) {
//    			stack.push(sameNumStack.pop());
//    		}
//			stack.push(num);
//    	}
//    	System.out.println(counter * 2);
//    	return counter * 2;
    	
//    	Plan2 (Invalid logic)
//    	Stack<Integer> stack = new Stack<>();
//    	int counter = 0;
//    	
//    	for(int i = 0; i < arr.size(); i++) {
//    		int num = arr.get(i);
//    		while(!stack.isEmpty()) {
//    			if(stack.peek() >= num) {
//    				break;
//    			}else {
//    				int top = stack.pop();
//    				if(!stack.isEmpty() && top == stack.peek()) {
//    					counter++;
//    				}
//    			}
//    		}
//			stack.push(num);
//    	}
//    	
//        for(int i = 0; i < stack.size(); i++) {
//            for(int j = i+1; j < stack.size(); j++) {
//                    counter++;
//                }
//            }
//        
//        System.out.println(counter * 2);
//    	return counter * 2;
    	
//    	Plan3
    	Stack<Integer> stack = new Stack<>();
    	long counter = 0;
    	
    	for(int i = 0; i < arr.size(); i++) {
    		int num = arr.get(i);
    		while(!stack.isEmpty()) {
    			if(stack.peek() >= num) {
    				break;
    			}else {
    				int top = stack.pop();
    				long sameNumCounter = 0;
    				if(!stack.isEmpty() && top == stack.peek()) {
    					sameNumCounter++;
    				}
    				while(!stack.isEmpty() && top == stack.peek()) {
    					sameNumCounter++;
    					stack.pop();
    				}
//    				Count combinations
    				counter += sameNumCounter * (sameNumCounter - 1);
    			}
    		}
			stack.push(num);
    	}
    	
    	long sameNumCounter = 1;
    	while(!stack.isEmpty()) {
    		int top = stack.pop();
    		
    		if(!stack.isEmpty() && top == stack.peek()) {
    			sameNumCounter++;
    		}else {
    			if(sameNumCounter != 1)
    				counter += sameNumCounter * (sameNumCounter - 1);
    			sameNumCounter = 1;
    		}
    	}
    	return counter;
    }
}

public class JimAndTheSkyscrapers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        long result = ResultJimAndTheSkyscrapers.solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
