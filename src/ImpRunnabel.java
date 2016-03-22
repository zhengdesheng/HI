
public class ImpRunnabel implements Runnable{
	private  static int max_value = 0;
	
	private boolean flag = true;
	private Object lock = new Object();
	public void run() {
		if(flag){
			while(true){
				synchronized (ImpRunnabel.class) {
					if(max_value >500)
						break;
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 System.out.println(Thread.currentThread().getName()+"lock"+":请"+max_value+"办理业务");
					 max_value ++;
				}
			
		}
		
		}else{
			while(true){
				 if(ticket())
					 break;
			
		}
		
		}
		
	}
	
	private synchronized static boolean ticket(){
		if(max_value >500)
			return true;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(Thread.currentThread().getName()+":请"+max_value+"办理业务");
		 max_value ++;
		 return false;
	}
	
	public void change(){
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.flag = false;
	}

}
