package yuest.javabase.day15;

public class Student {
	private String name ;
	private int age;
	
	//alt+shift+s o
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//alt+ shift+s 
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("unused")
	private String getName() {
		return name;
	}
	@SuppressWarnings("unused")
	private int getAge() {
		return age;
	}
	@SuppressWarnings("unused")
	private void setName(String name) {
		this.name = name;
	}
	@SuppressWarnings("unused")
	private void setAge(int age) {
		this.age = age;
	}
//	@Override
//	public String toString() {
//		return "Student [name=" + name + ", age=" + age + "]";
//	}
//	
	
	
}
