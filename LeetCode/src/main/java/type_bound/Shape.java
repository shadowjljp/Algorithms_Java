package type_bound;

public class Shape implements Comparable<Shape>{
	public static <AnyType extends Comparable<AnyType>>
	AnyType findMax( AnyType[] arr )
 {
	int maxIndex = 0;
	
	for( int i = 1; i < arr.length; i++ )
	 if( arr[ i ].compareTo( arr[ maxIndex ])>0)
	 maxIndex = i;
	System.out.println("Pass");
	 return arr[ maxIndex ];
	 }
	public static <Shape extends Comparable<Shape>>
	Shape findMax( )
 {
	
	System.out.println("Pass");
	 return null;
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public int compareTo(Shape o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
