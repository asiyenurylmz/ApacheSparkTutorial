package TransformationExam;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Union {

	public static void main(String[] args) {
		System.setProperty("hadoop.home.dir", "C:\\Users\\asiye\\OneDrive\\Masaüstü\\hadoop-common-2.2.0-bin-master");
		JavaSparkContext sc = new JavaSparkContext("local", "Flapmap");
		JavaRDD<String> rawData = sc
				.textFile("C:\\Users\\asiye\\OneDrive\\Masaüstü\\datasets\\WorldCup\\WorldCups.csv");

		JavaRDD<String> secondData = sc
				.textFile("C:\\Users\\asiye\\OneDrive\\Masaüstü\\datasets\\WorldCup\\WorldCupPlayers.csv");

		JavaRDD<String> resultRDD = rawData.union(secondData);
		
		System.out.println("1. Rdd : " + rawData.count());
		System.out.println("2. Rdd : " + secondData.count());
		System.out.println("3. Rdd : " + resultRDD.count());
	}
}
