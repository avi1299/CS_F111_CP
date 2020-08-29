import javax.swing.*;
import java.awt.*;

class gui {

	public static void main(String[] args) {
		JFrame frame=new JFrame("My First GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		
		//defining the layout of the container
		frame.setLayout(new FlowLayout());
		
		JButton button1 = new JButton("Press1");
		JButton button2 = new JButton("Press2");
		frame.getContentPane().add(button1);
		frame.getContentPane().add(button2);
		
		frame.setVisible(true);
	}

}
