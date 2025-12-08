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

class ResultModifiedKaprekarNumbers {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
    // Write your code here
    	List<Integer> answers = new ArrayList<>();
    	
    	for(int n = p; n <= q; n++) {
    		long n2 = (long)n * n;
    		String nString = String.valueOf(n);
    		String n2String = String.valueOf(n2);
    		int d = nString.length();
    		int d2 = n2String.length();
    		int s1 = d == d2 ? 0 : Integer.parseInt(n2String.substring(0, d2 - d));
    		int s2 = Integer.parseInt(n2String.substring(d2 - d, d2));
    		int sum = s1 + s2;
    		if(sum == n) {
    			answers.add(n);
    		}
    	}
    	if(answers.isEmpty()) {
    		System.out.println("INVALID RANGE");
    	}else {
    		boolean isFrst = true;
        	for(int answer: answers){
        		if(isFrst) {
        			System.out.print(answer);
        			isFrst = false;
        		}else {
        			System.out.print(" " + answer);
        		}
        	}
    	}
    }
}

public class ModifiedKaprekarNumbers {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        ResultModifiedKaprekarNumbers.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
