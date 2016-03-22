package CreateAndConsume;

public class Factory {
	
	private int i =0;
	private boolean create = false;
	
	
	public synchronized void create(){
		while (create) {
			 try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		i ++;
		System.out.println(Thread.currentThread().getName()+":create:"+i);
		this.create = true;
		notifyAll();
	}
	
	public synchronized void consume(){
		while (!create) {
			 try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		System.out.println(Thread.currentThread().getName()+":consume:"+i);
		this.create = false;
		notifyAll();
	}

}
