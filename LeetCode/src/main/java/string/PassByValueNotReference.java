package string;

public class PassByValueNotReference {

	public static void main(String[] args){  
        int[] toyNumber = {5};   
        PassByValueNotReference temp = new PassByValueNotReference();  
        temp.play(toyNumber);  
        System.out.println("Toy number in main " + toyNumber[0]);  
    }

    void play(int[] toyNumber){  
    	 System.out.println("Toy number in play " + toyNumber[0]);   
    	    toyNumber[0]++;  
    	    System.out.println("Toy number in play after increement " + toyNumber[0]); 
    }   
}
