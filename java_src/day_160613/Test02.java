package day_160613;

import java.util.Random;

import static net.mindview.util.Print.*;
import net.mindview.util.Range;

/** 
 * @author  auweitao 
 * @date ����ʱ�䣺2016��6��22�� ����9:27:29 
 * @version 1.0 
 */
public class Test02 {
	public static void main(String[] args) {
		Random x = new Random();
		System.out.println(x.nextBoolean());
		System.out.println(Math.random());
		System.out.println(Math.random());
		
		Range ran = new Range();
		for(int i : ran.range(10)){
			printnb(i+" ");
		}
	}
}
