package Algorithms;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class ResultClimbingTheLeaderboard {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
//    	Suppose player's score gets higher each game
//    	Compare ranked player's score from the top of ranked-list with players scores from the last game
    	
    	List<Integer> ranking = new ArrayList<>();
    	int gameNum = player.size();
    	int rank = 1;
    	int preRankedScore = ranked.get(0);
    	
    	a:for(int rankedScore: ranked) {
    		if(preRankedScore != rankedScore ) {
    			rank++;
    		}
    		int i = 0;
    		while(player.get(gameNum- 1) >= rankedScore) {
    			ranking.add(0, rank);
    			gameNum--;
    			if(gameNum == 0) {
    				break a;
    			}
    			i++;
    		}
			preRankedScore = rankedScore;
    	}
    	
    	if(ranking.size() < player.size()) {
    		rank++;
    		while( ranking.size() - player.size() < 0) {
    			ranking.add(0, rank);
    		}
    	}
    	return ranking;
    }

}

public class ClimbingTheLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = ResultClimbingTheLeaderboard.climbingLeaderboard(ranked, player);

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
