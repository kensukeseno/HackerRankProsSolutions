package Algorithms;
import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ResultPickingNumbers {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
    // Write your code here
//    	Strategy
//    	Sort numbers in a natural order.
//    	Based on each number from the top of sorted array, count the length of subarrays that meet conditions.
    	
    	List<Integer> sortedA = a.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    	int maxlen = 1;
    	int len = 1;
    	int sameNumLen = 1;
    	boolean isFirstNum = true;
    	int num = sortedA.get(0);
    	for(int i = 1; i < sortedA.size(); i++) {
    		int nextNum = sortedA.get(i);
    		if( nextNum == num) {
    			len++;
    			sameNumLen++;
    		}else if (isFirstNum && Math.abs(num - nextNum) == 1){
    			isFirstNum = false;
    			len ++;
    			sameNumLen = 1;
    			num = nextNum;
    		}else if (!isFirstNum && Math.abs(num - nextNum) == 1) {
    			len = sameNumLen + 1;
    			sameNumLen = 1;
    			num = nextNum;
    		}else {
    			isFirstNum = true;
    			len = 1;
    	    	sameNumLen = 1;
    	    	num = nextNum;
    		}
    		if(len > maxlen) {
    			maxlen = len;
    		}
    	}
//    	debug
    	System.out.println(maxlen);
    	
    	return maxlen;
    }

}

public class PickingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = ResultPickingNumbers.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
