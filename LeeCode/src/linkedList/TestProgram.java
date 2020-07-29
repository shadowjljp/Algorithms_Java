package linkedList;

import java.util.Comparator;

class SomeClass
{
   // Precondition: arr.length > 0.
   public static <AnyType>
       AnyType findMax( AnyType [ ] arr, Comparator<? super AnyType> cmp )
  {
      int maxIndex = 0 ;
      for ( int i = 1; i < arr.length ; i++ )
         if( cmp.compare( arr[ i ], arr[ maxIndex ] ) > 0 )
            maxIndex = i;
      return arr[ maxIndex ];
   }
}

class CaseInsensitiveCompare implements Comparator<String>
{
   public int compare( String lhs, String rhs )
   { return lhs.compareTo( rhs ) ;  }
}
public class TestProgram
{
   public static void main( String [ ] args )
   {
      String [ ] arr = { "ZEBRA", "alligator", "crocodile" } ;
       System.out.println( SomeClass.findMax( arr, 
                      new CaseInsensitiveCompare( ) ) ) ;
   }
}

