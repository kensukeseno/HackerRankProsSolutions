package Algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultTheTimeInWords {

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
    // Write your code here
    	
//    	Convert m to string
    	Map<Integer, String> converter = new HashMap<>();
    	converter.put(1,"one");
    	converter.put(2,"two");
    	converter.put(3,"three");
    	converter.put(4,"four");
    	converter.put(5,"five");
    	converter.put(6,"six");
    	converter.put(7,"seven");
    	converter.put(8,"eight");
    	converter.put(9,"nine");
    	converter.put(10,"ten");
    	converter.put(11,"eleven");
    	converter.put(12,"twelve");
    	converter.put(13,"thirteen");
    	converter.put(14,"fourteen");
    	converter.put(15,"fifteen");
    	converter.put(16,"sixteen");
    	converter.put(17,"seventeen");
    	converter.put(18,"eighteen");
    	converter.put(19,"nineteen");
    	converter.put(20,"twenty");
    	converter.put(21,"twenty one");
    	converter.put(22,"twenty two");
    	converter.put(23,"twenty three");
    	converter.put(24,"twenty four");
    	converter.put(25,"twenty five");
    	converter.put(26,"twenty six");
    	converter.put(27,"twenty seven");
    	converter.put(28,"twenty eight");
    	converter.put(29,"twenty nine");
    	converter.put(30,"thirty");
 
    	String hour = "";
    	int absMin = Math.abs(60 - m);
    	
    	if(m >= 00 && m <= 30) {
//        	Convert numeral to         	
    		if(h == 1) {
        		hour = "one";
        	}else if(h == 2) {
        		hour = "two";
        	}else if(h == 3) {
        		hour = "three";
        	}else if(h == 4) {
        		hour = "four";
        	}else if(h == 5) {
        		hour = "five";
        	}else if(h == 6) {
        		hour = "six";
        	}else if(h == 7) {
        		hour = "seven";
        	}else if(h == 8) {
        		hour = "eight";
        	}else if(h == 9) {
        		hour = "nine";
        	}else if(h == 10) {
        		hour = "ten";
        	}else if(h == 11) {
        		hour = "eleven";
        	}
    		if(m == 00) {
        		return hour + " o' clock";
    		}else if(m == 15) {
        		return "quarter past " + hour;
    		}else if(m == 30) {
        		return "half past " + hour;
        	}else if(m == 1){
        		return "one minute past " + hour;
        	}else {
        		return converter.get(m) + " minutes past " + hour;
        	}
    	}else{
//        	Convert numeral to         	
        	if(h == 1) {
        		hour = "two";
        	}else if(h == 2) {
        		hour = "three";
        	}else if(h == 3) {
        		hour = "four";
        	}else if(h == 4) {
        		hour = "five";
        	}else if(h == 5) {
        		hour = "six";
        	}else if(h == 6) {
        		hour = "seven";
        	}else if(h == 7) {
        		hour = "eight";
        	}else if(h == 8) {
        		hour = "nine";
        	}else if(h == 9) {
        		hour = "ten";
        	}else if(h == 10) {
        		hour = "eleven";
        	}else if(h == 11) {
        		hour = "twelve";
        	}
    		if(absMin == 15) {
    			return "quarter to " + hour;
    		}else if(absMin == 1){
    			return "one minute to " + hour;
    		}else {
    			return converter.get(absMin) + " minutes to " + hour;
    		}
    	}
    }
}

public class TheTimeInWords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = ResultTheTimeInWords.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
