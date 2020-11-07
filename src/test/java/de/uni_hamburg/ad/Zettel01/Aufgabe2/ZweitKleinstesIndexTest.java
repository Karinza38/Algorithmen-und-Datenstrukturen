package de.uni_hamburg.ad.Zettel01.Aufgabe2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZweitKleinstesIndexTest
{
	@Test
	public void testeZweitKleinste_einElemente() {
		// Arrange
		int[] arr = new int[] {42};

		// Act
		int resultat = ZweitKleinstes.indexVomZweitKleinstenElement(arr);

		// Assert
		assertEquals(0, resultat);
	}

	@Test
	public void testeZweitKleinste_zweiGleicheElemente() {
		// Arrange
		int[] arr = new int[] {42, 42};

		// Act
		int resultat = ZweitKleinstes.indexVomZweitKleinstenElement(arr);

		// Assert
		assertEquals(0, resultat);
	}

	@Test
	public void testeZweitKleinste_fünfVerschiedene() {
		// Arrange
		int[] arr = new int[] {5, 7, 2, 9001, 42};

		// Act
		int resultat = ZweitKleinstes.indexVomZweitKleinstenElement(arr);

		// Assert
		assertEquals(0, resultat);
	}

	@Test
	public void testeZweitKleinste_zweiKleinste() {
		// Arrange
		int[] arr = new int[] {5, 2, 7, 2, 9001, 42};

		// Act
		int resultat = ZweitKleinstes.indexVomZweitKleinstenElement(arr);

		// Assert
		assertEquals(1, resultat);
	}

	@Test
	public void testeZweitKleinste_zweiZweitKleinsteElemente() {
		// Arrange
		int[] arr = new int[] {5, 5, 7, 2, 9001, 42};

		// Act
		int resultat = ZweitKleinstes.indexVomZweitKleinstenElement(arr);

		// Assert
		assertEquals(1, resultat);
	}

	@Test
	public void testeZweitKleinste_alleGleich() {
		// Arrange
		int[] arr = new int[] {7, 7 ,7 ,7};

		// Act
		int resultat = ZweitKleinstes.indexVomZweitKleinstenElement(arr);

		// Assert
		assertEquals(2, resultat);
	}

	@Test
	public void testeZweitKleinste_sortiert() {
		// Arrange
		int[] arr = new int[] {3, 5, 6, 7};

		// Act
		int resultat = ZweitKleinstes.indexVomZweitKleinstenElement(arr);

		// Assert
		assertEquals(1, resultat);
	}

	@Test
	public void testeZweitKleinste_zweiSortierte() {
		// Arrange
		int[] arr = new int[] {1, 2};

		// Act
		int resultat = ZweitKleinstes.indexVomZweitKleinstenElement(arr);

		// Assert
		assertEquals(1, resultat);
	}

	@Test
	public void testeZweitKleinste_fallendSortiert() {
		// Arrange
		int[] arr = new int[] {7, 6, 5, 3};

		// Act
		int resultat = ZweitKleinstes.indexVomZweitKleinstenElement(arr);

		// Assert
		assertEquals(2, resultat);
	}

	@Test
	public void testeZweitKleinste_zweiFallendSortierte() {
		// Arrange
		int[] arr = new int[] {2, 1};

		// Act
		int resultat = ZweitKleinstes.indexVomZweitKleinstenElement(arr);

		// Assert
		assertEquals(0, resultat);
	}
}