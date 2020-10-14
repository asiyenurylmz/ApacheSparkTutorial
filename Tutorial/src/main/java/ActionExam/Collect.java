package ActionExam;

import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Collect {
	public static void main(String[] args) {
		System.setProperty("hadoop.home.dir", "C:\\Users\\asiye\\OneDrive\\Masaüstü\\hadoop-common-2.2.0-bin-master");
		JavaSparkContext sc = new JavaSparkContext("local", "Map Func");
		JavaRDD<String> rawData = sc
				.textFile("C:\\Users\\asiye\\OneDrive\\Masaüstü\\datasets\\WorldCup\\WorldCups.csv");

		System.out.println(rawData.count());
		System.out.println(rawData.first());

		List<String> collectList = rawData.collect();
		
		for(String x : collectList) {
			System.out.println(x);
		}
		
	}
}
