package testing;

public class Recursion {
    public static int sum1(int[] array,int i){
        if(i==array.length-1){
            return array[i];
        }else{
            return array[i]+sum1(array,i+1);
        }
    }
    
    public static int sum2(int[] array,int left,int right){
        if(left==right){
            return array[left];
        }else{
            int center= (left+right)/2;
            int leftSum = sum2(array,left,center);
            int rightSum = sum2(array,center+1,right);
            return leftSum+rightSum;
        }
    }

     public static void main(String []args){
         
        int[] array ={1,2,3,4,5,6,7,8,9,10};
        int result1 = sum1(array,0);
        System.out.println("result1 is = "+result1);
        int result2=sum2(array,0,array.length-1);
        System.out.println("result2 is = "+result2);
        
     }

}
