package DataStructures.DisjointSet;

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

class ResultComponentsInAGraph {

    /*
     * Complete the 'componentsInGraph' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY gb as parameter.
     */
	static boolean[] visited;
	static int[] nodeNum;
	
	static void DFS(int root,List<List<Integer>> gb ) {
		if(visited[root] == false) {
//        	Create a variable to store adjacent node.
        	List<Integer> visitedNodes = new ArrayList<>();
        	visitedNodes.add(root + 1);
//        	Create a variable to define visited/unvisited nodes.
        	visited[root] = true;
//        	Create a variable to store nodes connected to visited node.
        	Stack<Integer> adj = new Stack<>();
        	
        	for(int t = 0; t < gb.size(); t++) {
        		if(gb.get(t).get(0) == root + 1 && visited[gb.get(t).get(1) - 1] == false) {
        			adj.add(gb.get(t).get(1));
        			visited[gb.get(t).get(1) - 1] = true;
        		}
        	}
        	while(!adj.isEmpty()) {
        		int subRoot = adj.peek();
        		visitedNodes.add(adj.pop());
        		for(int t = 0; t < gb.size(); t++) {
            		if(gb.get(t).get(0) == subRoot && visited[gb.get(t).get(1) - 1] == false) {
            			adj.add(gb.get(t).get(1));
            			visited[gb.get(t).get(1) - 1] = true;
            		}
            		if(gb.get(t).get(1) == subRoot && visited[gb.get(t).get(0) - 1] == false) {
            			adj.add(gb.get(t).get(0));
            			visited[gb.get(t).get(0) - 1] = true;
            		}
            	}
        	}
        	nodeNum[root] = visitedNodes.size();
		}
	}
	
    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
    // Write your code here

    	/*
    	 * Apply DFS algorithm
    	 */
    	
//    	Find N value;
    	int max = 0;
    	for(int i = 0; i < gb.size(); i++) {
    		if(gb.get(i).get(1) > max) {
    			max = gb.get(i).get(1);
    		}
    	}
    	int N = max % 2 == 0 ? max / 2 : max / 2 + 1;

//    	Set a root node to every node between 1 and N.
//    	But, skip the node if it is already touched on.
    	nodeNum = new int[N];
    	visited = new boolean[max];
    	for(int i = 0; i < N; i++) {
    		DFS(i, gb);
    	}

    	int largest = 0;
    	int smallest = max;
    	for(int i = 0; i < N; i++) {
    		if(nodeNum[i] > largest) {
    			largest = nodeNum[i];
    		}
    		if(nodeNum[i] < smallest && nodeNum[i] >= 2) {
    			smallest = nodeNum[i];
    		}
    	}
    	List<Integer> ans = List.of(smallest, largest); 
    	
    	return ans;
    	
//    	/* Original idea (fail)
//    	 *Step1: 	Count the nodes connecting to each node between 1 and N.
//    	 *			At this point, only count node within distance 1.
//    	 *Step2: 	Count the nodes connecting to each node between N + 1 and 2N.
//    	 *			Here all nodes connecting to each node could be found by referring the counts from Step1.
//    	 *			Now, the numbers counted above show all components.
//    	 */
//    	
////    	Find the number of nodes
//    	int nodeNum = 0;
//    	for(int i = 0; i < gb.size(); i++) {
//    		if(gb.get(i).get(1) > nodeNum) {
//    			nodeNum = gb.get(i).get(1);
//    		}
//    	}
//    	
//    	int N = nodeNum % 2 == 0 ? nodeNum / 2 : nodeNum / 2 + 1;
//    	
////    	Step1
//    	int[] counter1 = new int[N];
//    	for(int i = 0; i < gb.size(); i++) {
//    		counter1[gb.get(i).get(0) - 1] += 1;
//    	}
//    	
////    	Step2
//    	int[] counter2 = new int[N];
//    	for(int i = 0; i < gb.size(); i++) {
//    		counter2[gb.get(i).get(1) - N - 1] += counter1[gb.get(i).get(0) - 1];
//    	}
    	

    }

}

public class ComponentsInAGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> gb = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                gb.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = ResultComponentsInAGraph.componentsInGraph(gb);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
