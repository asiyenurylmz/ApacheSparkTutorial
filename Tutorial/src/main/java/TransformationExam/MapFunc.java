package TransformationExam;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;

public class MapFunc {

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

		/*
		newRdd.foreach(new VoidFunction<CupModel>() {
			public void call(CupModel cupModel) throws Exception {
				System.out.println(cupModel.getHostCountry());
			}
		});
		*/
		
		JavaRDD<CupModel> italy = newRdd.filter(new Function<CupModel, Boolean>() {

			public Boolean call(CupModel cupModel) throws Exception {
				return cupModel.winner.equals("Italy");
			}
		});
		
		italy.foreach(new VoidFunction<CupModel>() {
			
			public void call(CupModel cupModel) throws Exception {
				System.out.println(cupModel.getYear()+ " " + cupModel.getWinner());
				
			}
		});
		
	}
}
