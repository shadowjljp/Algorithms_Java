package dataStructure;

import java.util.ArrayList;
import java.util.List;

public class Optional_parameter {
	public void foo(int a,int... b) {
		System.out.println("a "+a+ " b is "+b[0]);
	}
	public static void main(String[] args) {
		Optional_parameter p =new Optional_parameter();
		List l =  new ArrayList();
		l.add(5);
		p.foo(1, 5);
	}

}
