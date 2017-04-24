package cn.com.aunew;

class Info1 {
	String printStr = "i think this is ok";
	int i = 0;
	boolean flag = false;

	public void print1() {
		synchronized (this) {
			if (flag == false) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			realprint();
			System.out.println("aaaaa");
			flag = false;
			notify();
		}
	}

	public void print2() {
		synchronized (this) {
			if (flag == true) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			realprint();
			flag = true;
			notify();
		}
	}

	public void realprint() {
		if (i < printStr.length()) {
			System.out.println(Thread.currentThread().getName() + "  print   " + printStr.charAt(i));
			i++;
		}
	}
}

class MyThread1 extends Thread {
	public Info1 Info1 = null;

	public MyThread1(Info1 in) {
		this.Info1 = in;
	}

	@Override
	public void run() {
		while (Info1.i < Info1.printStr.length())
			Info1.print2();
	}
}

class MyThread2 extends Thread {
	public Info1 Info1 = null;

	public MyThread2(Info1 in) {
		this.Info1 = in;
	}

	@Override
	public void run() {
		while (Info1.i < Info1.printStr.length())
			Info1.print1();
	}
}

public class ThreadDemo2 {
	public static void main(String[] args) {
		// 两个线程 交替打印字符串
		Info1 Info1 = new Info1(); // 互斥资源
		MyThread1 mthread1 = new MyThread1(Info1);
		MyThread2 mthread2 = new MyThread2(Info1);
		mthread1.start();
		mthread2.start();
//		new Thread(mthread1).start();
//		new Thread(mthread2).start();
	}

}
