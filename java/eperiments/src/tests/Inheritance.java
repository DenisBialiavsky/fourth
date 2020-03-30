package tests;

import java.time.LocalDate;
import java.util.Objects;

class A{
	A() {}
	static void m() {
		System.out.println("A m");
	}
	
}
class Inheritance extends A{
	
	Objects u;
	//LocalDate date = LocalDate.of(2018, Mounth.APRIL, arg2)
	
	public Inheritance() {
		super();
	}
	static void m() {
		System.out.println("B m");
	}
	
	public static void main(String [] ds) {
		m();
	}
	
}
class C extends Inheritance{}
class D extends C{}

class Alien{
	String inv(short s) {
		return "";
	}
}


