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

  public static int[] sort(int[] arr){          // a, b, c, d, e
    arr = Arrays.copyOf(arr, E + 1);

    // Prepare a,b,c,d
    if (arr[B] < arr[A]) swap(0, 1, arr);   // => a < b
    if (arr[D] < arr[C]) swap(2, 3, arr);   // => c < d
    if (arr[D] < arr[B]) {
      swap(A, C, arr);
      swap(B, D, arr);
    }                                            // => b < d
    // Results in:
    // b → d
    // ↑   ↑
    // a   c
    // How to read the graph: a → b == a<b

    // Pinpoint the position of e
    if (arr[E] < arr[D]) {                       // e < d
      // b  → d
      // ↑  🡕 ↑
      // a e  c
      // NOTE: remember e < d !
      // For better readability it will be omitted in the further graphs in this scope!

      if (arr[E] < arr[B]) {                     // e < b
        // e → b → d
        //     ↑   ↑
        //     a   c

        if (arr[E] < arr[A]) {                   // e < a
          //     b → d
          //   🡕 ↑   ↑
          // e → a   c

          if (arr[B] < arr[C]) {                 // b < c
            // e<a<b<c<d ✔

            //    b → d
            //  🡕 ↑ 🡖 ↑
            // e →a   c
            swap(4, 0, arr); // 0,1,2,3,4 -> 4,1,2,3,0
            swap(4, 1, arr); // 4,1,2,3,0 -> 4,0,2,3,1
            swap(4, 2, arr); // 4,0,2,3,1 -> 4,0,1,3,2
            swap(4, 3, arr); // 4,0,1,3,2 -> 4,0,1,2,3
          } else {                               // b >= c
            // e<a<c<=b<d ✔?

            //     b → d
            //  🡕  ↑ 🡔 ↑
            // e → a   c
            swap(4, 0, arr); // 0,1,2,3,4 -> 4,1,2,3,0
            swap(4, 1, arr); // 4,1,2,3,0 -> 4,0,2,3,1
            swap(4, 3, arr); // 4,0,2,3,1 -> 4,0,2,1,3
          }
        } else {                                 // e >= a
          // e → b → d
          // ↑ 🡕     ↑
          // a       c

          if (arr[B] < arr[C]) {                 // b < c
            //a<=e<b<c<d ✔

            // e → b → d
            // ↑ 🡕   🡖 ↑
            // a       c
            swap(4, 1, arr); // 0,1,2,3,4 -> 0,4,2,3,1
            swap(4, 2, arr); // 0,4,2,3,1 -> 0,4,1,3,2
            swap(4, 3, arr); // 0,4,1,3,2 -> 0,4,1,2,3
          } else {                               // b >= c
            //a<=e<c<=b<d ✔

            // e → b → d
            // ↑ 🡕   🡔 ↑
            // a       c
            swap(4, 1, arr); // 0,1,2,3,4 -> 0,4,2,3,1
            swap(4, 3, arr); // 0,4,2,3,1 -> 0,4,2,1,3
          }
        }
      } else {                                   // e >= b
        // b → e → d
        // ↑       ↑
        // a       c

        if (arr[E] < arr[C]) {                   // e < c
          // b → e → d
          // ↑    🡖  ↑
          // a       c

          if (arr[B] < arr[C]) {                 // b < c
            // a<b<=e<c<d

            // b → c → d
            // ↑ 🡖 ↑ 🡕
            // a   e
            swap(2, 3, arr); // 0,1,2,3,4 -> 0,1,3,2,4
            swap(2, 4, arr); // 0,1,3,2,4 -> 0,1,4,2,3
          } else {                               // b >= c
            // a<b<=e<c<d

            // b → c → d
            // ↑ 🡖 ↑ 🡕
            // a   e

            swap(2, 3, arr); // 0,1,2,3,4 -> 0,1,3,2,4
            swap(2, 4, arr); // 0,1,3,2,4 -> 0,1,4,2,3
          }
        } else {                                 // e >= c

          // b → e →  d
          // ↑   ↑ 🡕
          // a   c

          if (arr[B] < arr[C]) {                 // b < c
            // a<b<=c<=e<d

            // b → e →  d
            // ↑ 🡖 ↑ 🡕
            // a   c
            swap(3, 4, arr); // 0,1,2,3,4 -> 0,1,2,4,3
          } else {                               // b >= c

            swap(1, 2, arr); // 0,1,2,3,4 -> 0,2,1,3,4
            swap(3, 4, arr); // 0,1,2,3,4 -> 0,2,1,4,3
          }
        }
      }
    }
    else {                                       // e >= d
      // b → d → e
      // ↑   ↑
      // a   c
      // Used 4 comparisons until here.

      if (arr[B] < arr[C]) {                     // b < c
        // a<b<c
        // c<d<=e

        // b → d →  e
        // ↑ 🡖 ↑ 🡕
        // a → c
        // all in order already
      } else {                                   // b >= c
        // a<b
        // c<b
        // c<d<=e
        if (arr[A] < arr[C]) {                   // a < c
          // a<c<b<d<=e

          // b → d →  e
          // ↑ 🡔 ↑ 🡕
          // a   c

          swap(1, 2, arr); // 0,1,2,3,4 -> 0,2,1,3,4
        } else {                                 // a=> c
          // c<a<b<d<=e
          swap(1, 2, arr); // 0,1,2,3,4 -> 1,0,2,3,4
          swap(0, 1, arr); // 0,1,2,3,4 -> 1,2,0,3,4

        }
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
