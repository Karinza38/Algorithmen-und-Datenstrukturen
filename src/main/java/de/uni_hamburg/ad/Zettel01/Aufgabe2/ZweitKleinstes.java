package de.uni_hamburg.ad.Zettel01.Aufgabe2;

public class ZweitKleinstes
{
	@Deprecated
	public static int zweitKleinstesElement(int[] arr)
	{
		int kleinste = Integer.MAX_VALUE;
		int zweitKleinste = Integer.MAX_VALUE;

		for (int i : arr)
		{
			if (i <= kleinste)
			{
				zweitKleinste = kleinste;
				kleinste = i;
			}
		}

		return zweitKleinste;
	}

	public static int indexVomZweitKleinstenElement(int[] arr)
	{
		int j = 0; // kleinster Index
		int i = 1; // zweit-kleinster Index

		if (arr[j] > arr[i])
		{
			j = 1;
			i = 0;
		}
		for (int c = 2; c < arr.length; ++c)
		{
			if (arr[c] <= arr[j])
			{
				i = j;
				j = c;
			}
			else if (arr[c] < arr[i])
			{
				i = c;
			}
		}

		return i;
	}
}
