package testing;
interface Payable{
  void makePayment();
}

class Account implements Payable{
  public void makePayment(){
    System.out.println("Paid the account");
  }
}
class Employee1 implements Payable {
  public void makePayment(){
    System.out.println("Paid the Employee1");
  }
}

class HourlyEmployee1 extends Employee1 {
  public void makePayment(){
    System.out.println("Paid the hourly Employee1");
  }
}

public class DemoInterface{
  public static void main(String args[]){
  Account acct1 = new Account();
  Employee1 emp1 = new Employee1();
  HourlyEmployee1 hremp1 = new HourlyEmployee1();

  Payable arr[] = new Payable[3];
  arr[0] = acct1;
  arr[1]=emp1;
  arr[2]=hremp1;

  for(Payable p : arr){
    p.makePayment();
  }

}

}
