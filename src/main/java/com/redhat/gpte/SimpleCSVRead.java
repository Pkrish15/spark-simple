/**
 * 
 */
package com.redhat.gpte;

import static org.apache.spark.sql.functions.col;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
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
		
				
		String csvFile = "data/moviedata.csv";
		
		SQLContext sqlc=new SQLContext(spark);
		List<String> data = new ArrayList<String>();
	    data.add("dev, engg, 10000");
	    data.add("karthik, engg, 20000");
	    // DataFrame
	    Dataset<?> df = sqlc.createDataset(data, Encoders.STRING()).toDF();
	    df.createGlobalTempView("movie");
	    df.printSchema();
	    df.show();
	    df.select(col("name")).show();
	    // Convert
	    Dataset<?> df1 = df.selectExpr("split(value, ',')[0] as name", "split(value, ',')[1] as degree","split(value, ',')[2] as salary");
	    df1.printSchema();
	    df1.show(); 
       /* List<MovieData> inputData=Arrays.asList(
				
				new MovieData("1", "SpiderMan", "2019", "4.7", "1783"),
				new MovieData("2", "SpiderMan1", "2017", "8.7", "2783")

				);
        
        DataFrame df = sqlc.createDataFrame(inputData, Encoders.STRING()).toDF();
        df.printSchema();
        df.show();
        // Convert
        DataFrame df1 = df.selectExpr("split(value, ',')[0] as name", "split(value, ',')[1] as degree","split(value, ',')[2] as salary");
        df1.printSchema();
        df1.show();
		
		Dataset<Row> df = sqlc.createDataset(inputData, Encoders.STRING().schema().toSeq();//spark.read().format("com.databricks.spark.csv").option("header", "true").load(inputData);
					 
		df.createGlobalTempView("movie");
		df.printSchema();
		df.show();
	    df.select(col("name"), col("year")).show();

		df.select(col("name")).show();
		
		
*/		
	}
}
