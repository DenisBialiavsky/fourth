package references;

class AAA {
	public Object fo() {
		return new Object();
	}

	public final static void done() {

	}
}

class BBB extends AAA {
	public String fo() {
		return "B-class";
	}

}

public class DemoObject {

	public static void main(String[] ijo) {

		System.out.println("integer " + intgr);// null
		String s12 = "abc";
		String s13 = new String("abc");
		System.out.println(s13 == "abc");// false
		int x = 0, y = 0;
		System.out.println("++x + ++x = " + (++x + ++x + x-- + ++x));
		long l = 1;
		Object o1 = new Object();
		Object o2 = o1;
		System.out.println(o1.getClass());
		System.out.println(o1.hashCode() + "       " + o2.hashCode());
		System.out.println(o1.toString() + "       " + o2.toString());
		System.out.println(o1.getClass() + "       " + o2.getClass());
		double e = Math.E;
		DemoObject oo = new DemoObject();
	}

	int dgfs = +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+3;

	// final static int DemoObject =3;
	char DemoObject = 'd';
	{
		System.out.println("1");
	}
	static {
		int y = 32;
		System.out.println("2");
	}

	static Integer intgr;

	// object.hashCode(); cheks references

	public final static void dsf() {

	}
}