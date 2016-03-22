package CreateAndConsume.time;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;

import javax.swing.JLabel;

public class CommadThread  implements Runnable,ActionListener{
	
	private ClockPlay clockPlay;
	private JLabel label;
	private boolean start = false;
	private boolean hasStart = false;
	private Thread t;
	private boolean flag = true;
	public CommadThread(ClockPlay clockPlay,JLabel label){
		this.clockPlay = clockPlay;
		this.label = label;
		t = new Thread(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("点击按钮的值是："+e.getActionCommand());
		 command(e.getActionCommand());
		
	}

	@Override
	public void run() {
		
		while (flag) {
			 start();
			 try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void start(){
		synchronized (clockPlay) {
			if(start)
				label.setText(clockPlay.refresh());
			else{
				try {
					clockPlay.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void close(){
		this.flag = false;
	}
	
	private void command(String type){
		synchronized (clockPlay) {
			if(type.equalsIgnoreCase("start")){
				start = true;
				if(!hasStart){
					t = new Thread(this);
					hasStart = true;
					t.start();	
				}
				clockPlay.notify();
			}else if (type.equalsIgnoreCase("clear")) {
				start = false;
				clockPlay.clear();
				label.setText(clockPlay.toString());
			}else{
				start = false;
			}
		}
	}

}
