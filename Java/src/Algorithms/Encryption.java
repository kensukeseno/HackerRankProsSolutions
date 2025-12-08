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

class ResultEncryption {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    // Write your code here
    	String sSpaceRemoved = s.replaceAll(" ", "");
    	int len = sSpaceRemoved.length();
    	int row = (int) Math.sqrt(len);
    	int col = row + 1;
    	if(row * row == len) {
    		col = row;
    	}
    	if(row * col < len ) {
    		row = col;
    	}
    	String[] encripted = new String[col];
    	
    	for(int i = 0; i < len; i++) {
    		int pointer = i % col;
    		if(encripted[pointer] == null) {
    			encripted[pointer] = "" + sSpaceRemoved.charAt(i);
    		}else {
    			encripted[pointer] += sSpaceRemoved.charAt(i);
    		}
    	}
    	
    	StringBuilder answer = new StringBuilder();
    	boolean isFrst = true;
    	for(String set: encripted) {
    		if(isFrst) {
    			answer.append(set);
    			isFrst = false;
    		}else {
    			answer.append(" " + set);
    		}
    	}
    	
    	return answer.toString();

    }

}

public class Encryption {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = ResultEncryption.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
