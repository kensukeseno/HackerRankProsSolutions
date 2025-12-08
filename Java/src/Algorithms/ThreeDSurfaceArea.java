package Algorithms;

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

class ResultThreeDSurfaceArea {

    /*
     * Complete the 'surfaceArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY A as parameter.
     */

    public static int surfaceArea(List<List<Integer>> A) {
    // Write your code here
    	int rowSize = A.size();
    	int colunmSize = A.get(0).size();
    	
//    	The top and bottom area
    	int topBottom = 2 * (rowSize * colunmSize);
    	
//    	The outside area
    	int outside = 0;
    	for(int i = 0; i < colunmSize; i++) {
    		outside += A.get(0).get(i);
    		outside += A.get(rowSize - 1).get(i);
    	}
    	for(int i = 0; i < rowSize; i++) {
    		outside += A.get(i).get(0);
    		outside += A.get(i).get(colunmSize - 1);
    	}
    	
//    	The inside side (x direction)
    	int sideH = 0;
    	for(int i = 0; i < rowSize; i++) {
    		for(int t = 0; t < colunmSize - 1; t++) {
    			sideH += Math.abs(A.get(i).get(t) - A.get(i).get(t + 1));
    		}
    	}
    	
//    	The inside side (y direction)
    	int sideV = 0;
    	for(int i = 0; i < rowSize - 1; i++) {
    		for(int t = 0; t < colunmSize; t++) {
    			sideV += Math.abs(A.get(i).get(t) - A.get(i + 1).get(t));
    		}
    	}
    	return topBottom + outside + sideH + sideV;
    }

}

public class ThreeDSurfaceArea {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);

        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        IntStream.range(0, H).forEach(i -> {
            try {
                A.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = ResultThreeDSurfaceArea.surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

