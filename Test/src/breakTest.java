import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class breakTest {

	public static void main(String[] args) {
		for(int j=0;j<3;j++) {
			  for (int i = 0; i < 10; i++) {
			      if (i == 4) {
			        break;
			      }
			      System.out.println(i);
			    }  
			  System.out.println("next round \n");
		}
	  ArrayList<String> a = new ArrayList<>();
	  StringBuilder sb = new StringBuilder();
	  sb.append("tester");
	  
	  a.add(sb.toString());
	  sb.setLength(0);
	  sb.append("ggggg");
	  a.add(sb.toString());
	  for(String re:a) {
		  System.out.println(re);
	  }
	  int a1[][] = {{1,2},{3,4},{5,6}};
		 System.out.println(a1[0].length);
		 int re = (int) Math.sqrt(Math.pow(a1.length, 2)+Math.pow(a1[0].length, 2));
		 System.out.println("sqrt "+re);
		 System.out.println("---------------------------- ");
		 Random r = new Random();
		 char tt = (char)(97+r.nextInt(26));
		 System.out.println(97+r.nextInt(26));
		 System.out.println(tt);
		 
		 String s = " 10 \n 10 \n GeeksForGeeks "; 
		  
	        // create a new scanner 
	        // with the specified String Object 
	        Scanner scanner = new Scanner(s); 
	  
	        // print the next line 
	        System.out.println(scanner.nextInt()); 
	  
	        // print the next line again 
	        System.out.println(scanner.nextInt()); 
	  
	        // print the next line again 
	        scanner.nextLine();
	        System.out.println(scanner.nextLine()); 
	  
	        scanner.close(); 
	  }
		
	
	

}
