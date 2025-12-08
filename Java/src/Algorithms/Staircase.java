package Algorithms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ResultStaircase {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
    // Write your code here
    	for(int i = 0; i < n; i++) {
//    		Define how many time to print spaces
    		int space = n - (i + 1);
//    		Define how many times to print #
    		int simbol = i + 1;
    		for(; space > 0; space--) {
    			System.out.print(" ");
    		}
    		for(; simbol > 0; simbol--) {
    			System.out.print("#");
    		}
//    		Start a new line
    		System.out.println("");
    	}

    }

}

public class Staircase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        ResultStaircase.staircase(n);

        bufferedReader.close();
    }
}
