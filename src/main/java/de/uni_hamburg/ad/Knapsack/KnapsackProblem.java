package de.uni_hamburg.ad.Knapsack;

public class KnapsackProblem {
  
  
  
  public double knapSack(double[] values, int[] volumes, int capacity) {
    assert values.length == volumes.length;
    int numOfItems = values.length;
    double[][] knapsackTable = new double[numOfItems + 1][capacity + 1];
    
    for (int i = 1; i <= numOfItems; i++) {
      for (int w = 0; w <= capacity; w++) {
        double notTakingItem = knapsackTable[i - 1][w];
        double takingItem = 0;
        
        if (volumes[i - 1] <= w) {
          if (w - volumes[i - 1] < 0) {
            takingItem = 0;
          } else {
            takingItem = values[i - 1] + knapsackTable[i - 1][w - volumes[i - 1]];
          }
        }
        knapsackTable[i][w] = Math.max(notTakingItem, takingItem);
      }
    }
    return knapsackTable[numOfItems][capacity];
  }
  
  
  // public double knapSack(double[] values, int[] volumes, int capacity) {
  //   // FIXME Robin 07.02.2021 : nicht als Lösung einreichen, da Rekursion wohl nicht erlaubt ist! -> Fehlversuch
  //   assert values.length == volumes.length;
  //   if (capacity == 0) {
  //     return 0.0;
  //   }
  //
  //   double[] ratioArray = new double[values.length];
  //   int ii = 0;
  //   double maxValue = 0.0;
  //   int maxVolume = 0;
  //   for (double value : values) {
  //     int volume = volumes[ii];
  //     if (volume > capacity) {
  //       ratioArray[ii] = 0;
  //     } else {
  //       double ratio = value / volume;
  //       maxValue += value;
  //       maxVolume += volume;
  //       ratioArray[ii] = ratio;
  //       ii++;
  //     }
  //   }
  //   if (maxVolume <= capacity) {
  //     return maxValue;
  //   } else {
  //     while (maxVolume > capacity) {
  //       double smallest = -1.0;
  //       int indexOfSmallest = 0;
  //       int index = 0;
  //       for (double ratio : ratioArray) {
  //         if (ratio < smallest || smallest < 0) {
  //           smallest = ratio;
  //           indexOfSmallest = index;
  //         }
  //         index++;
  //       }
  //       maxValue -= values[indexOfSmallest];
  //       maxVolume -= volumes[indexOfSmallest];
  //       ratioArray[indexOfSmallest] = Double.MAX_VALUE;
  //     }
  //   }
  //   return maxValue;
  // }
}
