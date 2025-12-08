package Algorithms;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ResultCutTheSticks {

    /*
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> cutTheSticks(List<Integer> arr) {
    // Write your code here
    	List<Integer> stickNum = new ArrayList<>();
    	stickNum.add(arr.size());
    	
    	while(lengthEvaluate(arr)) {
    		int shortest = arr.stream().min(Comparator.naturalOrder()).orElseThrow();
    		arr = arr.stream().filter(i -> i != shortest).map(i -> i - shortest).collect(Collectors.toList());
    		stickNum.add(arr.size());
    	}
    	return stickNum;
    }
    
    public static boolean lengthEvaluate(List<Integer> arr) {
    	boolean isVaryingLen = false;
    	int preLen = arr.get(0);
    	for(int len: arr) {
    		if(preLen != len) {
    			isVaryingLen = true;
    			break;
    		}	
    		preLen = len;
    	}
    	return isVaryingLen;
    }

}

public class CutTheSticks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = ResultCutTheSticks.cutTheSticks(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
