package references;

public class InitBlock {
	
	private static int b = InitBlock.a;
	public static final int a = 3;
	
	public InitBlock() {
		System.out.println("Constructor");
	}
	
	String strA;
	int intA;
	
	{
		strA = "strAValue";
		System.out.println("Dainamic initialization block;");
	}
	
	
	static {
		st = "new static field";
		System.out.println("Static initialization block;");
	}
	
	static String st;
	
	public int meth() {
		return 4;
	}
	
	public static int Smeth() {
		return 4;
	}
	
	
	
	/*static public void main(String ... str) {
		System.out.println("a = " + a + ", b = " + b);
		InitBlock ib = new InitBlock();
		InitBlock ib1 = new InitBlock();
		InitBlock ib2 = new InitBlock();
		//ib.strA;
		ib.meth();
		Smeth();
		//B.st ="def";
		B.main("sdd");
		
	}*/
}

class B extends InitBlock{
	public B() {
		System.out.println("ConstructorB");
	}
	
	String strA;
	int intA;
	
	{
		strA = "strAValueB";
		System.out.println("Dainamic initialization blockB;");
	}
	
	
	static {
		st = "new static fieldB";
		System.out.println("Static initialization blockB;");
	}
	
	static void main(String  n) {
		System.out.println("mainB  " + n);
	}
	
	static String st;
}
