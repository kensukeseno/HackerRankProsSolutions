package Algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class ResultAppendAndDelete {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
    // Write your code here
    	String answer = "No";
//    	if k is equal to or bigger than the sum of length of s and t,
//    	deletion operation is possible and the answer is always yes
    	if(k >= s.length() + t.length()) {
    		answer = "Yes";
    	}
    	else {
//    		Find out how many deletion operation has to be done until s becomes the first part of t.
//    		And count how many letters are needed to be added for s to become t.
//    		If the sum of them is equal to or thes than k and the differenc is even, the anser is yes.
    		int delOpe = 0;
    		while(s.length() > t.length() || !s.equals(t.substring(0, s.length()))) {
    			delOpe++;
    			s = s.substring(0, s.length() - 1);
    		}
    		int appOpe = t.length() - s.length();
    		if(delOpe + appOpe <= k && (k - (delOpe + appOpe)) % 2 == 0) {
    			answer = "Yes";
    		}
    	}
    	return answer;

    }

}

public class AppendAndDelete {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = ResultAppendAndDelete.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
