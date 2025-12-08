package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class ResultExtraLongFactorials {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
    // Write your code here
    	BigInteger product = BigInteger.valueOf(1);
    	
    	while(n > 0) {
    		product = product.multiply(BigInteger.valueOf(n));
    		n--;
    	}
    	System.out.println(product);
    }
}

public class ExtraLongFactorials {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        ResultExtraLongFactorials.extraLongFactorials(n);

        bufferedReader.close();
    }
}
