package Algorithms;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class ResultMigratoryBirds {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
    // Write your code here 	
//    	Prepare an array with 5 indexes
    	int[] typeCounter = new int[5];
    	
//    	Count types of sighted birds
    	for(int i = 0; i < arr.size(); i++) {
    		int id = arr.get(i);
    		typeCounter[id - 1] += 1;
    	}
    	
//    	Find the id of most sighted birds
    	int mostSightedTimes = 0;
    	int mostSightedId = 0;
    	for(int i = 0; i < 5; i++) {
    		if(typeCounter[i] > mostSightedTimes) {
    			mostSightedTimes = typeCounter[i];
    			mostSightedId = i + 1;
    		}
    	}
    	return mostSightedId;
    }
}

public class MigratoryBirds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = ResultMigratoryBirds.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
