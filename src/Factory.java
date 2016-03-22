
public class Factory {
	
	private int i =0;
	private Object lock = new Object();
	private boolean create = false;
	
	public void create(){
		synchronized (lock) {
			if(!create){
				i ++;
				System.out.println("create:"+i);
				lock.notify();
				create = true;
			}else{
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void consume(){
		synchronized (lock) {
			if(create){
				System.out.println("consume:"+i);
				create = false;
				lock.notify();
			}else{
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
