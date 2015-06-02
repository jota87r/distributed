/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.distributed;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;

/**
 *
 * @author jonatan
 */
public class PatternFinderJob extends Configured implements Tool {

  @Override
  public int run(String[] strings) throws Exception {
    
    PatternHolder.init("Hello");
    
    Configuration configuration = new Configuration();
    Job job = Job.getInstance(configuration, "final");
//    job.setJarByClass(Main.class);
    job.setMapperClass(CounterMapper.class);
    job.setCombinerClass(CombineReduce.class);
    job.setReducerClass(CombineReduce.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    
    FileInputFormat.addInputPath(job, new Path("E:\\EAFIT\\telematica\\Final\\input"));
    FileOutputFormat.setOutputPath(job, new Path("E:\\EAFIT\\telematica\\Final\\output"));
    return job.waitForCompletion(true) ? 0 : 1;
  }
  
}
