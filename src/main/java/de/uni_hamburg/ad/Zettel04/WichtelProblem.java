package de.uni_hamburg.ad.Zettel04;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class WichtelProblem {
  private final static int A=0;
  private final static int B=1;
  private final static int C=2;
  private final static int D=3;
  private final static int E=4;

  public static int[] sort(int[] arr){           // a, b, c, d, e
    arr = Arrays.copyOf(arr, E + 1);

    // Prepare a,b,c,d
    if (arr[B] < arr[A]) swap(0, 1, arr);   // => a < b
    if (arr[D] < arr[C]) swap(2, 3, arr);   // => c < d
    if (arr[D] < arr[B]) {
      swap(A, C, arr);
      swap(B, D, arr);
    }                                            // => b < d
    // Results in:
    // a<b<d && c<d

    // b → d
    // ↑   ↑
    // a   c
    // How to read the graph: a → b == a<b

    // Pinpoint e into [a,b,d] (c is kept in the end for later)
    if (arr[E] < arr[B]) {                       // e < b
      // e → b → d
      //     ↑   ↑
      //     a   c

      if (arr[E] < arr[A]) {                   // e < a
        // e<a<b<d

        //     b → d
        //   🡕 ↑   ↑
        // e → a   c
        swap(0, 4, arr); // 0,1,2,3,4 -> 4,1,2,3,0
        swap(1, 4, arr); // 4,1,2,3,0 -> 4,0,2,3,1
        swap(2, 4, arr); // 4,0,2,3,1 -> 4,0,1,3,2
      } else {                                 // e >= a
        // a<=e<b<d

        // e → b → d
        // ↑ 🡕     ↑
        // a       c

        swap(1, 4, arr); // 0,1,2,3,4 -> 0,4,2,3,1
        swap(2, 4, arr); // 0,4,2,3,1 -> 0,4,1,3,2
      }
    } else {                                   // e >= b
      // a<b<d

      // b → e → d
      // ↑       ↑
      // a       c

      if (arr[E] < arr[D]) {                   // e < d
        // a<b<=e<d

        // b → e → d
        // ↑    🡖  ↑
        // a       c

        swap(2, 4, arr); // 0,1,2,3,4 -> 0,1,4,3,2
      } else {                                 // e >= d
        // a<b<d<=e

        // b → e →  d
        // ↑   ↑ 🡕
        // a   c

        swap(2, 4, arr); // 0,1,2,3,4 -> 0,1,4,3,2
        swap(2, 3, arr); // 0,1,4,3,2 -> 0,1,3,4,2
      }
    }
    final int newC = 4;
    final int newD = 2;
    // new e is on index 3

    // Squeeze in c into [a,b,d]
    if (arr[newC] < arr[B]) {                   // c < b
      if (arr[newC] < arr[A]) {                 // c < a
        // c<=a<=b<=d<=e

        swap(0, 4, arr); // 0,1,3,4,2 -> 2,1,3,4,0
        swap(1, 4, arr); // 2,1,3,4,0 -> 2,0,3,4,1
        swap(2, 4, arr); // 2,0,3,4,1 -> 2,0,1,4,3
        swap(3, 4, arr); // 2,0,1,4,3 -> 2,0,1,3,4
      } else {                               // c >= a
        // a<=c<=b<=d<=e

        swap(1, 4, arr); // 0,1,3,4,2 -> 0,2,3,4,1
        swap(2, 4, arr); // 0,2,3,4,1 -> 0,2,1,4,3
        swap(3, 4, arr); // 0,2,1,4,3 -> 0,2,1,3,4
      }
    } else {                                 // c >= b
      if (arr[newC] < arr[newD]) {           // c < d
        // a<=b<=c<=d<=e

        swap(2, 4, arr); // 0,1,3,4,2 -> 0,1,2,4,3
        swap(3, 4, arr); // 0,1,2,4,3 -> 0,1,2,3,4
      } else {                               // c>=d
        // a<=b<=d<=c<=e

        swap(3, 4, arr); // 0,1,3,4,2 -> 0,1,3,2,4
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
