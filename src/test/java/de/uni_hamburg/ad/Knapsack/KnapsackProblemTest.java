package de.uni_hamburg.ad.Knapsack;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackProblemTest {
  
  KnapsackProblem knapsackProblem = new KnapsackProblem();
  
  @Test
  public void knapSackTest1(){
    double[] values = {1,3,2,6,5};
    int[] volumes =   {3,2,2,5,10};
    int maxVolume = 12;
    assertThat(knapsackProblem.knapSack(values, volumes, maxVolume),is(12.0));
  }
  
  
  @Test
  public void knapSackTest2(){
    double[] values = {0.5, 1.3};
    int[] volumes = {2, 5};
    int maxVolume = 3;
    assertThat(knapsackProblem.knapSack(values, volumes, maxVolume),is(0.5));
  }
  
  @Test
  public void knapSackTest3(){
    double[] values = {6,8};
    int[] volumes = {6,8};
    int maxVolume = 0;
    assertThat(knapsackProblem.knapSack(values, volumes, maxVolume),is(0.0));
  }
  
  @Test
  public void knapSackTest4(){
    double[] values = {6,8};
    int[] volumes = {6,8};
    int maxVolume = 10;
    assertThat(knapsackProblem.knapSack(values, volumes, maxVolume),is(8.0));
  }
  
  @Test
  public void knapSackTest5(){
    double[] values = {1,1,99};
    int[] volumes = {6,4,11};
    int maxVolume = 10;
    assertThat(knapsackProblem.knapSack(values, volumes, maxVolume),is(2.0));
  }
  
  @Test
  public void knapSackTest6(){
    double[] values = {6,8};
    int[] volumes = {6,8};
    int maxVolume = 17;
    assertThat(knapsackProblem.knapSack(values, volumes, maxVolume),is(14.0));
  }
  
  @Test
  public void knapSackTest7(){
    double[] values = new double[100];
    int[] volumes = new int[100];
    for(int i = 0; i < 100; ++i){
      values[i] = i;
      volumes[i] = i;
    }
    int maxVolume = 100;
    assertThat(knapsackProblem.knapSack(values, volumes, maxVolume),is(100.0));
  }
}
