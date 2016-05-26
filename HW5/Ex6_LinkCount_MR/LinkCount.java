import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class LinkCount {
	public static class TokenizerMapper extends Mapper<Object, Text, IntWritable, IntWritable> {
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String data[] = value.toString().split("\t");
			int fromNode = Integer.parseInt(data[0]);
			int toNode = Integer.parseInt(data[1]);
			IntWritable prepareFromNode = new IntWritable(fromNode);
			IntWritable prepareToNode = new IntWritable(toNode);
			context.write(prepareToNode, prepareFromNode);
		}
	}
	public static class IntSumReducer extends Reducer<IntWritable, IntWritable, IntWritable,Text> {
		public void reduce(IntWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
			int count = 0;
			for(IntWritable fromNode: values)
				count++;
			Text showNoLink = new Text();
			showNoLink.set("No link: " + count);
      		context.write(key, showNoLink);
		}
	}
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
	    Job job = Job.getInstance(conf, "LinkCount");
	    job.setJarByClass(LinkCount.class);
	    job.setMapperClass(TokenizerMapper.class);
	    job.setReducerClass(IntSumReducer.class);
	    job.setOutputKeyClass(IntWritable.class);
	    job.setOutputValueClass(IntWritable.class);
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
    	System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}