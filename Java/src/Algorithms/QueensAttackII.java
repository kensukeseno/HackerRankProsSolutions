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

class ResultQueensAttackII {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
    // Write your code here
    /*
     * Logic2	
     * In each of 8 directions, find how far the queen can hit without hitting an obstacle.
     */
    	int topL = n - r_q < c_q - 1 ? n - r_q : c_q - 1;
    	int top = n - r_q;
    	int topR = n - r_q < n - c_q ? n - r_q : n - c_q;
    	int left = c_q - 1;
    	int right = n - c_q;
    	int btmL = r_q - 1 < c_q - 1 ? r_q - 1 : c_q - 1;
    	int btm = r_q - 1;
    	int btmR = r_q - 1 < n - c_q ? r_q - 1 : n - c_q;
    	
    	for(List<Integer> obstable : obstacles) {
    		if(obstable.get(0) - r_q > 0 && obstable.get(0) - r_q == c_q - obstable.get(1)) {
    			if(topL > obstable.get(0) - r_q - 1) {
    				topL = obstable.get(0) - r_q - 1;
    			}
    		}
    		if(obstable.get(0) - r_q > 0 && c_q == obstable.get(1)) {
    			if(top > obstable.get(0) - r_q - 1) {
    				top = obstable.get(0) - r_q - 1;
    			}
    		}
    		if(obstable.get(0) - r_q > 0 && obstable.get(0) - r_q == obstable.get(1) - c_q) {
    			if(topR > obstable.get(0) - r_q - 1) {
    				topR = obstable.get(0) - r_q - 1;
    			}
    		}
    		if(r_q == obstable.get(0) && c_q > obstable.get(1)) {
    			if(left > c_q - obstable.get(1) - 1) {
    				left = c_q - obstable.get(1) - 1;
    			}
    		}
    		if(r_q == obstable.get(0) && c_q < obstable.get(1)) {
    			if(right > obstable.get(1) - c_q  - 1) {
    				right = obstable.get(1) - c_q  - 1;
    			}
    		}
    		if(r_q - obstable.get(0) > 0 && r_q - obstable.get(0) == c_q - obstable.get(1)) {
    			if(btmL > r_q - obstable.get(0) - 1) {
    				btmL = r_q - obstable.get(0) - 1;
    			}
    		}
    		if(c_q == obstable.get(1) && r_q - obstable.get(0) > 0) {
    			if(btm > r_q - obstable.get(0) -1) {
    				btm = r_q - obstable.get(0) -1;
    			}
    		}
    		if(r_q - obstable.get(0)> 0 && r_q - obstable.get(0) == obstable.get(1) - c_q) {
    			if(btmR > r_q - obstable.get(0) - 1) {
    				btmR = r_q - obstable.get(0) - 1;
    			}
    		}
    	}
    	
    	return topL +top  +topR +left +right +btmL  +btm  +btmR;
    }
    	
//    /*
//     * Logic 1 (Runtime fail & Wrong answer in some test cases)
//     * Group squares that are in eight directions in 8 categories.
//     * In each group, squares are lined in order of the distance from the queen
//     * If obstacle is in a position of squares above, remove that square and the ones further from it from the group.
//     */
//    	List<List<Integer>> topL = new ArrayList<>();
//    	List<List<Integer>> top = new ArrayList<>();
//    	List<List<Integer>> topR = new ArrayList<>();
//    	List<List<Integer>> left = new ArrayList<>();
//    	List<List<Integer>> right = new ArrayList<>();
//    	List<List<Integer>> btmL = new ArrayList<>();
//    	List<List<Integer>> btm = new ArrayList<>();
//    	List<List<Integer>> btmR = new ArrayList<>();
// 	
//    	int count1 = 1;
//    	while(r_q + count1 <= n && c_q - count1 >= 1) {
//    		topL.add(List.of(r_q + count1, c_q - count1));
//    		count1++;
//    	}
//    	int count2 = 1;
//    	while(r_q + count2 <= n) {
//    		top.add(List.of(r_q + count2, c_q));
//    		count2++;
//    	}
//    	int count3 = 1;
//    	while(r_q + count3 <= n && c_q + count3 <= n) {
//    		topR.add(List.of(r_q + count3, c_q + count3));
//    		count3++;
//    	}
//    	int count4 = 1;
//    	while(c_q - count4 >= 1) {
//    		left.add(List.of(r_q, c_q - count4));
//    		count4++;
//    	}
//    	int count5 = 1;
//    	while(c_q + count5 <= n) {
//    		right.add(List.of(r_q, c_q + count5));
//    		count5++;
//    	}
//    	int count6 = 1;
//    	while(r_q - count6 >= 1 && c_q - count6 >= 1) {
//    		btmL.add(List.of(r_q - count6, c_q - count6));
//    		count6++;
//    	}
//    	int count7 = 1;
//    	while(r_q - count7 >= 1) {
//    		btm.add(List.of(r_q - count7, c_q));
//    		count7++;
//    	}
//    	int count8 = 1;
//    	while(r_q - count8 >= 1 && c_q + count8 <= n) {
//    		btmR.add(List.of(r_q - count8, c_q + count8));
//    		count8++;
//    	}
//    	
//    	System.out.println(topL.size() + top.size() + topR.size() + left.size() + right.size() + btmL.size() + btm.size() + btmR.size());
//    	
//    	topL = deadPassFinder(topL, k, obstacles);
//    	top = deadPassFinder(top, k, obstacles);
//    	topR = deadPassFinder(topR, k, obstacles);
//    	left = deadPassFinder(left, k, obstacles);
//    	right = deadPassFinder(right, k, obstacles);
//    	btmL = deadPassFinder(btmL, k, obstacles);
//    	btm = deadPassFinder(btm, k, obstacles);
//    	btmR = deadPassFinder(btmR, k, obstacles);
//    	
//    	return topL.size() + top.size() + topR.size() + left.size() + right.size() + btmL.size() + btm.size() + btmR.size();
//    }
//    
//    public static List<List<Integer>> deadPassFinder(List<List<Integer>> pass, int k, List<List<Integer>> obstacles){
//    	for(int i = 0; i < k; i++) {
//    		for(int t = 0; t < pass.size(); t++) {
//    			if(obstacles.get(i).get(0) == pass.get(t).get(0) && obstacles.get(i).get(1) == pass.get(t).get(1)) {
//    				pass = pass.subList(0, t);
//    				break;
//    			}
//    		}
//    	}
//    	return pass;
//    }
}

public class QueensAttackII {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = ResultQueensAttackII.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
