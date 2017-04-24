package cn.com.aunew;

//��ӡ����
public class ThreadDemo3 {

	private boolean hasBufferToPrint = false; // ��ӡ�������Ƿ������ݿ��Դ�ӡ

	// ��ӡA���൱�������ߣ���һ��ֽ
	public synchronized void printA() {
		while (hasBufferToPrint) { // ��������������
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.print("A");
		hasBufferToPrint = true;

		notify(); // ���Ѵ�ӡB���߳�
	}

	// ��ӡB���൱�������ߣ����Ļ������е�ֽ����ӡֽ��
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

		notify(); // ���Ѵ�ӡA���߳�
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
		ThreadDemo3 printer = new ThreadDemo3(); // A��B�̹߳���ͬһ����ӡ��
		Thread a = new ThreadA(printer);
		Thread b = new ThreadB(printer);

		a.start();
		b.start();
	}
	
}