/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.distributed.counter;

import com.j.distributed.PatternHolder;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jonatan
 */
public class CounterMapperTest {
  
  @Test
  public void testMatcher() {
    // given
    CounterMapper counter = new CounterMapper();
    String textA = "Hello hadoop Goodbye Hadoop";
    String pattern = "Hadoop$";
    PatternHolder.init(pattern);
    
    // when
    int i = counter.countOccurrencies(textA);
    
    // then
    Assert.assertEquals("countOccurrencies was unable to find succesfully " + pattern, 1, i);
  }
}
