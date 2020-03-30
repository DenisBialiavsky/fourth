package oop.clone;

//no constructor -> time creating off
//final fields problem
class MyObject implements Cloneable{
	int i;
	NewObject newObject;
	
	public MyObject() {
		
	}
	
	public MyObject(MyObject myObject) {
		i = myObject.i;
		//newObject = myObject.newObject;
		newObject = new NewObject(myObject.newObject);
	}
	
	@Override
	protected MyObject clone() throws CloneNotSupportedException {
		MyObject myObject = (MyObject) super.clone();
		myObject.newObject = (NewObject) newObject.clone();
		return myObject;
	}
	
}

class NewObject implements Cloneable{
	int j;

	public NewObject() {
		
	}
	
	public NewObject(NewObject newObject) {
		j = newObject.j;
	}
	
	@Override
	protected NewObject clone() throws CloneNotSupportedException {
		return (NewObject) super.clone();
	}
	
}

class AE{
	public void m(Number y) {
		System.out.println("NUm");
	}
	public void m(Integer y) {
		System.out.println("Integ");
	}
}

public class CloneTest {

	public static void main(String ...ew) throws CloneNotSupportedException {
		AE ae = new AE();
		Number n  = new Integer(4);
		ae.m(new Integer(3));
		MyObject myObject = new MyObject();
		myObject.i=4;
		NewObject newObject = new NewObject();
		newObject.j = 9;
		myObject.newObject = newObject;
		MyObject clone = myObject.clone();
		clone.i = 77;
		clone.newObject.j =55;
		System.out.println(myObject.newObject.j);
	}

}
