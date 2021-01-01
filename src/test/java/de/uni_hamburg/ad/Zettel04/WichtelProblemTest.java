package de.uni_hamburg.ad.Zettel04;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Slf4j
public class WichtelProblemTest {
  
  private static final List<int[]> permutations = new ArrayList<>();
  private static final List<Integer> sortedArray = Arrays.asList(0, 1, 2, 3, 4);
  
  @BeforeAll
  static void initializeMap() {
    
    permute(new ArrayList<>(sortedArray), 0);
  }
  
  static void permute(List<Integer> arr, int k) {
    for (int i = k; i < arr.size(); i++) {
      swap(arr, i, k);
      permute(arr, k + 1);
      swap(arr, k, i);
    }
    if (k == arr.size() - 1) {
      permutations.add(arr.stream().mapToInt(i -> i).toArray());
    }
  }
  
  
  @Test
  void sortTest() {
    
    // Act
    for (var permutation : permutations) {
      int[] sorted = WichtelProblem.sort(permutation);
      assertThat(sorted, is(sortedArray));
      
    }
    
    // Assert
  }
  
}
