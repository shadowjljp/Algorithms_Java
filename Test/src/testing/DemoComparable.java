package testing;

class Employee implements Comparable<Employee>
{
  private String name;
  private int age;

  Employee (String n, int a){
    name=n;
    age=a;
  }
  
public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}
public int compareTo(Employee o){
    if(age>o.getAge())
      return 1;
    else if (age<o.getAge())
      return -1;
    else
      return 0;
  }
public String toString() {
	return name;
	
}
}






public class DemoComparable{
  public static Employee findOldest(Employee arr[]){
    //assume arr is not empty
	  Employee oldest = arr[0];
    for (Employee e:arr){
      if(e.compareTo(oldest)>0)
        oldest=e;
    }
	return oldest;
  }
public static void main(String args[]){
  Employee arr[]={new Employee("Joe",32),
                  new Employee("Sue",47),
                  new Employee("Bob",28)};
  Employee oldest = findOldest(arr);
  System.out.println("Oldest is:"+oldest);
}
  
  }



