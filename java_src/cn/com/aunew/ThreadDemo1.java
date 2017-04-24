package cn.com.aunew;

class Info {
	    String printStr = "i think this is ok";
     int i = 0;

	    public void print() {
	       if (i < printStr.length()) {
             System.out.println(Thread.currentThread().getName() + "  print   "
	                    + printStr.charAt(i));
	            i++;
	         }
	    }
	 }
public class ThreadDemo1 {
     private static Object LOCK = new Object();
     static Info info = new Info(); // ������Դ
     static boolean flag = false; // false for a ,true for b
 
     public static void main(String[] args) {
         // �����߳� �����ӡ�ַ���
         Thread a = new Thread() {
             public void run() {
                 while (info.i < info.printStr.length())
                     synchronized (LOCK) {
                         {
                             if (false == flag) {
                                 try {
                                    LOCK.wait();// ��wait���˲���߳�b�õ���
                                 } catch (InterruptedException e) {
                                     e.printStackTrace();
                                 }
                             }
                             flag = false;
                             info.print();
                             LOCK.notify();// ��������Ȼ��������һ���߳�b��������û���ͷ�
                         }
                     }
             };
         };
         Thread b = new Thread() {
             public void run() {
                 while (info.i < info.printStr.length())
                     synchronized (LOCK) {
                         {
                             if (true == flag) {
                                 try {
                                     LOCK.wait();// ��wait���˲���߳�b�õ���
                                 } catch (InterruptedException e) {
                                     e.printStackTrace();
                                 }
                             }
                             flag = true;
                             info.print();
                             LOCK.notify();// ��������Ȼ��������һ���߳�b��������û���ͷ�
                         }
                     }
             };
         };
         a.start();
         b.start();
     }
 
 }
