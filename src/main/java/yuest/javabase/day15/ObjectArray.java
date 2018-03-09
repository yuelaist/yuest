package yuest.javabase.day15;

public class ObjectArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] students=new Student[5];
		students[0]=new Student("忘了",0);
		students[1]=new Student("马跃",28);
		students[2]=new Student("猴年",27);
		students[3]=new Student("狗年",28);
		students[4]=new Student("大吉",29);
		
		for (int i=0;i<students.length;i++){
			System.out.println(students[i]);
		}
//		这里是注释掉student类里的toString（）方法后产生的输出。
//		yuest.javabase.day15.Student@15db9742
//		yuest.javabase.day15.Student@6d06d69c
//		yuest.javabase.day15.Student@7852e922
//		yuest.javabase.day15.Student@4e25154f
//		yuest.javabase.day15.Student@70dea4e

	}

}
