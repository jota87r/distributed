/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.distributed.counter;

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
public class CounterJob extends Configured implements Tool {

  @Override
  public int run(String... options) throws Exception {
    
    Job job = Job.getInstance(getConf(), getClass().toString());
    job.setJarByClass(getClass());
    
    job.setMapperClass(CounterMapper.class);
    job.setCombinerClass(CounterReducer.class);
    job.setReducerClass(CounterReducer.class);
    
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    
    FileInputFormat.addInputPath(job, new Path(options[0]));
    FileOutputFormat.setOutputPath(job, new Path(options[1]));
    return job.waitForCompletion(true) ? 0 : 1;
  }
  
}
