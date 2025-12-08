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

class ResultAbsolutePermutation {

    /*
     * Complete the 'absolutePermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */

    public static List<Integer> absolutePermutation(int n, int k) {
    // Write your code here
    	List<Integer> ans = new ArrayList<>();
    //		Make a list of available values of permutation
    	List<Integer> unusedNums = new ArrayList<>();
    	for(int i = 1; i <= n; i++ ) {
    		unusedNums.add(i);
    	}
    	
    	for(int i = 0; i < n; i++) {
//    		Case1: the smaller value is available
        	if(i + 1 - k >= 1 && unusedNums.get(i - k) != 0) {
    			unusedNums.set(i - k, 0);
    			ans.add(i, i + 1 - k);
//    		Casse2: the bigger value is available    
    		}else if(i + 1 + k <= n && unusedNums.get(i + k) != 0) {
    			unusedNums.set(i + k, 0);
    			ans.add(i, i + 1 + k);
    		}
//    		Case3: there is no number available
    		else {
//    		There is none	
    			return List.of(-1);
    		}
    	}
    	return ans;
    }

    	
//    	Answer1 (ended up stackoverflow)
//    	/*
//    	 * A value at each position has potentially two permutation values 
//    	 * to make k value.
//    	 * Try each value from smaller one if it is an available value.
//    	 */
//    	List<Integer> ans = new ArrayList<>();
////    	Make a list of available values of permutation
//    	List<Integer> unusedNums = new ArrayList<>();
//    	for(int i = 1; i <= n; i++ ) {
//    		unusedNums.add(i);
//    	}
//    	return permutaionFinder(k, n, unusedNums,1, ans);
//    }
    /*  
     * input1: k
     * input2: n
     * input3: available numbers list
     * input4: repetition number
     * input5: answer list
     * return: boolean
     * This function is to decide if there is available number in a given list
    */
//    public static List<Integer> permutaionFinder(int k, int n, List<Integer> unusedNums, int rep, List<Integer> ans) {
//
////		Case1: the smaller value is available
//    	if(rep < n + 1 && rep - k >= 1 && unusedNums.get(rep - k - 1) != 0) {
//			unusedNums.set(rep - k - 1, 0);
//			ans.add(rep - 1, rep - k);
//			permutaionFinder(k, n, unusedNums,rep + 1, ans);
////		Casse2: the bigger value is available    
//		}else if(rep + k <= n && unusedNums.get(rep + k - 1) != 0) {
//			unusedNums.set(rep + k - 1, 0);
//			ans.add(rep - 1, rep + k);
//			permutaionFinder(k, n, unusedNums,rep + 1, ans);
//		}
////		Case3: there is no number available
////			List of permutation numbers is complete
//		if(ans.size() == n) {
//			return ans;
//		}else {
////		There is none	
//			return List.of(-1);
//		}
//    }

}

public class AbsolutePermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> result = ResultAbsolutePermutation.absolutePermutation(n, k);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
