package de.uni_hamburg.ad.graphsuche;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PriorityHeap<T>
{

	private final Comparator<T> _comparator;
	private final int _size;
	private List<T> _heap;

	@SuppressWarnings("unchecked")
	public PriorityHeap()
	{
		this((Comparator<T>) Comparator.naturalOrder());
	}

	public PriorityHeap(T[] arr, Comparator<T> comparator)
	{
		buildHeap(arr);
		_size = arr.length;
		_comparator = comparator;
	}

	public PriorityHeap(Comparator<T> comparator)
	{
		_heap = new ArrayList<>();
		_size = 0;
		_comparator = comparator;
	}

	public T parent(T x)
	{
		int index = _heap.indexOf(x);
		if (index < 1) return null;
		return _heap.get((index - 1) / 2);
	}

	public T left(T x)
	{
		final int index = _heap.indexOf(x);
		final int targetIndex = ((index + 1) * 2) - 1;
		if (index == -1 || targetIndex >= _size)
			return null;

		return _heap.get(targetIndex);
	}

	public T right(T x)
	{
		int index = _heap.indexOf(x);
		if (index == -1 || index >= (_size-1) / 2)
			return null;

		return _heap.get((index + 1) * 2);
	}

	private void buildHeap(T[] arr)
	{
		//TODO: implement
		_heap = new ArrayList<>(Arrays.asList(arr));
	}
}
