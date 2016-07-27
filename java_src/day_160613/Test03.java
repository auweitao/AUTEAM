package day_160613;

import java.nio.ByteBuffer;
import java.util.Arrays;

/** 
 * @author  auweitao 
 * @date 创建时间：2016年7月27日 下午8:48:16 
 * @version 1.0 
 */
public class Test03 {
	public static void main(String[] args) {
//		int[] intArray = { 1, 2, 3, 4, 5 };  
//		int[] removed = ArrayUtils.removeElement(intArray, 3);//create a new array  
//		System.out.println(Arrays.toString(removed));  
		byte[] bytes = ByteBuffer.allocate(4).putInt(8).array();  
		for (byte t : bytes) {  
		   System.out.format("0x%x ", t);  
		}  
	}
}
