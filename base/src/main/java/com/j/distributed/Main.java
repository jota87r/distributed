/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.distributed;

import com.j.distributed.counter.CounterJob;
import com.j.distributed.sorter.SorterJob;
import org.apache.hadoop.util.ToolRunner;

/**
 *
 * @author jonatan
 */
public class Main {
  
  public static void main(String... args) throws Exception {
    PatternHolder.init(args[3]);
    int i = ToolRunner.run(new CounterJob(Main.class), args);
    if (i != 0) System.exit(i);
    else System.exit(ToolRunner.run(new SorterJob(Main.class), args));
  }
}
