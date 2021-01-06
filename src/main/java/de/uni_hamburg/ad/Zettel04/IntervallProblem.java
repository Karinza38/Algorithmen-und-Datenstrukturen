package de.uni_hamburg.ad.Zettel04;

public class IntervallProblem {
  
  public static int[] prepareArray(int[] a, int k){
    final int[] t = new int[k+2];
    
    for(int i: a){
      t[i]++;
    }
    for(int i=k-1; i>=0; i--){
      t[i] = t[i]+t[i+1];
    }
    
    return t;
  }
  
  public static int count(int a, int b, int[] arr){
    a = Math.max(a, 0);
    b = Math.min(b+1, arr.length-1);
    
    return arr[a]-arr[b];
  }
}
