package TransformationExam;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;

public class Sample {
	public static void main(String[] args) {
		System.setProperty("hadoop.home.dir", "C:\\Users\\asiye\\OneDrive\\Masaüstü\\hadoop-common-2.2.0-bin-master");
		JavaSparkContext sc = new JavaSparkContext("local", "Flapmap");
		JavaRDD<String> rawData = sc
				.textFile("C:\\Users\\asiye\\OneDrive\\Masaüstü\\datasets\\WorldCup\\WorldCups.csv");

		JavaRDD<String> sampleRdd = rawData.sample(false, 0.5);
		
		sampleRdd.foreach(new VoidFunction<String>() {
			
			public void call(String t) throws Exception {
				System.out.println(t);
				
			}
		});
	}
}
