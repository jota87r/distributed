/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.distributed.counter;

import com.j.distributed.PatternHolder;
import java.io.IOException;
import java.util.regex.Matcher;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

/**
 *
 * @author jonatan
 */
public class CounterMapper extends Mapper<Object, Text, Text, IntWritable> {
  
  @Override
  public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
    String fileName = ((FileSplit) context.getInputSplit()).getPath().getName();
    context.write(new Text(fileName), new IntWritable(countOccurrencies(value.toString())));
  }
  
  @SuppressWarnings("empty-statement")
  int countOccurrencies(String text) {
    int i = 0;
    for (Matcher matcher = PatternHolder.instance().matcher(text); matcher.find(); i++);
    return i;
  }
}
