package DataStructures.Trees;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class NodeWithLevel {
	NodeWithLevel left;
	NodeWithLevel right;
	int data;
	int level;

	NodeWithLevel(int data, int level) {
		this.data = data;
		this.level = level;
		left = null;
		right = null;
	}
}

class ResultSwapNodesAlgo {

    /*
     * Complete the 'swapNodes' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY indexes
     *  2. INTEGER_ARRAY queries
     */
    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
    // Write your code here
    	List<List<Integer>> answer = new ArrayList<>();
    	
    	NodeWithLevel root = new NodeWithLevel(1, 1);
    	if(!indexes.isEmpty()) {
        	tree(Arrays.asList(root), indexes, 2);
    	}
    	
    	for(int query: queries) {
    		swap(root, query);
    		answer.add(inOrderTraverse(root, new ArrayList<Integer>()));
    	}

    	return answer;

    }
    
    public static void swap(NodeWithLevel root, int k) {
    	if(root.left != null) {
    		swap(root.left, k);
    	}
    	if(root.right != null) {
    		swap(root.right, k);
    	}
    	if(root.level % k == 0) {
    		NodeWithLevel left = root.left;
    		root.left = root.right;
    		root.right = left;
    	}
    }
    
    public static void tree(List<NodeWithLevel> currentLevel, List<List<Integer>> indexes, int level) {
    	List<NodeWithLevel> nextLevel = new ArrayList<>();
    	for(NodeWithLevel node: currentLevel) {
    		if(indexes.get(0).get(0) != -1) {
    			node.left = new NodeWithLevel(indexes.get(0).get(0), level);
    			nextLevel.add(node.left);
    		}
    		if(indexes.get(0).get(1) != -1) {
    			node.right = new NodeWithLevel(indexes.get(0).get(1), level);
    			nextLevel.add(node.right);
    		}
    		indexes.remove(0);
    	}
    	
    	if(!indexes.isEmpty()) {
    		level++;
    		tree(nextLevel, indexes, level);
    	}
    }
    
    public static List<Integer> inOrderTraverse(NodeWithLevel root, List<Integer> inOrderTraverse) {
        // Write your code here
    		if(root.left != null) {
        		inOrderTraverse = inOrderTraverse(root.left, inOrderTraverse);
        	}
    		inOrderTraverse.add(root.data);
    		if (root.right != null) {
    			inOrderTraverse = inOrderTraverse(root.right, inOrderTraverse);
    		}

    		return inOrderTraverse;
    }

}

public class SwapNodesAlgo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> result = ResultSwapNodesAlgo.swapNodes(indexes, queries);

        result.stream()
            .map(
                r -> r.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
            )
            .map(r -> r + "\n")
            .collect(toList())
            .forEach(e -> {
                try {
                    bufferedWriter.write(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

