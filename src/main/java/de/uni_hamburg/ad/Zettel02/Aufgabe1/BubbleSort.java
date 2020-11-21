package de.uni_hamburg.ad.Zettel02.Aufgabe1;

import java.util.Arrays;

public class BubbleSort
{
	public static void main(String[] args)
	{
		BubbleSort bubbleSort = new BubbleSort();
		int[] arr = new int[] { 6, 7, 3, 1, 9, 5, 2 };
		bubbleSort.sort(arr);
		Arrays.stream(arr).boxed().forEach(System.out::print);
	}

	private void sort(int[] arr)
	{
		boolean s = true;
		int iterations = 0;
		int swaps = 0;
		while (s)
		{
			iterations++;
			s = false;
			for (int i = 0; i < (arr.length - 1); ++i)
			{
				if (arr[i] > arr[i + 1])
				{
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					s = true;
					swaps++;
				}
			}
			System.out.print("Nach schleife " + iterations + ": ");
			Arrays.stream(arr).boxed().forEach(System.out::print);
			System.out.println(" swaps: " + swaps);
		}
	}

}
