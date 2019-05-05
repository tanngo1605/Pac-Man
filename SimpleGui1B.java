
import javax.swing.*;
import java.awt.event.*;

public class SimpleGui1B implements ActionListener {
	JButton button1,button2;

	public static void main(String[] args) {
		SimpleGui1B gui = new SimpleGui1B();
		gui.go();
	}

	public void go() {
		JFrame frame = new JFrame();
		button1 = new JButton("click me");
		button2 = new JButton("Hello");
		button1.addActionListener(this);
		frame.getContentPane().add(button1);
		//frame.getContentPane().add(button2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		if (button1.getText()=="click me")
		button1.setText("I’ve been clicked!");
		else if (button1.getText()== "I’ve been clicked!")
			button1.setText("click me");
	}
}
