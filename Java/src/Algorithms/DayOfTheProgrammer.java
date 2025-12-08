package Algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class ResultDayOfTheProgrammer {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
    // Write your code here
//    	Chech if it is a leap year
    	boolean leapY = false;
//    	Calender checher
    	String calendar =  "Gregorian";
    	if(year == 1918) {
    		return 26 + "." + "09" + "." + year;
    	}else if(year >= 1700 && year <= 1917) {
    		calendar = "Julian";
    	}
    	if(calendar.endsWith("Julian")) {
    	   	if(year % 4 == 0) {
        		leapY = true;
        	}
    	}else if(calendar.endsWith("Gregorian")) {
    		if(year % 400 == 0) {
    			leapY = true;
    		}else if(year % 4 == 0 && year % 100 != 0) {
        		leapY = true;
        	}
    	}    	
    	String dd;
    	if(leapY) {
    		dd = "12";
    	}else {
    		dd = "13";
    	}
    	return dd + "." + "09" + "." + year;
    }
}

public class DayOfTheProgrammer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = ResultDayOfTheProgrammer.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
