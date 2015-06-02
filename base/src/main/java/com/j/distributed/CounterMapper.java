/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.distributed;

import java.io.IOException;
import java.util.regex.Matcher;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author jonatan
 */
public class CounterMapper extends Mapper<Object, Text, Text, IntWritable> {
  
  @Override
  public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
    String fileName = ((FileSplit) context.getInputSplit()).getPath().toString();
    context.write(new Text(fileName), new IntWritable(countOccurrencies(value.toString())));
  }
  
  @SuppressWarnings("empty-statement")
  private int countOccurrencies(String text) {
    int i = 0;
    for (Matcher matcher = PatternHolder.instance().matcher(text); matcher.find(); i++);
    return i;
  }
}
