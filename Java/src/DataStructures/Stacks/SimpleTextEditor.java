package DataStructures.Stacks;

import java.io.*;
import java.util.*;


class ResultSimpleTextEditor{
	
	public static void simpleTextEdit(List<String> operations) {
			Stack<String> stack = new Stack<>();
			String s = new String();
			
			for(int i = 0; i < operations.size(); i++) {
				int type = Character.getNumericValue(operations.get(i).charAt(0));
				switch (type) {
				case 1: {
					stack.push(s);
					s = s + operations.get(i).substring(2, operations.get(i).length());
					break;
				}
				case 2: {
					stack.push(s);
					s = s.substring(0, s.length() - Integer.parseInt(operations.get(i).substring(2, operations.get(i).length())));
					break;
				}
				case 3: {
					System.out.println(s.charAt(Integer.parseInt(operations.get(i).substring(2, operations.get(i).length())) - 1));
					break;
				}
				case 4: {
					s = stack.pop();
				}
			}
		}
	}
}

public class SimpleTextEditor {

    public static void main(String[] args) throws NumberFormatException, IOException  {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	
    	int q = Integer.parseInt(bufferedReader.readLine());
    	List<String> operations = new ArrayList<>();
    	
    	for(int i = 0; i < q; i++) {
    		operations.add(bufferedReader.readLine());
    	}
    	
    	ResultSimpleTextEditor.simpleTextEdit(operations);
    	
    }
}