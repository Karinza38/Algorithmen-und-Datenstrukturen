package de.uni_hamburg.ad.Zettel04;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
public class WichtelProblem {
  
  public static int[] sort(int[] arr) {
    log.info("Sorting {}", arr);
    List<SortResult> sortResults = new ArrayList<>();
    
    sortResults.add(checkIfSmaller(0, 1, arr));
    sortResults.add(checkIfSmaller(1, 2, arr));
    sortResults.add(checkIfSmaller(2, 3, arr));
    sortResults.add(checkIfSmaller(3, 4, arr));
    sortResults.add(checkIfSmaller(1, 3, arr));
    
    List<Integer> leftInArray = new ArrayList<>();
    List<Integer> rightInArray = new ArrayList<>();
    List<Integer> middleInArray = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      int finalI = i;
      if (sortResults.stream().allMatch(t -> t.getBigger() != finalI)) {
        leftInArray.add(finalI);
      } else if (sortResults.stream().allMatch(t -> t.getSmaller() != finalI)) {
        rightInArray.add(finalI);
      } else {
        middleInArray.add(finalI);
      }
    }
    if (leftInArray.size() == 2) {
      if (leftInArray.get(0) > leftInArray.get(1)) {
        Collections.swap(leftInArray, 0, 1);
      }
    } else if (leftInArray.size() > 2) {
      throw new RuntimeException("Mehr als 2 Elemente im linken Teil!");
    }
    if (rightInArray.size() == 2) {
      if (rightInArray.get(0) > rightInArray.get(1)) {
        Collections.swap(rightInArray, 0, 1);
      }
    } else if (rightInArray.size() > 2) {
      throw new RuntimeException("Mehr als 2 Elemente im rechten Teil!");
    }
    if (middleInArray.size() == 2) {
      Collections.swap(middleInArray, 0, 1);
    } else if (middleInArray.size() == 3) {
      if (sortResults.contains(SortResult.of(middleInArray.get(0), middleInArray.get(1)))) {                            //0 < 1
        if (checkIfSmaller(1, 2, middleInArray.stream().mapToInt(i -> i).toArray()).getSmaller() == 2) {       //2 < 1
          // refactor later
          if (checkIfSmaller(0, 2, middleInArray.stream().mapToInt(i -> i).toArray()).getSmaller() == 2) {     //2 < 0
            Collections.swap(middleInArray, 1, 2);  // 0 1 2 -> 0 2 1
            Collections.swap(middleInArray, 0, 1);  // 0 2 1 -> 2 0 1
          } else {                                                                                                      //0 < 2
            Collections.swap(middleInArray, 1, 2);  // 0 1 2 -> 0 2 1
          }
        } else {
          // 0 1 2 already sorted
        }
      }
      if (sortResults.contains(SortResult.of(middleInArray.get(1), middleInArray.get(0)))) {                            //1 < 0
        if (checkIfSmaller(0, 2, middleInArray.stream().mapToInt(i -> i).toArray()).getSmaller() == 2) {       //2 < 0
          // refactor later
          if (checkIfSmaller(1, 2, middleInArray.stream().mapToInt(i -> i).toArray()).getSmaller() == 2) {     //2 < 1
            Collections.swap(middleInArray, 0, 2);  // 0 1 2 -> 2 1 0
          } else {                                                                                                      //1 < 2
            Collections.swap(middleInArray, 0, 1);  // 0 1 2 -> 1 0 2
            Collections.swap(middleInArray, 1, 2);  // 1 0 2 -> 1 2 0
          }
        } else {
          Collections.swap(middleInArray, 0, 1);  // 0 1 2 -> 1 0 2
        }
      }
      if (sortResults.contains(SortResult.of(middleInArray.get(1), middleInArray.get(2)))) {                            //1 < 2
        if (checkIfSmaller(0, 1, middleInArray.stream().mapToInt(i -> i).toArray()).getSmaller() == 1) {       //1 < 0
          // refactor later
          if (checkIfSmaller(0, 2, middleInArray.stream().mapToInt(i -> i).toArray()).getSmaller() == 2) {     //2 < 0
            Collections.swap(middleInArray, 0, 1);  // 0 1 2 -> 1 0 2
            Collections.swap(middleInArray, 1, 2);  // 1 0 2 -> 1 2 0
          } else {                                                                                                      //0 < 2
            Collections.swap(middleInArray, 0, 1);  // 0 1 2 -> 1 0 2
          }
        } else {                                                                                                        //0 < 1
          //0 1 2 already sorted
        }
      }
      if (sortResults.contains(SortResult.of(middleInArray.get(2), middleInArray.get(1)))) {                            //2 < 1
        if (checkIfSmaller(0, 1, middleInArray.stream().mapToInt(i -> i).toArray()).getSmaller() == 1) {       //1 < 0
          // refactor later
          if (checkIfSmaller(0, 2, middleInArray.stream().mapToInt(i -> i).toArray()).getSmaller() == 2) {     //2 < 0
            Collections.swap(middleInArray, 0, 2);  // 0 1 2 -> 2 1 0
          } else {                                                                                                      //0 < 2
            Collections.swap(middleInArray, 0, 1);  // 0 1 2 -> 1 0 2
          }
        } else {                                                                                                        //0 < 1
          if (checkIfSmaller(0, 2, middleInArray.stream().mapToInt(i -> i).toArray()).getSmaller() == 2) {     //2 < 0
            Collections.swap(middleInArray, 0, 1);  // 0 1 2 -> 1 0 2
            Collections.swap(middleInArray, 0, 2);  // 1 0 2 -> 2 0 1
          } else {                                                                                                      //0 < 2
            Collections.swap(middleInArray, 0, 1);  // 0 1 2 -> 1 0 2
          }
        }
      }
      if (sortResults.contains(SortResult.of(middleInArray.get(2), middleInArray.get(0)))) {                            //2 < 0
        if (checkIfSmaller(0, 1, middleInArray.stream().mapToInt(i -> i).toArray()).getSmaller() == 1) {       //1 < 0
          // refactor later
          if (checkIfSmaller(1, 2, middleInArray.stream().mapToInt(i -> i).toArray()).getSmaller() == 2) {     //2 < 1
            Collections.swap(middleInArray, 0, 2);  // 0 1 2 -> 2 1 0
          } else {                                                                                                      //1 < 2
            Collections.swap(middleInArray, 0, 1);  // 0 1 2 -> 1 0 2
            Collections.swap(middleInArray, 1, 2);  // 1 0 2 -> 1 2 0
          }
        } else {                                                                                                        //0 < 1
          Collections.swap(middleInArray, 0, 2);  // 0 1 2 -> 2 1 0
          Collections.swap(middleInArray, 1, 2);  // 2 1 0 -> 2 0 1
        }
      }
      if (sortResults.contains(SortResult.of(middleInArray.get(0), middleInArray.get(2)))) {                            //0 < 2
        if (checkIfSmaller(0, 1, middleInArray.stream().mapToInt(i -> i).toArray()).getSmaller() == 0) {       //0 < 1
          // refactor later
          if (checkIfSmaller(1, 2, middleInArray.stream().mapToInt(i -> i).toArray()).getSmaller() == 2) {     //2 < 1
            Collections.swap(middleInArray, 1, 2);  // 0 1 2 -> 0 2 1
          } else {                                                                                                      //1 < 2
            // 0 1 2 already sorted
          }
        } else {                                                                                                        //1 < 0
          Collections.swap(middleInArray, 0, 1);  // 0 1 2 -> 1 0 2
        }
      }
    }
    
    leftInArray.addAll(middleInArray);
    leftInArray.addAll(rightInArray);
    return leftInArray.stream().mapToInt(i -> i).toArray();
  }
  
  private static SortResult checkIfSmaller(int one, int two, int[] arr) {
    if (arr[one] < arr[two]) {
      return SortResult.of(one, two);
    } else {
      return SortResult.of(two, one);
    }
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
