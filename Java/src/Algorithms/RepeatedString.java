package Algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class ResultRepeatedString {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
    // Write your code here
    	long aCount = 0;
    	long aFrequency = 0;
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == 'a') {
    			aFrequency++;
    		}
    	}
    	long allS = n / s.length();
    	int rest = (int)(n - s.length() * allS);
    	aCount = (long) (aFrequency * allS);
    	String subS = s.substring(0, rest);
    	for(int i = 0; i < subS.length(); i++) {
    		if(s.charAt(i) == 'a') {
    			aCount++;
    		}
    	}
    	return aCount;
    }

}

public class RepeatedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = ResultRepeatedString.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
