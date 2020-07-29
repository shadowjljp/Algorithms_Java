package mini;

import java.util.ArrayList;

interface FuncInterface 
{ 
    // An abstract function 
    void abstractFun(int x); 
  
    // A non-abstract (or default) function 
    default void normalFun() 
    { 
       System.out.println("Hello"); 
    } 
} 
  
class Test 
{ 
	 public static void main(String args[]) 
	    { 
	        // Creating an ArrayList with elements 
	        // {1, 2, 3, 4} 
	        ArrayList<Integer> arrL = new ArrayList<Integer>(); 
	        arrL.add(1); 
	        arrL.add(2); 
	        arrL.add(3); 
	        arrL.add(4); 
	  
	        // Using lambda expression to print all elements 
	        // of arrL 
	        arrL.forEach(x -> System.out.println(x)); 
	  
	        // Using lambda expression to print even elements 
	        // of arrL 
	        arrL.forEach(n -> { if (n%2 == 0) System.out.println(n); }); 
	    } 
} 
