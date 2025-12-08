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

class ResultTheBombermanGame {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
    // Write your code here
    	/*
    	 * Every 2s second, the field is filled by bombs.
    	 * Bombs positions at (2s + 1) is determined by the bomb positions at (2s -1).
    	 * It is easier to denote bombs positions by odd and even numbers.
    	 */
    	
//    	Every 2s second
    	if(n % 2 == 0) {
    		List<String> full = new ArrayList<>();
    		StringBuilder sb = new StringBuilder();
    		for(int i = 0; i < grid.get(0).length(); i++) {
    			sb.append(".");
    		}
    		String line = sb.toString();
    		for(int i = 0; i < grid.size(); i++) {
    			full.add(line);
    		}
    		return full;
    	}
//    	Every (2s + 1) seconds
    	else {
//    		Convert initial list to 0 and 1
    		int[][] converted = new int[grid.size()][grid.get(0).length()];
    		for(int i = 0; i < grid.size(); i++) {
    			int[] line = new int[grid.get(0).length()];
    			for(int t = 0; t < grid.get(0).length(); t++) {
    				if(grid.get(i).charAt(t) == '.') {
    					line[t] = 0;
    				}else {
    					line[t] = 1;
    				}
    			}
    			converted[i] = line;
    		}
//    		Repeat operations below every (2s + 1) seconds
    		for(int i = 0; i < (n + 1) / 2; i++) {
        		int[][] nextFiled = new int[grid.size()][grid.get(0).length()];
        		for(int t = 0; t < converted.length; t++) {
        			for(int d = 0; d < converted[0].length; d++ ) {
        				if(converted[t][d] == 1) {
        					if(true) {
        						
        					}
        				}
        			}
        		}
    		}
    	
    	}
    	
    	
    	
    	
    	return new ArrayList<>();
    }

}

public class TheBombermanGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = ResultTheBombermanGame.bomberMan(n, grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
