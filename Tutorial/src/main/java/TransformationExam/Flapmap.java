package TransformationExam;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.VoidFunction;

public class Flapmap {

	public static void main(String[] args) {
		System.setProperty("hadoop.home.dir", "C:\\Users\\asiye\\OneDrive\\Masaüstü\\hadoop-common-2.2.0-bin-master");
		JavaSparkContext sc = new JavaSparkContext("local", "Flapmap");
		JavaRDD<String> rawData = sc
				.textFile("C:\\Users\\asiye\\OneDrive\\Masaüstü\\datasets\\WorldCup\\WorldCups.csv");

		JavaRDD<String> flatMapRdd = rawData.flatMap(new FlatMapFunction<String, String>() {

			public Iterator<String> call(String s) throws Exception {
				return Arrays.asList(s.split(",")).iterator(); //her virgül arası değeri ayrı Rdd'lerde tutar
			}
		});
		
		flatMapRdd.foreach(new VoidFunction<String>() {
			
			public void call(String s) throws Exception {
				System.out.println(s);
			}
		});
	}
}
