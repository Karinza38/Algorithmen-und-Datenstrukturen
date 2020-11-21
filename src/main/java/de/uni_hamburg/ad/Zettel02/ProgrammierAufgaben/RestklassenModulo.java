package de.uni_hamburg.ad.Zettel02.ProgrammierAufgaben;

public class RestklassenModulo
{
	public static void main(String[] args) {
		RestklassenModulo restklassenModulo = new RestklassenModulo();
		long l;
		l = restklassenModulo.expo(1, 0, 99);
		System.out.println("1 = " + l);
		l = restklassenModulo.expo(2, 1, 99);
		System.out.println("2 = " + l);
		l = restklassenModulo.expo(2, 3, 99);
		System.out.println("8 = " + l);
		l = restklassenModulo.expo(100, 100, 1000000007L);
		System.out.println("424090053 = " + l);
		long t = System.nanoTime();
		l = restklassenModulo.expo(100, 1_000_000_000L, 10_000_000_000L);
		System.out.println(System.nanoTime()-t);
		System.out.println("0 = " + l);
	}

	long expo(long a, long b, long c) {
		if (b == 0) return 1;
		if (b%2 == 0) {
			long сука = expo(a, b/2, c) % c;
			return (сука * сука) % c;
		}
		return a * expo(a, b-1, c) % c;
	}
}
