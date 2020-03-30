package tests;

import java.math.BigDecimal;
import java.util.Arrays;

class Plant {
	private final String str ="fgdgfd";
	String getName() {
		return "plant";
	}

	Plant getType() {
		return this;
	}
}

class Flower extends Plant {
	String gerType() {
		return "this";
	}
}

class Tulip extends Flower {

}

class Dandr extends Flower {

}

/*
 * class Double extends Tulip{ int pp=3; }
 */

public class Constr {

	public Constr() {
		super();
	}

	private static Boolean b1 = false, b2;

	public static strictfp void main(String[] ret) {
		
		Flower flower = new Tulip();
		Tulip tulip = new Tulip();
		Dandr pulip =(Dandr) flower;
		flower = tulip;
		float ty = 4.0f + 2;
		ty = ty +4;
		int yu=0;
		while(yu++<10);
		

		int ir[][] = { { 3, 2, 5 ,}, { 23, 1, 4, } };

		int jf = 1;
		System.out.println(++jf + ++jf);

		if (true && true && true) {
		}

		int op = 1;
		int ms[] = new int[] { 4, 2, 20, 9, 0, 3, 8, 1 };
		for (int i = 0; i < ms.length; i++) {
			for (int j = ms.length - 1; j > i; j--) {
				if (ms[j - 1] > ms[j]) {
					int c = ms[j];
					ms[j] = ms[j - 1];
					ms[j - 1] = c;
				}

			}
		}
		for (int i = 0; i < ms.length; i++) {
			System.out.println(ms[i]);
		}

		int l = 0, r = ms.length - 1, m = ms.length / 2, ek = 20;
		while (l <= r) {
			m = (r + l) / 2;
			if (ms[m] == ek) {
				break;
			} else if (ms[m] < ek) {
				l = m + 1;

			} else if (ms[m] > ek) {
				r = m - 1;
			}
		}
		System.out.println("m = " + m);

		final long Byte = 3;
		char ccj = 1;
		System.out.println(new BigDecimal(0.3));
		System.out.println(new BigDecimal(0.05 + 0.05));

		Class da = b1.getClass();
		// Double dbl = new Double();
		// dbl.pp=2;

		switch (1) {

		}

		System.out.println(0.3 == 0.1 + 0.2);
		Boolean f = (Boolean) b1;
		// System.out.println(f);
		Constr inst = new Constr();
		System.out.println(b2 == inst.b2);
		System.out.println(b1 || !b2 || !b1 || b2);

		E e = new E();
		e.proc("dc", "fdf", "d");
		e.proc("dc");
		e.proc("dc", "sv");

	}

};

class E {

	void proc(String... r) {
		System.out.println("Quite a while");
		Alien al = new Alien();
		al.inv((short) 7);
	}

	void proc(String s) {
		System.out.println("1");
	}

	void proc(String s, String t) {
		System.out.println("2");
	}

	E() {

	}
};
