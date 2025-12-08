package Algorithms;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class ResultCountingValleys {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here
//    	Convert each letter of path into -1 or 1 (D -> -1, U -> 1).
//    	By adding converted numbers, everytime the sum (represents altitude) becomese 0 from negatice, add 1 to valley counter.
    	int altitude = 0;
    	int valleyCount = 0;
    	boolean isValley = false;
    	
    	for(int i = 0; i < steps; i++) {
    		char uOrD = path.charAt(i);
    		if(uOrD == 'U') {
    			altitude += 1;
    		}else {
    			altitude -= 1;
    		}
    		if(!isValley && altitude == -1) {
    			isValley = true;
    		}
    		if(altitude == 0) {
    			if(isValley) {
    				valleyCount += 1;
    				isValley = false;
    			}
    		}
    	}
    	return valleyCount;
    }

}

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = ResultCountingValleys.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
