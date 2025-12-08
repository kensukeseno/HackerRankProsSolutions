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

class ResultBiggerIsGreater {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
    // Write your code here
//    	Assign numbers to alphabets
    	Map<Character, Integer> charToInt = new HashMap<>();
    	charToInt.put('a', 1);
    	charToInt.put('b', 2);
    	charToInt.put('c', 3);
    	charToInt.put('d', 4);
    	charToInt.put('e', 5);
    	charToInt.put('f', 6);
    	charToInt.put('g', 7);
    	charToInt.put('h', 8);
    	charToInt.put('i', 9);
    	charToInt.put('j', 10);
    	charToInt.put('k', 11);
    	charToInt.put('l', 12);
    	charToInt.put('m', 13);
    	charToInt.put('n', 14);
    	charToInt.put('o', 15);
    	charToInt.put('p', 16);
    	charToInt.put('q', 17);
    	charToInt.put('r', 18);
    	charToInt.put('s', 19);
    	charToInt.put('t', 20);
    	charToInt.put('u', 21);
    	charToInt.put('v', 22);
    	charToInt.put('w', 23);
    	charToInt.put('x', 24);
    	charToInt.put('y', 25);
    	charToInt.put('z', 26);
    	
    	Map<Integer, Character> intToChar = new HashMap<>();
    	intToChar.put(1, 'a');
    	intToChar.put(2, 'b');
    	intToChar.put(3, 'c');
    	intToChar.put(4, 'd');
    	intToChar.put(5, 'e');
    	intToChar.put(6, 'f');
    	intToChar.put(7, 'g');
    	intToChar.put(8, 'h');
    	intToChar.put(9, 'i');
    	intToChar.put(10, 'j');
    	intToChar.put(11, 'k');
    	intToChar.put(12, 'l');
    	intToChar.put(13, 'm');
    	intToChar.put(14, 'n');
    	intToChar.put(15, 'o');
    	intToChar.put(16, 'p');
    	intToChar.put(17, 'q');
    	intToChar.put(18, 'r');
    	intToChar.put(19, 's');
    	intToChar.put(20, 't');
    	intToChar.put(21, 'u');
    	intToChar.put(22, 'v');
    	intToChar.put(23, 'w');
    	intToChar.put(24, 'x');
    	intToChar.put(25, 'y');
    	intToChar.put(26, 'z');

 
    	boolean noAns = true;
/*    	
 		First, by scanning a word backword, 
    	find a first character that is lexicographically smaller 
    	than the one before the charactor
 */  	
    	int fPos = 0;
    	char pChar = w.charAt(w.length() - 1);
    	for(int i = 1; i < w.length(); i++) {
    		char cChar = w.charAt(w.length() - i -1);
    		if(charToInt.get(pChar) > charToInt.get(cChar)) {
    			fPos = w.length() - i;
    			noAns = false;
    			break;
    		}
    		pChar = cChar;
    	}
    	

    	if(!noAns) {
    		/*
    		 Decide the character that comes at fPos
    		 */
//    		Put all characters that comes and after fPos in array
    		List<Integer> charInInt = new ArrayList<>();
    		for(int i = 1; i < w.length() - (fPos - 1); i++) {
    			charInInt.add(charToInt.get(w.charAt(fPos- 1 + i)));
    		}
    		Collections.sort(charInInt);
    		int replacingCharInInt = 0;
    		int replacingCharPos = 0;
    		for(int i = 0; i < charInInt.size(); i++) {
    			if(charInInt.get(i) > charToInt.get(w.charAt(fPos- 1))) {
    				replacingCharInInt = charInInt.get(i);
    				replacingCharPos = i;
    				break;
    			}
    		}
//    		In the array, replace character found above and character at fPos
    		charInInt.set(replacingCharPos, charToInt.get(w.charAt(fPos- 1)));
    		Collections.sort(charInInt);
//    		Put everything together
    		StringBuilder sb = new StringBuilder();
    		sb.append(w.substring(0, fPos - 1));
    		sb.append(intToChar.get(replacingCharInInt));
    		for(int i = 0; i < charInInt.size(); i++) {
    			sb.append(intToChar.get(charInInt.get(i)));
    		}
    		return sb.toString();
    	}else {
    		return "no answer";
    	}
    }
}

public class BiggerIsGreater {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = ResultBiggerIsGreater.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
