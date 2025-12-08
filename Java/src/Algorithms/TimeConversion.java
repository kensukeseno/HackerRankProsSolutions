package Algorithms;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class ResultTimeConversion {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
    	String simbol = s.substring(8, 10);
    	String mTime = s.substring(0, 8);
    	
    	
    	if(simbol.equals("PM")) {
        	int hh = Integer.parseInt(s.substring(0, 2));
        	if(hh != 12) hh += 12;
        	mTime = s.replaceFirst("[0-9][0-9]", String.valueOf(hh)).substring(0, 8);
    	}else if (simbol.equals("AM")) {
    		if(s.substring(0, 2).equals("12"))
    			mTime = mTime.replaceFirst("[0-9][0-9]", "00");
    	}
    	
    	return mTime;
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = ResultTimeConversion.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
