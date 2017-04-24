package day_160613;

public class SubStringDemo {
	public static String subString(String str,String str1,String str2){
		str += "                          ";
		char[] ch = str.toCharArray();
		String temp = "";
		
		boolean flag = false;
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		
		for(int k = 0; k < ch.length; k++){
			int m,n;
			for(m = 0; m < ch1.length; m++){
//				System.out.println("ch[m+k]:"+ch[m+k]);
//				System.out.println("ch1[m:"+ch1[m]);
				if(ch[m+k] != ch1[m]){
					break;
				}
			}
			if(m == str1.length()){
				k = k+m;
				flag = true;
			}
//			System.out.println("kkkk:"+k);
			if(flag == true){
				temp += ch[k];
//				System.out.println("temp:"+temp);
				for(m = 0; m < ch2.length; m++){
//					System.out.println("ch[m+k+1]:"+ch[m+k+1]);
//					System.out.println("ch2[m:"+ch2[m]);
					if(ch[m+k+1] != ch2[m]){
						break;
					}
				}
				if(m == str2.length()){
					flag = false;
					break;
				}
			}
		}
		return temp;
	}
	
	public static void main(String[] args) {
		String aa = "<0>ABC</0><0>ABCDE</0><0>ABC\nDEFGH</0><0>ABCDEF</0>";
		String[] tt = new String[10];
		for(int i = 0;i < 10;i++){
			String str1 = "<0>";
			String str2 = "</0>";
			tt[i] = subString(aa,str1,str2);
			System.out.println(tt[i]);
		}
	}
}
