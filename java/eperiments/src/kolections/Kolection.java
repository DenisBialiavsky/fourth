package kolections;

import java.util.*;
//return getClass().getName() + "@" + Integer.toHexString(hashCode());
/*
 * 
 * 
 */

interface I1 {
	//public void doSomee();
	public default void doSomee() {
		System.out.println("I1");
	}
	void ds();
}

interface I2 {
	
	//public void doSomee();
	public default void doSomee() {
		System.out.println("I2");
	}
	void ds();
}

class Impl implements I1, I2{//не наследует реализацию

	public void ds() {}

@Override
public void doSomee() {
	// TODO Auto-generated method stub
	I2.super.doSomee();
}





	
}

interface Able {
	default void hire() {
		System.out.println("fddf)");
	}
}

class Kolection implements Able {

	public static int binSearch(int key, int[] ms) {
		int l = 0, r = ms.length - 1, m, res = -1;
		while (l <= r) {
			m = (l + r) / 2;
			if (ms[m] == key) {
				res = m;
				break;
			} else if (ms[m] < key) {
				l = m + 1;
			} else if (ms[m] > key) {
				r = m - 1;
			}
		}
		return res;
	}

	public static int lineSearch(int key, int[] ms) {
		int res = -1;
		for (int i = 0, u = 4; i < ms.length; i++) {
			if (ms[i] == key) {
				res = i;
				break;
			}
		}
		return res;

	}

	public static void main(String[] sd) {
	byte []ms = new byte[] {1,2};
	Integer integ = new Integer(3);
	Long l1 =Long.valueOf(190);
	Long l2 =Long.valueOf(190);
	
	System.out.println(l1==l2);
		String s = new String(ms);
		StringBuilder sbld = new StringBuilder(s);
		System.out.println(Arrays.toString(ms));
		Impl impl = new Impl();
		((I2)impl).doSomee();
		new Kolection().hire();
		int ii = 0;
		int j = 1;
		System.out.println(-7 >> 3);
		System.out.println(ii += (++j < ii) ? 4 : 3.2);
		int array[] = new int[6];
		for (int i = 1; i < array.length;) {
			array[i++] = i++;
		}
		//int ms[] = { 3, 2, 4, 2, 5 };
		byte b = 127;
		b += 5;

		System.out.println(b);
		System.out.println(Arrays.toString(array));
	}

	public void Kolection() {
		// TODO Auto-generated constructor stub
	}

}
