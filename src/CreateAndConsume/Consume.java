package CreateAndConsume;

public class Consume extends AbsFactory{

	public Consume(Factory factory) {
		super(factory);
		 
	}

	@Override
	protected void exeute() {
		 factory.consume();
	}

	
}
