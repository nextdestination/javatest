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
			//һ���ֿ�������㹩��Ҫ��
			if(number<=w3.getaSize()){
				System.out.println("������Ʒ������w3�ֿ�");
				result.addAll(w3.getaList().subList(0, number-1)); //��w3��ȡ������������Ʒ
				return result;
			}else if(number<=w2.getaSize()){
				System.out.println("������Ʒ������w2�ֿ�");
				result.addAll(w2.getaList().subList(0, number-1));
				return result;
			}else if(number<=w1.getaSize()){
				System.out.println("������Ʒ������w1�ֿ�");
				result.addAll(w1.getaList().subList(0, number-1));
				return result;
			}
			//�����ֿ��������Ҫ��
			if(number<=w3.getaSize()+w2.getaSize()){
				result.addAll(w3.getaList());       //��w3�ֿ�a��Ʒȫ������
				result.addAll(w2.getaList().subList(0, (number-w3.getaSize()-1)));                    //ʣ�ಿ�ִ�w2�ֿ����
				System.out.println("��Ʒ��"+w3.getaSize()+"������w3����"+(number-w3.getaSize())+"����w2");
				return result;
			}else if(number<=w3.getaSize()+w1.getaSize()){
				//����
				result.addAll(w3.getaList());       //��w3�ֿ�a��Ʒȫ������
				result.addAll(w1.getaList().subList(0, (number-w3.getaSize()-1)));                    //ʣ�ಿ�ִ�w2�ֿ����
				System.out.println("��Ʒ��"+w3.getaSize()+"������w3����"+(number-w3.getaSize())+"����w1");
				return result;
			}else if(number<=w2.getaSize()+w1.getaSize()){
				result.addAll(w2.getaList());       //��w3�ֿ�a��Ʒȫ������
				result.addAll(w1.getaList().subList(0, (number-w2.getaSize()-1)));                    //ʣ�ಿ�ִ�w2�ֿ����
				System.out.println("��Ʒ��"+w2.getaSize()+"������w2����"+(number-w2.getaSize())+"����w1");
				return result;
			}
			//�����ֿ��������
			if(number<=w3.getaSize()+w2.getaSize()+w1.getaSize()){
				result.addAll(w3.getaList());       //��w3�ֿ�a��Ʒȫ������
				result.addAll(w2.getaList()); 
				result.addAll(w1.getaList().subList(0, (number-w3.getaSize()-w2.getaSize()-1))); 
				System.out.println("��Ʒ��"+w3.getaSize()+"������w3����"+"��Ʒ��"+w2.getaSize()+"������w2����"+(number-w3.getaSize()-w2.getaSize())+"����w1");
				return result;
			}//�����ֿ��������
			if(number>w3.getaSize()+w2.getaSize()+w1.getaSize()){ 
				System.out.println("��������");
				return null;
			}
		}else if(clz==B.class){
			result = new ArrayList<B>();
			//��a��Ʒ�������� ...
		}if(clz==C.class){
			result = new ArrayList<C>();
			//��a��Ʒ�������� ...
		}
		return result;
	}
}
