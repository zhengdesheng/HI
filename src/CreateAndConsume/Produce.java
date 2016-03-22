package CreateAndConsume;

public class Produce extends AbsFactory{
	
	public Produce(Factory factory) {
		super(factory);
		 
	}

	@Override
	protected void exeute() {
		factory.create();
	}

}
