package Algorithms;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class ResultBeautifulDaysAtTheMovies {

    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */

    public static int beautifulDays(int i, int j, int k) {
    // Write your code here
    	int beautDays = 0;
    	while(i != j + 1) {
    		String day = String.valueOf(i);
    		int dayDigit = day.length();
    		int reverse = 0;
    		for(int f = 0 ; f < dayDigit; f++) {
    			reverse += (Integer.parseInt(String.valueOf(day.charAt(f))) * Math.pow(10, f));
    		}
    		if(Math.abs(i - reverse) % k == 0) {
    			beautDays++;
    		}
    		i++;
    	}
    	return beautDays;
    }
}

public class BeautifulDaysAtTheMovies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = ResultBeautifulDaysAtTheMovies.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
