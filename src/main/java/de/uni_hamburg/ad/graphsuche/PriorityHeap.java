package de.uni_hamburg.ad.graphsuche;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PriorityHeap<T>
{

	private final Comparator<T> comparator;
	private final int size;
	private List<T> heap;

	@SuppressWarnings("unchecked")
	public PriorityHeap()
	{
		this((Comparator<T>) Comparator.naturalOrder());
	}

	public PriorityHeap(T[] arr, Comparator<T> comparator)
	{
		buildHeap(arr);
		size = arr.length;
		this.comparator = comparator;
	}

	public PriorityHeap(Comparator<T> comparator)
	{
		heap = new ArrayList<>();
		size = 0;
		this.comparator = comparator;
	}

	public T parent(T x)
	{
		int index = heap.indexOf(x);
		if (index < 1) return null;
		return heap.get((index - 1) / 2);
	}

	public T left(T x)
	{
		final int index = heap.indexOf(x);
		final int targetIndex = ((index + 1) * 2) - 1;
		if (index == -1 || targetIndex >= size)
			return null;

		return heap.get(targetIndex);
	}

	public T right(T x)
	{
		int index = heap.indexOf(x);
		if (index == -1 || index >= (size -1) / 2)
			return null;

		return heap.get((index + 1) * 2);
	}

	public boolean isHeap() {
		for(int i = size -1; i > 0; --i) {
			T x = heap.get(i);
			T parent = parent(x);
			if (comparator.compare(x, parent) < 1) return false;
		}
		return true;
	}

	private void buildHeap(T[] arr)
	{
		//TODO: implement
		heap = new ArrayList<>(Arrays.asList(arr));
	}
}
