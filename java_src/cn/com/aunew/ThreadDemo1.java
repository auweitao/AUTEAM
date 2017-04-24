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
     static Info info = new Info(); // 互斥资源
     static boolean flag = false; // false for a ,true for b
 
     public static void main(String[] args) {
         // 两个线程 交替打印字符串
         Thread a = new Thread() {
             public void run() {
                 while (info.i < info.printStr.length())
                     synchronized (LOCK) {
                         {
                             if (false == flag) {
                                 try {
                                    LOCK.wait();// 在wait后的瞬间线程b得到锁
                                 } catch (InterruptedException e) {
                                     e.printStackTrace();
                                 }
                             }
                             flag = false;
                             info.print();
                             LOCK.notify();// 在这里虽然唤醒了另一个线程b，但锁并没有释放
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
                                     LOCK.wait();// 在wait后的瞬间线程b得到锁
                                 } catch (InterruptedException e) {
                                     e.printStackTrace();
                                 }
                             }
                             flag = true;
                             info.print();
                             LOCK.notify();// 在这里虽然唤醒了另一个线程b，但锁并没有释放
                         }
                     }
             };
         };
         a.start();
         b.start();
     }
 
 }
