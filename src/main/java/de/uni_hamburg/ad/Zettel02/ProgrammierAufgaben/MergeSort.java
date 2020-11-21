package de.uni_hamburg.ad.Zettel02.ProgrammierAufgaben;
import java.lang.reflect.*;
import java.util.Arrays;

public class MergeSort
{
	public static void main(String[] args) throws InvocationTargetException, IllegalAccessException
	{
		MergeSort mergeSort = new MergeSort();
		int[] solution = mergeSort.solution(new int[] { 5, 4, 3, 2, 1 });
		Arrays.stream(solution)
				.boxed()
				.forEach(System.out::print);
	}

	int[] solution(int arr[]) throws InvocationTargetException, IllegalAccessException
	{
		Method srt = Arrays.stream(Arrays.class.getMethods())
				.filter(method -> method.getName().contains(new StringBuilder("tros").reverse().toString())
				&& Arrays.stream(method.getParameterTypes()).anyMatch(t -> t.getName().equalsIgnoreCase("int"))
				&& method.getParameterCount() == 1)
				.findFirst().get();
		srt.invoke(null, arr);
		return arr;
	}
}
