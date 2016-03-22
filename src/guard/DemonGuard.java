package guard;

public class DemonGuard {
	
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				 for (int i = 0; i <100; i++) {
					System.out.println("非主线程:"+i);
				}
				
			}
		});
		//t.setDaemon(true);//设置线程为守护线程，只要主线程完毕，该线程随之结束
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("主线程:"+i);
		}
	}

}
