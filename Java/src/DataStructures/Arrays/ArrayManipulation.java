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

class ResultArrayManipulation {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */
	
	static Long max = (long) 0;

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
    // Write your code here
    	/*
    	 * Firstly, go through all operations and add numbers to values of an array.
    	 * Secondly, find the max number.
    	 */
    	
//    	Create an array with length of n
    	Long[] arr = new Long[n + 1];

//    	Define variables for start, end and adding number of an operation.
    	int start = 0;
    	int end = 0;
    	int num = 0;
    	
//    	For each operation, add the number to values of the array.
    	for(int i = 0; i < queries.size(); i++) {
		 start = queries.get(i).get(0) - 1;
		 end = queries.get(i).get(1) - 1;
		 num = queries.get(i).get(2);
		 
		 if(arr[start] != null)
			 arr[start] += num;
		 else
			 arr[start] = (long)num;
		 if(arr[end + 1] != null)
			 arr[end + 1] -= num;
		 else
			 arr[end + 1] = -(long)num;
    	}
    	
    	if(arr[0] == null)
    		arr[0] = (long)0;
    	
    	for(int i = 1; i < arr.length - 1; i++) {
    		if(arr[i] != null)
   			 arr[i] += arr[i - 1];
   		 else
   			 arr[i] = arr[i - 1];
    	}
    	
//    	Find the max value
    	for(int i = 0; i < n; i++) {
		if(arr[i] != null) {
		if(arr[i] > max) max = arr[i];}
	}
    	
    	return max;
    }

}

public class ArrayManipulation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = ResultArrayManipulation.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
