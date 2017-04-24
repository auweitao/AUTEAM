package cn.com.aunew;

public class ArrayDemo {
	public static void main(String[] args){
		String a = "AB";
		String b = "ABC";
		String c = a+"C";
		String d = "A"+"BC";
		System.out.println(b==c);
		System.out.println(b==d);
		System.out.println(c==d);
		
		System.out.println("-----------");
		
		char[] a1 = new char[2];
		a1[0] = 'a';
		a1[1] = 'a';
		char[] a2 = new char[2];
		a2[0] = 'a';
		a2[1] = 'a';
		System.out.println(a1.equals(a2));
		System.out.println(a2[0] == a2[1]);
	}
}
