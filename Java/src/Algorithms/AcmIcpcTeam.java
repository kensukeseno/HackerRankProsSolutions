package Algorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultAcmIcpcTeam {

    /*
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
    // Write your code here
    	int subjectsLen = topic.get(0).length();
    	int teamNum = topic.size();
    	int[] numOfKnowenCounter = new int[subjectsLen];
    	
    	for(int i = 0; i < teamNum; i++) {
    		for(int c = 1; c < teamNum - i; c++) {
    			int knowenCounter = 0;
    			for(int t = 0; t < subjectsLen; t++) {
    				if(topic.get(i).charAt(t) == '1' || topic.get(i + c).charAt(t) == '1') {
    					knowenCounter++;
    				}
    			}
    			numOfKnowenCounter[knowenCounter - 1]++;
    		}
    	}
    	List<Integer> answer = new ArrayList<>();
    	for(int i = 0; i < subjectsLen; i++) {
    		if(numOfKnowenCounter[subjectsLen - i - 1] != 0) {
    			answer.add(subjectsLen - i);
    			answer.add(numOfKnowenCounter[subjectsLen - i - 1]);
    			break;
    		}
    	}
    	return answer;
    }

}

public class AcmIcpcTeam {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = ResultAcmIcpcTeam.acmTeam(topic);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
