package day_160613;
/**
 * 
 * @author AuWeitao
 * @since 2016-6-21 22:11:10
 *
 */
public class Test01 {
	int a = 1;
	static int b = 2; 
	
	public void aa(){
//		String a;
//		System.out.println(a);
	}

    public static void bb(){
//		System.out.println(a);
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		Test01 t1 =new Test01();
		Test01 t2 =new Test01();
		t1.a++;
		System.out.println(t1.a+"==="+t2.a);
		t2.a++;
		System.out.println(t1.a+"==="+t2.a);
		Test01.b++;
		System.out.println(Test01.b+"==="+Test01.b);
		Test01.b++;
		System.out.println(Test01.b+"==="+Test01.b);
		
		System.out.println(System.getProperty("user.name"));
		System.getProperties().list(System.out);
	}
	


}
