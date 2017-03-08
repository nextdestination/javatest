package com.sigma.javatest;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

	private int aSize;
	
	private int bSize;
	
	private int cSize;
	
	private List<A> aList;
	
	private List<B> bList;
	
	private List<C> cList;
	
	public Warehouse(int aNumber,int bNumber,int cNumber){
		this.aList = Warehouse.getNumberList(Generator.create(A.class),aNumber);
		this.bList = Warehouse.getNumberList(Generator.create(B.class), bNumber);
		this.cList = Warehouse.getNumberList(Generator.create(C.class), cNumber);
	}
	
	/**
	 * 
	 * @param gen
	 * @param number
	 * @return
	 */
	public static <T> List<T> getNumberList(Generator<T> gen,int number){
		List<T> list = new ArrayList<T>();
		for(int i=0;i<number;i++){
			list.add(gen.next());
		}
		return list;
	}

	public List<A> getaList() {
		return aList;
	}

	public void setaList(List<A> aList) {
		this.aList = aList;
	}

	public List<B> getbList() {
		return bList;
	}

	public void setbList(List<B> bList) {
		this.bList = bList;
	}

	public List<C> getcList() {
		return cList;
	}

	public void setcList(List<C> cList) {
		this.cList = cList;
	}

	public int getaSize() {
		return aList.size();
	}

	public int getbSize() {
		return bList.size();
	}

	public int getcSize() {
		return cList.size();
	}
	
}
