package CreateAndConsume;

public class ProduceAndConsume {
	
	public static void main(String[] args) {
		 
		int count =1;
		Factory f = new Factory();
		for (int i = 0; i < count; i++) {
			new Thread(new Produce(f)).start();
			new Thread(new Consume(f)).start();
		}
	}

}
