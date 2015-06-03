/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.distributed.sorter;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author jonatan
 */
public class SorterReducer extends Reducer<LongWritable, Text, LongWritable, Text> {
  
  @Override
  public void reduce(LongWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
    context.write(key, values.iterator().next());
  }
}
