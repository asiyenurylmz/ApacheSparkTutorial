package FirstExam;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		JavaSparkContext cont = new JavaSparkContext("local", "FirstExam");
		JavaRDD<String> wordRdd = cont.textFile("C:\\Users\\asiye\\OneDrive\\Masaüstü\\ilkDataSet.txt");
		System.out.println(wordRdd.count());
		System.out.println(wordRdd.first());

	}
}
