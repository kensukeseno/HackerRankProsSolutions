package DataStructures.Queues;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

class ResultQueueUsingTwoStacks {

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid
     *  2. INTEGER startX
     *  3. INTEGER startY
     *  4. INTEGER goalX
     *  5. INTEGER goalY
     */

    public static List<Long> elementPrinter(List<String> operations) {
    // Write your code here
//    	Implement a queue with 2 stacks
    	Stack<Long> stack1 = new Stack<>();
    	Stack<Long> stack2 = new Stack<>();
    	
//    	Prepare a variable to store values to print
    	List<Long> print = new ArrayList<>();
    	
//    	Prepare a variable to keep track of a top value on queue
    	long top = 0;
    	
    	for(int i = 0; i < operations.size(); i++) {
    		if(operations.get(i).charAt(0) == '1') {
    			stack1.push(Long.parseLong(operations.get(i).substring(2, operations.get(i).length())));
    			if(stack1.size() == 1 && stack2.size() == 0) {
    				top = stack1.peek();
    			}
    		}else if (operations.get(i).charAt(0) == '2') {
    			/*
    			 * In case stack2 is empty, move all values in stack1 to stack2.
    			 * Now that the value on top of stack2 is a top value of the queue.
    			 */
    			if(stack2.isEmpty()) {
        			while(!stack1.isEmpty()) {
        				stack2.push(stack1.pop());
        			}
    			}
    			stack2.pop();
    			if(!stack2.isEmpty()) {
    				top = stack2.peek();
    			}else {
            		while(!stack1.isEmpty()) {
            			stack2.push(stack1.pop());
            		}
            		if(!stack2.isEmpty()) {
            			top = stack2.peek();
            		}
    			}
    		}else if (operations.get(i).charAt(0) == '3') {
    			print.add(top);
    		}
    	}
    	return print;
    }
}

public class QueueUsingTwoStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(bufferedReader);
        
        int q = scan.nextInt();
        scan.nextLine();
        List<String> queries = new ArrayList<>();
        for(int i = 0; i < q; i++) {
        	queries.add(scan.nextLine());
        }
        List<Long> ans = ResultQueueUsingTwoStacks.elementPrinter(queries);
        
        for(int i = 0; i < ans.size(); i++) {
        	System.out.println(ans.get(i));
        }
        scan.close();
    }
}
