package PairRdd;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;

import TransformationExam.CupModel;
import scala.Tuple2;

public class App {

	public static void main(String[] args) {
		System.setProperty("hadoop.home.dir", "C:\\Users\\asiye\\OneDrive\\Masaüstü\\hadoop-common-2.2.0-bin-master");
		JavaSparkContext sc = new JavaSparkContext("local", "Map Func");
		JavaRDD<String> rawData = sc
				.textFile("C:\\Users\\asiye\\OneDrive\\Masaüstü\\datasets\\WorldCup\\WorldCups.csv");

		JavaRDD<CupModel> newRdd = rawData.map(new Function<String, CupModel>() {
			public CupModel call(String line) throws Exception {
				String[] split = line.split(",");
				return new CupModel(split[0], split[1], split[2], split[3], split[4], split[5],
						Integer.parseInt(split[6]), Integer.parseInt(split[7]), Integer.parseInt(split[8]), split[9]);
			}
		});

		JavaPairRDD<String, String> firstPair = newRdd.mapToPair(new PairFunction<CupModel, String, String>() {

			public Tuple2<String, String> call(CupModel cupModel) throws Exception {
				return new Tuple2<String, String>(cupModel.getWinner(), cupModel.getAttendance());
			}
		});

		firstPair.foreach(new VoidFunction<Tuple2<String, String>>() {

			public void call(Tuple2<String, String> line) throws Exception {
				System.out.println(line._1 + " -- " + line._2);

			}
		});

		JavaPairRDD<String, Iterable<String>> resultData = firstPair.groupByKey();
		
		resultData.foreach(new VoidFunction<Tuple2<String,Iterable<String>>>() {

			public void call(Tuple2<String, Iterable<String>> line) throws Exception {
				System.out.println(line._1 + " " + line._2);
				
			}
		});
	}
}
