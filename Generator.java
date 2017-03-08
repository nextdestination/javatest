package com.sigma.javatest;

public class Generator<T>{
	
	private Class<T> type;
	
	public Generator(Class<T> type){
		this.type = type;
	}

	public T next(){
		try {
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}			
	}
	
	public static <T> Generator<T> create(Class<T> type){
		return new Generator<T>(type);
	}
}
