package Algorithms;
import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class ResultPlusMinus {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

	static int pos = 0;
	static int neg = 0;
	static int zero = 0;
	
    public static void plusMinus(List<Integer> arr) {
    // Write your code here
//    	Get the length of the array
    	int num = arr.size();
    	
//    	Count the numbers of positive and negative numbers and zero
    	arr.forEach(para -> {if(para > 0) pos++; if(para < 0) neg++; if(para == 0) zero++;});
    	
//    	Calculate each ratio
    	double posRatio = (double)pos / num;
    	System.out.println(String.format("%.6f", posRatio));
    	double negRatio = (double)neg / num;
    	System.out.println(String.format("%.6f", negRatio));
    	double zeroRatio = (double)zero / num;
    	System.out.println(String.format("%.6f", zeroRatio));
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        ResultPlusMinus.plusMinus(arr);

        bufferedReader.close();
    }
}
