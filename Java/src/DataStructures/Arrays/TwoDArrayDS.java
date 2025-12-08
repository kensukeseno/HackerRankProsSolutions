package DataStructures.Arrays;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ResultHourglassSum {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
    	int row = 0;
    	List<Integer> sums = new ArrayList<>();
    	int maxSum = -63;
    	
    	for(; row < 4; row++) {
        	int col = 0;
        	for(; col < 4; col++) { 	
        		int sum = arr.get(row).get(col) + 
				arr.get(row).get(col + 1) + 
				arr.get(row).get(col + 2) +
				arr.get(row + 1).get(col + 1) + 
				arr.get(row + 2).get(col) + 
				arr.get(row + 2).get(col + 1) +
				arr.get(row + 2).get(col + 2);
        		sums.add(sum);
        		if(sum > maxSum) maxSum = sum;}
    	}
    	return maxSum;

    }

}

public class TwoDArrayDS {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = ResultHourglassSum.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
