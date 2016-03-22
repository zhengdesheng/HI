package guard;

public class YieldeDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t1线程:" + i);
				}
			};
		};

		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread t2 = new Thread() {
			public void run() {
			
				for (int i = 0; i < 100; i++) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t2线程:" + i);
				}
			};
		};
		t2.start();

	}

}
