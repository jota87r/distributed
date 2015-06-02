/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j.distributed;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jonatan
 */
public class PatternHolder {
  
  private static PatternHolder instance;
  
  private final Pattern pattern;
  
  private PatternHolder(String regex) {
    pattern = Pattern.compile(regex);
  }
  
  public  static PatternHolder instance() {
    return instance;
  }
  
  public Pattern pattern() {
    return pattern;
  }
  
  public Matcher matcher(String text) {
    return pattern.matcher(text);
  }
  
  public synchronized static void init(String regex) {
    instance = new PatternHolder(regex);
  }
}
