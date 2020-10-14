package SecondExam;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class App {

	public static void main(String[] args) {
		JavaSparkContext cont = new JavaSparkContext("local", "SecondExam");
		List<String> exam = Arrays.asList("Albert Einstein", "Isaac Newton", "Stephen Hawking");

		JavaRDD<String> firstPr = cont.parallelize(exam);
		
		System.out.println("toplam satir:" + firstPr.count());
	}
}
