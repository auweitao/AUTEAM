package cn.com.aunew;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo4 {
	static class Info {
		int i = 0;
		List<String> s = null;
		public Info(List s){
			this.s = s;
		}
		public void prt(){
//			for (String string : s) {
//				System.out.println(Thread.currentThread().getName()+"--"+string);
//			}
			for (;i<s.size();i++) {
				System.out.println(Thread.currentThread().getName()+"--"+s.get(i));
			}
		}
	}
	static class ThreadA extends Thread{
		Info in = null;
		public ThreadA(Info in){
			this.in= in;
		}
		public void run() {
			in.prt();
		}
	}
	static class ThreadB extends Thread{
		Info in = null;
		public ThreadB(Info in){
			this.in= in;
		}
		public void run() {
			in.prt();
		}
	}


	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		for (int i = 1;i<100;i++) {
			a.add(Integer.valueOf(i).toString());
		}
//		a.add("a");
//		a.add("b");
//		a.add("c");
//		a.add("d");
//		a.add("e");
//		a.add("f");
//		a.add("g");
//		a.add("h");
//		a.add("i");
		Info in = new Info(a);
		ThreadA ta = new ThreadA(in);
		ThreadB tb = new ThreadB(in);
		ExecutorService pool = Executors.newCachedThreadPool();
		pool.execute(ta);
		pool.execute(tb);
//		ta.start();
//		tb.start();
		pool.shutdown();
	}
	
}
