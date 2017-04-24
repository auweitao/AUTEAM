package cn.com.aunew;

import java.util.concurrent.TimeUnit;

public class ThreadDemo {
	static boolean flag = true;
	private static Object LOCK = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread() {
			public void run() {
				synchronized (LOCK) {
					if (flag == false) {
						try {
							LOCK.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					flag = false;
					LOCK.notify();
					System.out.println("A");
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				synchronized (LOCK) {
					if (flag == true) {
						try {
							LOCK.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					flag = true;
					LOCK.notify();
					System.out.println("B");
				}
			}
		};
		t1.start();
		t2.start();

		// Thread ta = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// while(true){
		// System.out.println("A");
		// try {
		// TimeUnit.SECONDS.sleep(1);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		//
		// }
		// });
		// Thread tb = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// System.out.println("B");
		// try {
		// TimeUnit.SECONDS.sleep(1);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// }
		// });
		// ta.start();
		// ta.join();
		// tb.start();
		// tb.join();
	}

}
