package Algorithms;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class ResultGradingStudents {

	/*
	 * Complete the 'gradingStudents' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY.
	 * The function accepts INTEGER_ARRAY grades as parameter.
	 */

	public static List<Integer> gradingStudents(List<Integer> grades) {
		// Write your code here
		//set a round grade to null
		List<Integer> roundGrades = new ArrayList<>();

		//Repeat operations for the number of list grades elements
		for(int i = 0; i < grades.size(); i++) {
			int grade = grades.get(i);
			//Round the number if grade is greater than 37 and if the next multiple of  is less than 3
			if(grade > 37 && grade % 5 >= 3) {
				roundGrades.add(grade + (5 - grade % 5));
			}else {
				roundGrades.add(grade);
			}
		}

		return roundGrades;
	}

}

public class GradingStudents {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		})
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(toList());

		List<Integer> result = ResultGradingStudents.gradingStudents(grades);

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
