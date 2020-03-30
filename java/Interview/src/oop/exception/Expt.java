package oop.exception;



class MyException extends Exception {

}

public class Expt {

	public static void main(String... s) throws MyException {
		try {
			foo();// if Exception is thrown, all bellow will be skipped
			System.out.println("A");
		}
		catch(Exception e) {
			System.out.println("B");
		}
		finally {
			System.out.println("C");
		}
	}
	

	private static void foo() throws MyException{
		try {
			System.out.println("A1");
			throw new MyException();
		}
		catch(Exception e) {
			System.out.println("B1");
			throw new MyException();
		}
		finally {
			System.out.println("C1");
		}
	}
	
}
