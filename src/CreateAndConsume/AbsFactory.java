package CreateAndConsume;

public abstract class AbsFactory implements Runnable {
	protected Factory factory;

	public AbsFactory(Factory factory) {
		this.factory = factory;
	}

	abstract protected void exeute();

	@Override
	public void run() {
		while (true) {
			exeute();
		}

	}

}
