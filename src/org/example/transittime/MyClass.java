package org.example.transittime;

public class MyClass {

	private String privateString = "default string";

	public String getPrivateString() {
		return privateString;
	}

	public void setPrivateString(String privateString) {
		this.privateString = privateString;
	}
	
	protected void myProtectedMethod(){
		System.out.println("protected");
	}
	
}
