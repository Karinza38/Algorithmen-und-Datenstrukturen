package de.uni_hamburg.ad.Knapsack;

public class KnapsackProblem {
  
  
  public double knapSack(double[] values, int[] volumes, int capacity) {
    // FIXME Robin 07.02.2021 : nicht als Lösung einreichen, da Rekursion wohl nicht erlaubt ist! -> Fehlversuch
    assert values.length == volumes.length;
    if (capacity == 0) {
      return 0.0;
    }
    
    double[] ratioArray = new double[values.length];
    int ii = 0;
    double maxValue = 0.0;
    int maxVolume = 0;
    for (double value : values) {
      int volume = volumes[ii];
      if(volume > capacity){
        ratioArray[ii] = 0;
      } else {
        double ratio = value / volume;
        maxValue += value;
        maxVolume += volume;
        ratioArray[ii] = ratio;
        ii++;
      }
    }
    if (maxVolume <= capacity) {
      return maxValue;
    } else {
      while (maxVolume > capacity) {
        double smallest = -1.0;
        int indexOfSmallest = 0;
        int index = 0;
        for (double ratio : ratioArray) {
          if (ratio < smallest || smallest < 0) {
            smallest = ratio;
            indexOfSmallest = index;
          }
          index++;
        }
        maxValue -= values[indexOfSmallest];
        maxVolume -= volumes[indexOfSmallest];
        ratioArray[indexOfSmallest] = Double.MAX_VALUE;
      }
    }
    int restVolume = capacity - maxVolume;
    return maxValue + knapSack(values, volumes, restVolume);
  }
}
