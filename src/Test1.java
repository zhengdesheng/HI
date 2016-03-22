import javax.swing.*;
import java.awt.*;

class Jframe extends JFrame {
	public Jframe() {
		// setBounds(100,100,200,300);
		this.setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(40, 40, 40, 250);
		g.drawLine(40, 250, 300, 250);
	}

}

public class Test1 {
	public static void main(String args[]) {
		// try{
		new Jframe();
		new Jframe();
		// }catch(Exception e){
		// e.printStackTrace();
		// }

	}
}