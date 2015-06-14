package com.mei.test;

public class ClassB {
	
	public int num = 0;
	
	private ClassB(){}
	
	private static class ClassBHolder{
		private final static ClassB instance = new ClassB();
	}
	
	public static ClassB getInstance(){
		return ClassBHolder.instance;
	}
	
}
