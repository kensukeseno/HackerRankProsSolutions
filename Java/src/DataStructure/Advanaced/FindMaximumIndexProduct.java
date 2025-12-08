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

class ResultFindMaximumIndexProduct {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an Long.
     * The function accepts Long_ARRAY arr as parameter.
     */

    public static long solve(List<Long> arr) {
    // Write your code here
    	Stack<List<Long>> lftStack = new Stack<>();
    	Stack<List<Long>> rghtStack = new Stack<>();
    	
    	lftStack.push(List.of((long)1, arr.get(0)));
    	rghtStack.push(List.of((long)arr.size(), arr.get(arr.size() - 1)));
    	
    	long lft = 0;
    	List<Long> lftList = new ArrayList<>();
    	lftList.add((long)0);
    	long rght = 0;
    	List<Long> rghtList = new ArrayList<>();
    	rghtList.add((long)0);
    	

    	
    	for(int i = 1; i < arr.size(); i++) {
    		while(!lftStack.isEmpty()) {
    			if(lftStack.peek().get(1) > arr.get(i)) {
    				break;
    			}else {
    				lftStack.pop();
    			}
    		}
    		
    		if(!lftStack.isEmpty()) {
    			lft = lftStack.peek().get(0);
    		}else {
    			lft = 0;
    		}
    		
    		lftStack.push(List.of((long)i + 1 ,(long)arr.get(i)));
    		lftList.add(lft);
    	}
    	
    	for(int i = 1; i < arr.size(); i++) {
    		while(!rghtStack.isEmpty()){
        		if(rghtStack.peek().get(1) > arr.get(arr.size() - 1 - i)) {
        			break;
        		}else {
        			rghtStack.pop();
        		}
    		}
    		
    		if(!rghtStack.isEmpty()) {
    			rght = rghtStack.peek().get(0);
    		}else {
    			rght = 0;
    		}
    		
    		rghtStack.push(List.of((long)arr.size() - i, (long)arr.get(arr.size() - 1 - i)));
    		rghtList.add(0, rght);
    	}

    	long max = 0;
    	for(int i = 1; i < arr.size(); i++) {
    		if(lftList.get(i) * rghtList.get(i) > max) {
    			max = lftList.get(i) * rghtList.get(i);
    		}
    	}
    	
    	System.out.println(max);
    	
    	return max;
    }

}


public class FindMaximumIndexProduct {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long result = ResultFindMaximumIndexProduct.solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
