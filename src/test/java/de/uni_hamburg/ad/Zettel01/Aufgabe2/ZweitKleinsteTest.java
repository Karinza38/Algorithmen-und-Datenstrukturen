package de.uni_hamburg.ad.Zettel01.Aufgabe2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Deprecated
class ZweitKleinsteTest
{
	@Test
	public void testeZweitKleinste() {
		// Arrange
		int[] arr = new int[] {5, 7, 2, 9001, 42};

		// Act
		int resultat = ZweitKleinstes.zweitKleinstesElement(arr);

		// Assert
		assertEquals(5, resultat);
	}

	@Test
	public void testeZweitKleinste_zweiGleicheElemente() {
		// Arrange
		int[] arr = new int[] {42, 42};

		// Act
		int resultat = ZweitKleinstes.zweitKleinstesElement(arr);

		// Assert
		assertEquals(42, resultat);
	}

	@Test
	public void testeZweitKleinste_einElemente() {
		// Arrange
		int[] arr = new int[] {42};

		// Act
		int resultat = ZweitKleinstes.zweitKleinstesElement(arr);

		// Assert
		assertEquals(Integer.MAX_VALUE, resultat);
	}

	@Test
	public void testeZweitKleinste_zweiKleinste() {
		// Arrange
		int[] arr = new int[] {5, 2, 7, 2, 9001, 42};

		// Act
		int resultat = ZweitKleinstes.zweitKleinstesElement(arr);

		// Assert
		assertEquals(2, resultat);
	}

	@Test
	public void testeZweitKleinste_zweiZweitKleinstesElement() {
		// Arrange
		int[] arr = new int[] {5, 5, 7, 2, 9001, 42};

		// Act
		int resultat = ZweitKleinstes.zweitKleinstesElement(arr);

		// Assert
		assertEquals(5, resultat);
	}

	@Test
	public void testeZweitKleinste_alleGleich() {
		// Arrange
		int[] arr = new int[] {7, 7 ,7 ,7};

		// Act
		int resultat = ZweitKleinstes.zweitKleinstesElement(arr);

		// Assert
		assertEquals(7, resultat);
	}
}