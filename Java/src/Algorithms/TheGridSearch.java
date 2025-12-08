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

class ResultTheGridSearch {

    /*
     * Complete the 'gridSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY G
     *  2. STRING_ARRAY P
     */

    public static String gridSearch(List<String> G, List<String> P) {
    // Write your code here
//    	Transfer G to 2-dimention Integer list
    	List<List<Integer>> newG = new ArrayList<>();
    	for(int i = 0; i < G.size(); i++) {
    		List<Integer> row = new ArrayList<>();
    		for(int h = 0; h < G.get(0).length(); h++) {
    			row.add(Character.getNumericValue(G.get(i).charAt(h)));
    		}
    		newG.add(row);
    	}
//    	Transfer P to 2-dimention Integer list
    	List<List<Integer>> newP = new ArrayList<>();
    	for(int i = 0; i < P.size(); i++) {
    		List<Integer> row = new ArrayList<>();
    		for(int h = 0; h < P.get(0).length(); h++) {
    			row.add(Character.getNumericValue(P.get(i).charAt(h)));
    		}
    		newP.add(row);
    	}
    	System.out.println(newG.get(0).size());
    	System.out.println(newP.get(0).size());
//    	Sweep through newG to find newP
    	boolean match = false;
    	for(int i = 0; i < newG.size() - newP.size() + 1;i++) {
    		for(int h = 0; h < newG.get(0).size() - newP.get(0).size() + 1; h++) {
    			if(match == true) return "YES";
    			loop2: for(int f = 0; f < newP.size(); f++) {
    				for(int k = 0; k < newP.get(0).size(); k++) {
    					if(newG.get(i + f).get(h + k) == newP.get(f).get(k)) {
    						match = true;
    					}else {
    						match = false;
    						break loop2;
    					}
    				}
    			}
    		}
    	}
    	if(match) return "YES";
    	else return "NO";
    }
}

public class TheGridSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int R = Integer.parseInt(firstMultipleInput[0]);

                int C = Integer.parseInt(firstMultipleInput[1]);

                List<String> G = IntStream.range(0, R).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int r = Integer.parseInt(secondMultipleInput[0]);

                int c = Integer.parseInt(secondMultipleInput[1]);

                List<String> P = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = ResultTheGridSearch.gridSearch(G, P);

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
