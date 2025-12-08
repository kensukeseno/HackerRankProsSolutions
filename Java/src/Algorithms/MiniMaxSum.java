package Algorithms;
import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ResultMiniMaxSum {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
	
	static long total;
	
    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
//    	Sort arr in an ascending order
    	List<Integer> sortedArr = arr.stream().sorted().collect(Collectors.toList());

//    	Calculate the sum
    	sortedArr.forEach(num -> total += num);
   
//    	Get min and max nums
    	long min = total - sortedArr.get(4);
    	long max = total - sortedArr.get(0);
    	
    	System.out.println(min + " " + max);
    }

}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        ResultMiniMaxSum.miniMaxSum(arr);

        bufferedReader.close();
    }
}
