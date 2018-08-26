/**
 * 
 */
package com.redhat.gpte;

import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * @author prakrish
 *
 */
public class SimpleCSVRead {
	static SparkSession spark = SparkSession.builder()
			.appName("SimpleCSVRead")
			.master("local[*]")
			.config("spark.sql.warehouse.dir", "/tmp/")
			.getOrCreate();

	
	public static void main(String[] args) throws AnalysisException {
		String csvFile = "src/main/resources/moviedata.csv";
		Dataset<Row> df = spark.read().format("com.databricks.spark.csv").option("header", "true").load(csvFile);
					
		df.createGlobalTempView("movie");
		df.schema();
		df.printSchema();
		df.show();
		
		
	}
}
