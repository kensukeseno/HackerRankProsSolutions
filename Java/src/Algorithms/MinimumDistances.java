package Algorithms;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class ResultMinimumDistances {

    /*
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int minimumDistances(List<Integer> a) {
    // Write your code here
    	int min = 1000;
    	int dis = 0;
    	Map<Integer, Integer> numAndIndex = new HashMap<>();
    	for(int i = 0; i < a.size(); i++) {
    			if(numAndIndex.containsKey(a.get(i))) {
    				dis = Math.abs(numAndIndex.get(a.get(i)) - i);
    				numAndIndex.replace(a.get(i), i);
    				if(dis < min) {
    					min = dis;
    				}
    			}else {
    				numAndIndex.put(a.get(i), i);
    			}
    		}
    	if(min == 1000) {
    		return -1;
    	}else {
        	return min;	
    	}
    }
}

public class MinimumDistances {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = ResultMinimumDistances.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
