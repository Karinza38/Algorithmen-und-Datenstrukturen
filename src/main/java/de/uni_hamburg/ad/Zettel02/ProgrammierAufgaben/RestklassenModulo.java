package de.uni_hamburg.ad.Zettel02.ProgrammierAufgaben;

public class RestklassenModulo
{
	public static void main(String[] args) {
		RestklassenModulo restklassenModulo = new RestklassenModulo();
		long l;
		l = restklassenModulo.expo(1, 0, 99);
		System.out.println(l);
		l = restklassenModulo.expo(2, 1, 99);
		System.out.println(l);
		l = restklassenModulo.expo(2, 3, 99);
		System.out.println(l);
		l = restklassenModulo.expo(100, 100, 1000000007L);
		System.out.println(l);
		long t = System.currentTimeMillis();
		l = restklassenModulo.expo(100, 1_000_000_000L, 10_000_000_000L);
		System.out.println(System.currentTimeMillis()-t);
		System.out.println(l);
	}

	long expo(long a,long b,long c){
		if (b == 0) return 1;
		long res = 1; //res = a^b
		while(b > 0) {
			res *= a;
			res %= c;
			b--;
		}
		return res;
	}
}
