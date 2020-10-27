package com.StreamingTimeOperation;

import java.util.concurrent.TimeoutException;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws TimeoutException, StreamingQueryException {
		System.setProperty("hadoop.home.dir", "C:\\Users\\asiye\\OneDrive\\Masaüstü\\hadoop-common-2.2.0-bin-master");

		SparkSession sparkSession = SparkSession.builder().master("local").appName("Streaming-Time-Op").getOrCreate();

		Dataset<Row> rawData = sparkSession.readStream().format("socket").option("host", "localhost")
				.option("port", "8000").option("includeTimestamp", true).load();

		Dataset<Row> products = rawData.as(Encoders.tuple(Encoders.STRING(), Encoders.TIMESTAMP())).toDF("product",
				"timestamp");

		Dataset<Row> resultData = products
				.groupBy(functions.window(products.col("timestamp"), "1 Minute"), products.col("product")).count()
				.orderBy("window");

		StreamingQuery start = resultData.writeStream().outputMode("complete").format("console")
				.option("truncate", "false").start();

		start.awaitTermination();
	}
}
