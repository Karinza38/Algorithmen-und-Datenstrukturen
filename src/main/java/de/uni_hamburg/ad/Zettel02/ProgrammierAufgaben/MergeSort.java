package de.uni_hamburg.ad.Zettel02.ProgrammierAufgaben;

import java.util.Arrays;

public class MergeSort
{
	public static void main(String[] args)
	{
		MergeSort mergeSort = new MergeSort();
		int[] solution = mergeSort.solution(new int[] { 5, 4, 3, 2, 1 });
		Arrays.stream(solution)
				.boxed()
				.forEach(System.out::print);
	}

	int[] solution(int[] arr)
	{
		mergeSort(0, arr.length-1, arr);
		return arr;
	}

	void mergeSort(int l, int r, int[] arr)
	{
		if (l < r)
		{
			int m = (l + r) / 2;
			mergeSort(l, m, arr);
			mergeSort(m + 1, r, arr);
			merge(l, r, m, arr);
		}
	}

	void merge(int l, int r, int m, int[] arr)
	{
		int n1 = m - l + 1;
		int n2 = r - m;
		int[] arrL = new int[n1 + 1],
				arrR = new int[n2 + 1];
		int i, j;
		for (i = 0; i < n1; ++i) arrL[i] = arr[l + i];
		for (j = 0; j < n2; ++j)
			arrR[j] = arr[m + 1 + j];
		arrL[n1] = Integer.MAX_VALUE;
		arrR[n2] = Integer.MAX_VALUE;
		i = 0;
		j = 0;
		for (int k = l; k <= r; ++k)
		{
			if (arrL[i] <= arrR[j])
			{
				arr[k] = arrL[i];
				i++;
			}
			else
			{
				arr[k] = arrR[j];
				j++;
			}
		}
	}
}
