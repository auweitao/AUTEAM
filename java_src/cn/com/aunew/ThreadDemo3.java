package cn.com.aunew;

//打印机类
public class ThreadDemo3 {

	private boolean hasBufferToPrint = false; // 打印缓冲区是否有内容可以打印

	// 打印A：相当于生产者，放一张纸
	public synchronized void printA() {
		while (hasBufferToPrint) { // 缓冲区还有内容
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.print("A");
		hasBufferToPrint = true;

		notify(); // 唤醒打印B的线程
	}

	// 打印B：相当于消费者，消耗缓冲区中的纸，打印纸张
	public synchronized void printB() {
		while (!hasBufferToPrint) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.print("B");
		hasBufferToPrint = false;

		notify(); // 唤醒打印A的线程
	}

	static class ThreadA extends Thread {
		private ThreadDemo3 printer;

		public ThreadA(ThreadDemo3 printer) {
			this.printer = printer;
		}

		public void run() {
			for (int i = 0; i < 1000; i++) {
				// while(true){
				printer.printA();
			}
		}
	}

	static class ThreadB extends Thread {
		private ThreadDemo3 printer;

		public ThreadB(ThreadDemo3 printer) {
			this.printer = printer;
		}

		public void run() {
			for (int i = 0; i < 1000; i++) {
				// while(true){
				printer.printB();
			}
		}
	}

	public static void main(String args[]) {
		ThreadDemo3 printer = new ThreadDemo3(); // A、B线程共享同一个打印机
		Thread a = new ThreadA(printer);
		Thread b = new ThreadB(printer);

		a.start();
		b.start();
	}
	
}