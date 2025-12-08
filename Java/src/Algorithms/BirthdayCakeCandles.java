package Algorithms;
import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class ResultBirthdayCakeCandles {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
    // Write your code here
//    	##runtime ends up too long when useing sorted() meathod
//    	List<Integer> sortedCandles = candles.stream().sorted().collect(Collectors.toList());
//    	int count = 1;
//    	int arrSize = candles.size();
//    	Boolean flag = true;
//    	while(flag) {
//    		if(sortedCandles.get(arrSize - count).equals(sortedCandles.get(arrSize - count - 1))) {
//    			count++;
//    		}else{
//    			flag = false;
//    		}	
//    	}
//    	return count;
    	
    	int arrSize = candles.size();
//    	Prepare a counter to count the number of the tallest candels
    	int count = 1;
//    	Prepare a variable to store the tallest value
    	int tallest = 0;

//    	Check every num
    	for(int i = 0; i < arrSize; i++) {
    		if(candles.get(i) > tallest) {
    			tallest = candles.get(i);
    			count = 1;
    		}
    		else if(candles.get(i).equals(tallest)) {
  			count++;
    		}
    	}
    	return count;
    }

}

public class BirthdayCakeCandles {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = ResultBirthdayCakeCandles.birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
