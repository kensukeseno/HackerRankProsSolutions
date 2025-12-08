package DataStructures.Trees;

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

class ResultBalancedForest {

    /*
     * Complete the 'balancedForest' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY c
     *  2. 2D_INTEGER_ARRAY edges
     */

    public static int balancedForest(List<Integer> c, List<List<Integer>> edges) {
    // Write your code here
    	/*
    	 * There are only three edges to be potentially cut.
    	 * Calculate each sum of three tree created by cutting the edges connecting to root.
    	 * Cut 2 of them in 3 ways.
    	 */

//    	Three trees without root
    	List<Integer> lftTree = new ArrayList<>();
    	List<Integer> mdlTree = new ArrayList<>();
    	List<Integer> rgtTree = new ArrayList<>();
//    	Sorting edges depending which tree they belong
    	List<List<Integer>> lftEdges = new ArrayList<>();
    	List<List<Integer>> mdlEdges = new ArrayList<>();
    	List<List<Integer>> rgtEdges = new ArrayList<>();
    	
    	for(int i = 0; i < edges.size(); i++) {
    		int root = edges.get(i).get(0);
    		if(root == 1) {
    			if(lftEdges.isEmpty()) {
    				lftEdges.add(edges.get(i));
    				lftTree.add(c.get(i + 1));
    			}else if(mdlEdges.isEmpty()) {
    				mdlEdges.add(edges.get(i));
        			mdlTree.add(c.get(i + 1));
    			}else{
    				rgtEdges.add(edges.get(i));
        			rgtTree.add(c.get(i + 1));
    			}
    		}else {
    			if(!lftEdges.isEmpty() && lftEdges.get(lftEdges.size() - 1).get(1) == root) {
    				lftEdges.add(edges.get(i));
    				lftTree.add(c.get(i + 1));
    			}else if(!mdlEdges.isEmpty() && mdlEdges.get(mdlEdges.size() - 1).get(1) == root) {
    				mdlEdges.add(edges.get(i));
    				mdlTree.add(c.get(i + 1));
    			}else if(!rgtEdges.isEmpty() && rgtEdges.get(rgtEdges.size() - 1).get(1) == root) {
    				rgtTree.add(c.get(i + 1));
    			}
    		}
    	}
    	
//    	Calculate sums of each tree
    	int lftTreeSum = lftTree.stream().mapToInt(Integer::intValue).sum();
    	int mdlTreeSum = mdlTree.stream().mapToInt(Integer::intValue).sum();
    	int rgtTreeSum = rgtTree.stream().mapToInt(Integer::intValue).sum();
    	
//    	Try three potential ways to cut trees. Track the minimal data to insert.
    	int minimal = -1;
    	if(balancedTreeChecker(c.get(0), lftTreeSum, mdlTreeSum, rgtTreeSum) != -1) {
    		minimal = balancedTreeChecker(c.get(0), lftTreeSum, mdlTreeSum, rgtTreeSum);
    	}
    	if(balancedTreeChecker(c.get(0), mdlTreeSum, lftTreeSum, rgtTreeSum) != -1) {
    		if(minimal == -1 || (minimal != -1 && minimal > balancedTreeChecker(c.get(0), mdlTreeSum, lftTreeSum, rgtTreeSum))) {
    			minimal = balancedTreeChecker(c.get(0), mdlTreeSum, lftTreeSum, rgtTreeSum);
    		}
    	}
    	if(balancedTreeChecker(c.get(0), rgtTreeSum, lftTreeSum, mdlTreeSum) != -1) {
    		if(minimal == -1 || (minimal != -1 && minimal > balancedTreeChecker(c.get(0), rgtTreeSum, lftTreeSum, mdlTreeSum))) {
    			minimal = balancedTreeChecker(c.get(0), rgtTreeSum, lftTreeSum, mdlTreeSum);
    		}
    	}
    	return minimal;
    }
    
    static int balancedTreeChecker(int root, int sum1, int sum2, int sum3) {
    	int minimal = -1;
    	if(sum1 + root == sum2) {
    		if(sum1 + root >= sum3) {
    			minimal = sum1 + root - sum3;
    		}
    	}else if (sum2 == sum3) {
    		if(sum2 >= sum1 + root) {
    			minimal = sum2 - (sum1 + root);
    		}
    	}else if(sum1 + root == sum3){
    		if(sum1 + root >= sum2) {
    			minimal = sum1 + root - sum2;
    		}
    	}  	
    	return minimal;
    }

}

public class BalancedForestUnsolved {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, n - 1).forEach(i -> {
                    try {
                        edges.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = ResultBalancedForest.balancedForest(c, edges);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
