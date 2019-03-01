package org.example.transittime;

public class MyObject {
	
	double a;
	int b;
	
	MyObject(double a, int b) throws IllegalAccessException{
		this.a = a;
		this.b = b;
	}
	
	
	@Override
	public String toString() {
		return "Values are: a="+a+" and b="+b;
	}
	
	static void throwOne() throws IllegalAccessException, NullPointerException{
		throw new IllegalAccessException();
	}
	
	public static void main(String[] args) throws IllegalAccessException, NullPointerException {
		throwOne();
	}

}
