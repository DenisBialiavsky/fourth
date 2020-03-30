package references;

import java.util.*;



class Dog{
	void bark() {
		System.out.println("woof");
			}
}

class Hound extends Dog{
	protected void bark() {
		System.out.println("howl");
	}
}

public class Clone {
	
	public static void main(String df[              ]) {
		Hound dg = new Hound();
		((Dog)new Hound()).bark();
		
		
		
		int m = uy;
		int r = uy,uy =1;
		int c1 =uy;
		int c =Clone.uy;
		

		
		List dl = new ArrayList<Double>();
		dl.add("1jnk");
		System.out.println(System.out.getClass());
		System.out.println(dl.get(0));
		float f =3.0f;
		Double x =new Double( 4d) ;
		tripl(x);
		System.out.println(x);
		//int uy =2;
		System.out.println(uy);
		A a = new A();
		
		a.setI(4);
		if(a instanceof Cloneable) {
			A a1 = a.clone();
		}
	}
	
	
	

	final static int uy=3;
	 int k =9;
	public static void stF(Clone cl) {
		int y = cl.dnF();
	}
	
	public int dnF() {
		int k =2;
		int kk = k;
		int kkk = new Clone().k;
		return 4;
	}
	
	public static void tripl(Double x) {
		x++;
	}
	
	

}

class A implements Cloneable{
	int i ;
	char _1;

	@Override
	protected A clone() {
		A a = new A();
		a.setI(this.i);
		return a;
	}
	
	public int getI(final int ii) {
		return i + ii - ii;
	}

	public void setI(int i) {
		this.i = i;
	}
	
}
