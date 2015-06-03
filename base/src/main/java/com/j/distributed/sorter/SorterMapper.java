/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.distributed.sorter;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author jonatan
 */
public class SorterMapper extends Mapper<Object, Text, LongWritable, Text> {
  
  @Override
  public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
    String[] data = value.toString().split("\t");
    context.write(new LongWritable(Long.parseLong(data[1])), new Text(data[0]));
  }
}
