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
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ResultOrganizingContainersOfBalls {

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
    // Write your code here
    	String answer = "Possible";
    	List<Integer> rowSums = new ArrayList<>();
    	List<Integer> lineSums = new ArrayList<>();;

    	for(int i = 0; i < container.size(); i++) {
        	int lineSume = 0;    		
        	int rowSume = 0;
    		for(int c = 0; c < container.size(); c++) {
    			lineSume += container.get(c).get(i);
    			rowSume += container.get(i).get(c);
    		}
    		rowSums.add(rowSume);
    		lineSums.add(lineSume);
    	}
    	
    	for(int i = 0; i < container.size(); i++) {
    		boolean evaluation = false;
    		for(int c = 0; c < container.size(); c++) {
    			if(rowSums.get(i).equals(lineSums.get(c))) {
    				evaluation = true;
    			}
    		}
    		if(!evaluation) {
    			answer = "Impossible";
    			break;
    		}
    	}
    	
    	return answer;
    }

}

public class OrganizingContainersOfBalls {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = ResultOrganizingContainersOfBalls.organizingContainers(container);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
