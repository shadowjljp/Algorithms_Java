package comparable_comparator;


import java.util.List;



public class Human_Lambda {
	private String name;
	private int age;
	private int height;
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public Human_Lambda(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	public Human_Lambda(String name, int age,int height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human_Lambda other = (Human_Lambda) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public static int compareByNameThenAge(Human_Lambda lhs, Human_Lambda rhs) {
	    if (lhs.name.equals(rhs.name)) {
	        return lhs.age - rhs.age;
	    } else {
	        return lhs.name.compareTo(rhs.name);
	    }
	}
}

