package de.uni_hamburg.ad.Zettel04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntervallProblemTest {
  
  @Test
  void prepareArray() {
  }
  
  @Test
  void count() {
    int[] arr = new int[]{2, 2, 3};
    arr = IntervallProblem.prepareArray(arr, 3);
    
    int ergebnisAnzahl = IntervallProblem.count(0, 0, arr);
    assertEquals(0, ergebnisAnzahl);
  }
  
  @Test
  void count2() {
    int[] arr = new int[]{2, 2, 3};
    arr = IntervallProblem.prepareArray(arr, 3);
    
    int ergebnisAnzahl = IntervallProblem.count(0, 2, arr);
    assertEquals(2, ergebnisAnzahl);
  }
  
  @Test
  void count3() {
    int[] arr = new int[]{2, 2, 3};
    arr = IntervallProblem.prepareArray(arr, 3);
    
    int ergebnisAnzahl = IntervallProblem.count(3, 3, arr);
    assertEquals(1, ergebnisAnzahl);
  }
  
  @Test
  void count4() {
    int[] arr = new int[]{2, 2, 3};
    arr = IntervallProblem.prepareArray(arr, 3);
    
    int ergebnisAnzahl = IntervallProblem.count(-5, 1000, arr);
    assertEquals(3, ergebnisAnzahl);
  }
  
  @Test
  void count5() {
    int[] arr = new int[]{2, 2, 3};
    arr = IntervallProblem.prepareArray(arr, 3);
    
    int ergebnisAnzahl = IntervallProblem.count(0, 1, arr);
    assertEquals(0, ergebnisAnzahl);
  }
  
  @Test
  void count6() {
    int[] arr = new int[]{2, 2, 3, 0};
    arr = IntervallProblem.prepareArray(arr, 3);
    
    int ergebnisAnzahl = IntervallProblem.count(0, 0, arr);
    assertEquals(1, ergebnisAnzahl);
  }
}
