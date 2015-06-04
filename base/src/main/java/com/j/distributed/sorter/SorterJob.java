/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.distributed.sorter;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;

/**
 *
 * @author jonatan
 */
public class SorterJob extends Configured implements Tool {

  @Override
  public int run(String... options) throws Exception {
    
    Job job = Job.getInstance(getConf(), getClass().toString());
    job.setJarByClass(getClass());
    
    job.setMapperClass(SorterMapper.class);
    job.setCombinerClass(SorterReducer.class);
    job.setReducerClass(SorterReducer.class);
    
    job.setOutputKeyClass(LongWritable.class);
    job.setOutputValueClass(Text.class);
    job.setSortComparatorClass(LongWritable.DecreasingComparator.class);
    
    FileInputFormat.addInputPath(job, new Path(options[1]));
    FileOutputFormat.setOutputPath(job, new Path(options[2]));
    return job.waitForCompletion(true) ? 0 : 1;
  }
  
}
