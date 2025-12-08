package Algorithms;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class ResultBetweenTwoSets {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts the following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
////    	Strategy 1 (without seeing editorial, failed)
////    	Steps
////    	1. Find numbers between two arrays that can divide an integer on the second array
////    	2. Among the numbers, find numbers that can be divided only with integers on the first array
//
//    	List<Integer> sortedA = a.stream().sorted(Comparator.reverseOrder()).toList();
//    	List<Integer> sortedB = b.stream().sorted().toList();
//    	
////    	Step 1
//    	List<Integer> factorNumList = new ArrayList<>();
//    	for(int i = sortedA.get(0); i <= sortedB.get(0); i++) {
//    		boolean isFactor = true;
//    		for(int k = 0; k < sortedB.size(); k++) {
//    			if(!(sortedB.get(k) % i == 0)) {
//    				isFactor = false;
//    				break;
//    			}
//    		}
//    		if(isFactor) {
//    			factorNumList.add(i);
//    		}
//    	}
//    	
//    	    	
////    	Step 2
//    	List<Integer> divisableNumList = factorNumList.stream().filter(factorNums -> {
//    		boolean isDividable = true;
//    		int currentNum = factorNums;
//    		divisableEvaluate:
//    		while(true) {
//    			for(int i = 0; i < sortedA.size(); i++) {
//    				if(currentNum %  sortedA.get(i) == 0) {
//    					currentNum = currentNum /  sortedA.get(i);
//    					if(currentNum == 1) {
//    	    				break divisableEvaluate;
//    	    			}
//    					continue divisableEvaluate;
//    				}
//    			}
//    			isDividable = false;
//    			break divisableEvaluate;
//    		}
//    		
//    		return isDividable;
//    		} ) .collect(Collectors.toList());
//    	System.out.println(divisableNumList.size());
//    	return divisableNumList.size();

//		Strategy 2 (after seeing editorial)
//    	Steps
//    	1. Find the least common multiple (LCM) of integers in array a
//    	2. Find the greatest common divisor (GCD) of integers in array b
//    	3. Denote integers that satisfy conditions as x,
//    	   LCM above is a factor of x and x can evenly divide GCM above.
//    	   Find x. The answer is the number of x.
    	
//    	step 1
    	int lcm = a.get(0);
    	for(int i = 0; i < a.size() - 1; i++) {
    		int input1 = lcm;
    		int input2 = a.get(i + 1);
    		lcm = lcmFinder(input1, input2);
    	}
    	
//    	step 2
    	int gcd = b.get(0);
    	for(int i = 0; i < b.size() - 1; i++) {
    		int input1 = gcd;
    		int input2 = b.get(i + 1);
    		gcd = gcdFinder(input1, input2);
    	}

//    	step 3
    	List<Integer> ansNumList = new ArrayList<>();
    	int multiplier = 1;
    	while(lcm * multiplier <= gcd ) {
    		if(gcd % (lcm * multiplier) == 0) {
    			ansNumList.
    			add(lcm * multiplier);
    		}
    		multiplier++;
    	}
    	System.out.println(lcm + "" + gcd);
    	return ansNumList.size();
    }
    
    public static int lcmFinder(int num1, int num2) {
    	int sm = num1;
    	int bg = num2;
    	if(num1 > num2 ) {
    		sm = num2;
        	bg = num1;
    	}
    	int lcm = bg;
    	
    	boolean lcmFound = false;
    	while(!lcmFound) {
    		if(lcm % sm == 0) {
    			lcmFound = true;
    		}else {
    			lcm += bg;
    		}
    	}
    	return lcm;
    }
    
    public static int gcdFinder(int num1, int num2) {
    	int sm = num1;
    	int bg = num2;
    	if(num1 > num2 ) {
    		sm = num2;
        	bg = num1;
    	}
    	int gcd = sm;
    	
    	boolean gcdFound = false;
    	int divisor = 1;
    	while(!gcdFound) {
    		if((double)bg % ((double)gcd / divisor)== 0) {
    			gcdFound = true;
    			gcd = gcd / divisor;
    		}else {
    			divisor++;
    		}
    	}
    	return gcd;
    }
}

public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = ResultBetweenTwoSets.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
