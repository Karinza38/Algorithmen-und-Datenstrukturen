package de.uni_hamburg.ad.Zettel04;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
public class WichtelProblem {

  public static int[] sort(int[] arr){          // a, b, c, d, e
    arr = Arrays.copyOf(arr, 5);
    if (arr[0] > arr[1]) swap(0, 1, arr);   // a < b
    if (arr[2] > arr[3]) swap(2, 3, arr);   // c < d
    int biggestAC = arr[0] > arr[2] ? 0 : 2;     // a < c
    if (arr[4] < arr[biggestAC]) {               // e < c
      if (arr[4] < arr[1]) {                     // e < b
        if (arr[4] < arr[0]) {                   // e < a
          // e<a<b<c<d
          swap(4, 0, arr); // 0,1,2,3,4 -> 4,1,2,3,0
          swap(4, 1, arr); // 4,1,2,3,0 -> 4,0,2,3,1
          swap(4, 2, arr); // 4,0,2,3,1 -> 4,0,1,3,2
          swap(4, 3, arr); // 4,0,1,3,2 -> 4,0,1,2,3
        } else {                                 // a <= e
          //(a<=e<b)<(c<d)
          swap(4, 1, arr); // 0,1,2,3,4 -> 0,4,2,3,1
          swap(4, 2, arr); // 0,4,2,3,1 -> 0,4,1,3,2
          swap(4, 3, arr); // 0,4,1,3,2 -> 0,4,1,2,3
        }
      } else {                                   // b <= e
        //a<b<=e<c<d
        swap(2, 3, arr); // 0,1,2,3,4 -> 0,1,3,2,4
        swap(2, 4, arr); // 0,1,3,2,4 -> 0,1,4,2,3
      }
    } else {                                     // c <= e
      if (arr[2] < arr[1]) swap(2, 1, arr);   // b < c
      if (arr[4] < arr[3]) {                     // e < d
        // a<b<c=<e<d
        swap(3, 4, arr);
      } else {                                   // d <= e
        if (arr[3] < arr[2]) swap(3, 2, arr);   // c < d
        // a<b<c<d<=e
        // do nothing, already sorted
      }
    }
    return arr;
  }

  private static void swap(int i, int j, int[] arr) {
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
  }
}

class SortResult {
  private final int smaller;
  private final int bigger;
  
  private SortResult(int smaller, int bigger) {
    this.smaller = smaller;
    this.bigger = bigger;
  }
  
  public static SortResult of(int smaller, int bigger) {
    return new SortResult(smaller, bigger);
  }
  
  
  public int getSmaller() {
    return smaller;
  }
  
  public int getBigger() {
    return bigger;
  }
  
}
