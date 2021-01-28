package de.uni_hamburg.ad.graphsuche;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Comparator;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

class PriorityHeapTest
{

	/*
	Even tree:
						  0
				 ______/ \________
				1					  2
		 ___/   \_	 		  __/  \__
		3			 4			 5			 6
	  / \			/ \		/ \		/ \
	7    8    9   10   11   12   13   14
	Odd tree:
						  0
				 ______/ \________
				1					  2
		 ___/   \_	 		  __/  \__
		3			 4			 5			 6
	  / \			/
	7    8    9
	 */
	@ParameterizedTest
	@CsvSource({ "4,9", "3,7", "0,1" })
	void leftOdd(int source, int expected)
	{
		// Arrange
		PriorityHeap<Integer> heap = createHeap(9);

		// Act
		var leftChild = heap.left(source);

		assertThat(leftChild, is(expected));
	}

	@ParameterizedTest
	@ValueSource(ints = { 5, 13, 14 })
	void invalidLeftOdd(int source)
	{
		// Arrange
		PriorityHeap<Integer> heap = createHeap(9);

		// Act
		var leftChild = heap.left(source);

		assertThat(leftChild, nullValue());
	}

	@ParameterizedTest
	@CsvSource({ "6,13", "3,7", "0,1" })
	void leftEven(int source, int expected)
	{
		// Arrange
		PriorityHeap<Integer> heap = createHeap(14);

		// Act
		var leftChild = heap.left(source);

		assertThat(leftChild, is(expected));
	}

	@ParameterizedTest
	@ValueSource(ints = { 5, 13, 14 })
	void invalidLeftEven(int source)
	{
		// Arrange
		PriorityHeap<Integer> heap = createHeap(9);

		// Act
		var leftChild = heap.left(source);

		assertThat(leftChild, nullValue());
	}

	@ParameterizedTest
	@CsvSource({ "6,14", "3,8", "0,2" })
	void rightEven(int source, int expected)
	{
		// Arrange
		PriorityHeap<Integer> heap = createHeap(14);

		// Act
		var leftChild = heap.right(source);

		assertThat(leftChild, is(expected));
	}

	@ParameterizedTest
	@CsvSource({ "3,8", "0,2" })
	void rightOdd(int source, int expected)
	{
		// Arrange
		PriorityHeap<Integer> heap = createHeap(9);

		// Act
		var leftChild = heap.right(source);

		assertThat(leftChild, is(expected));
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 9, 10})
	void rightInvalid(int source)
	{
		// Arrange
		PriorityHeap<Integer> heap = createHeap(9);

		// Act
		var leftChild = heap.right(source);

		assertThat(leftChild, nullValue());
	}

	@ParameterizedTest
	@CsvSource({ "14,6", "13,6", "7,3", "2,0", "1,0" })
	void parent(int source, int expected)
	{
		// Arrange
		PriorityHeap<Integer> heap = createHeap(14);

		// Act
		var leftChild = heap.parent(source);

		assertThat(leftChild, is(expected));
	}

	@Test
	void isHeap_sorted_isTrue() {
		// Arrange
		PriorityHeap<Integer> heap = createHeap(14);

		// Act
		var isHeap = heap.isHeap();

		assertThat(isHeap, is(true));
	}

	@Test
	void isHeap_2and1_isFalse() {
		// Arrange
		PriorityHeap<Integer> heap = new PriorityHeap<>(new Integer[]{2, 1}, Comparator.naturalOrder());

		// Act
		var isHeap = heap.isHeap();

		assertThat(isHeap, is(false));
	}

	private PriorityHeap<Integer> createHeap(int range)
	{
		return new PriorityHeap<>(IntStream.rangeClosed(0, range).boxed().toArray(Integer[]::new), Comparator.naturalOrder());
	}
}