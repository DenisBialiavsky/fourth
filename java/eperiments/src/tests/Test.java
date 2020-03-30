package tests;

public class Test {

	/*public static void main(String [] fd) {
		foo4();
		Object o = "";
	}*/

	static void foo1() {
		System.out.println("2 + 2 = " + 2 + 2);
	}
	
	static void foo2() {
		int a =2;
		a = a++ + a++;
		System.out.println("a=" + a);
	}
	
	static void foo3() {
		int[] array = new int[] {1,2,3};
		System.out.println(array[2]);
	}
	
	static void foo4() {
		int [][]array = {{3,4},{0,3,5,7,4},{3,1},{0}};
		System.out.println(array.length);
	}
}
