public class CreateAndConsume {

	public static void main(String[] args) {
		final Factory f = new Factory();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					f.create();
				}
					
				 
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					f.consume();
				}		 
			}
		}).start();
	}
}
