package com.sigma.javatest;

import java.util.ArrayList;
import java.util.List;

public class Strangy {
	public static void main(String[] args) {
		Warehouse w1 = new Warehouse(1,2,2);
		Warehouse w2 = new Warehouse(2,1,2);
		Warehouse w3 = new Warehouse(1,3,1);
		List<A> result = (List<A>)cal(A.class,4,w1,w2,w3);
	}
	
	@SuppressWarnings("unchecked")
	private static List cal(Class clz,int number,Warehouse w1,Warehouse w2,Warehouse w3){
		List result = null;
		if(clz==A.class){
			result = new ArrayList<A>();
			//一个仓库可以满足供货要求
			if(number<=w3.getaSize()){
				System.out.println("所有商品均来自w3仓库");
				result.addAll(w3.getaList().subList(0, number-1)); //从w3中取出所需数量商品
				return result;
			}else if(number<=w2.getaSize()){
				System.out.println("所有商品均来自w2仓库");
				result.addAll(w2.getaList().subList(0, number-1));
				return result;
			}else if(number<=w1.getaSize()){
				System.out.println("所有商品均来自w1仓库");
				result.addAll(w1.getaList().subList(0, number-1));
				return result;
			}
			//两个仓库可以满足要求
			if(number<=w3.getaSize()+w2.getaSize()){
				result.addAll(w3.getaList());       //将w3仓库a产品全部出货
				result.addAll(w2.getaList().subList(0, (number-w3.getaSize()-1)));                    //剩余部分从w2仓库出货
				System.out.println("商品有"+w3.getaSize()+"个来自w3，有"+(number-w3.getaSize())+"来自w2");
				return result;
			}else if(number<=w3.getaSize()+w1.getaSize()){
				//类似
				result.addAll(w3.getaList());       //将w3仓库a产品全部出货
				result.addAll(w1.getaList().subList(0, (number-w3.getaSize()-1)));                    //剩余部分从w2仓库出货
				System.out.println("商品有"+w3.getaSize()+"个来自w3，有"+(number-w3.getaSize())+"来自w1");
				return result;
			}else if(number<=w2.getaSize()+w1.getaSize()){
				result.addAll(w2.getaList());       //将w3仓库a产品全部出货
				result.addAll(w1.getaList().subList(0, (number-w2.getaSize()-1)));                    //剩余部分从w2仓库出货
				System.out.println("商品有"+w2.getaSize()+"个来自w2，有"+(number-w2.getaSize())+"来自w1");
				return result;
			}
			//三个仓库才能满足
			if(number<=w3.getaSize()+w2.getaSize()+w1.getaSize()){
				result.addAll(w3.getaList());       //将w3仓库a产品全部出货
				result.addAll(w2.getaList()); 
				result.addAll(w1.getaList().subList(0, (number-w3.getaSize()-w2.getaSize()-1))); 
				System.out.println("商品有"+w3.getaSize()+"个来自w3，有"+"商品有"+w2.getaSize()+"个来自w2，有"+(number-w3.getaSize()-w2.getaSize())+"来自w1");
				return result;
			}//三个仓库才能满足
			if(number>w3.getaSize()+w2.getaSize()+w1.getaSize()){ 
				System.out.println("供货不足");
				return null;
			}
		}else if(clz==B.class){
			result = new ArrayList<B>();
			//与a产品计算类似 ...
		}if(clz==C.class){
			result = new ArrayList<C>();
			//与a产品计算类似 ...
		}
		return result;
	}
}
