package cn.com.aunew;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo1 {
	static class WorkThread extends Thread {
		static int m = 2000000;
		String lock = "LOCK";
		public WorkThread(String name) {
			super(name);
		}

		public void run() {
			while(m>0){
				synchronized(lock){
					if(m>0){
						System.out.println(getName()+"=="+m);
						m--;
					}else{
						System.out.println(getName()+"gg");
					}
				}
//				try {
//					sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		}
	}

	public static void main(String[] args) {
		WorkThread ta = new WorkThread("1");
		WorkThread tb = new WorkThread("2");
		WorkThread tc = new WorkThread("3");
		WorkThread td = new WorkThread("4");
		WorkThread te = new WorkThread("5");
		WorkThread tf = new WorkThread("6");
		WorkThread tg = new WorkThread("7");
		WorkThread th = new WorkThread("8");
		ExecutorService pool = Executors.newCachedThreadPool();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		pool.execute(ta);
		pool.execute(tb);
		pool.execute(tc);
		pool.execute(td);
		pool.execute(te);
		pool.execute(tf);
		pool.execute(tg);
		pool.execute(th);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		pool.shutdown();
//		ta.start();
//		tb.start();
	}
}
