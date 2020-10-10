package TransformationExam;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Distinct {

	public static void main(String[] args) {
		System.setProperty("hadoop.home.dir", "C:\\Users\\asiye\\OneDrive\\Masaüstü\\hadoop-common-2.2.0-bin-master");
		JavaSparkContext sc = new JavaSparkContext("local", "Flapmap");
		JavaRDD<String> rawData = sc
				.textFile("C:\\Users\\asiye\\OneDrive\\Masaüstü\\datasets\\WorldCup\\WorldCups.csv");

		System.out.println(rawData.count());

		JavaRDD<String> distinctRDD = rawData.distinct();
		System.out.println(distinctRDD.count());
	}
}
