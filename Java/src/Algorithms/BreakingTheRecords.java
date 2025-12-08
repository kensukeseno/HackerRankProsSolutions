package Algorithms;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class ResultBreakingTheRecords {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
//    	Create variables to show the numbers of breaking max and min records
    	int breakMax = 0;
    	int breakMin = 0;
    	
//    	Set initial reacords
    	int max = scores.get(0);
    	int min = scores.get(0);
    	
    	
    	for(int i = 1; i < scores.size(); i++) {
    		if(scores.get(i) > max) {
    			breakMax++;
    			max = scores.get(i);
    		}
    		if(scores.get(i) < min) {
    			breakMin++;
    			min = scores.get(i);
    		}
    	}
    	return Arrays.asList(breakMax, breakMin);
    }

}

public class BreakingTheRecords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = ResultBreakingTheRecords.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
