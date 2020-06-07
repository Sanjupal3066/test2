package supermarket;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class opt extends JFrame implements ActionListener {
	JLabel menu;
	JButton box1;
	JButton box2;
	JButton box3;
	JButton box4;

	void setBound() {
		menu.setBounds(300, 0, 100, 40);
		menu.setFont(new Font("Serif", Font.PLAIN, 30));
		box1.setBounds(0, 40, 320, 205);
		box2.setBounds(320, 40, 320, 205);
		box3.setBounds(0, 245, 320, 205);
		box4.setBounds(320, 245, 320, 205);

	}

	void addonframe() {
		add(menu);
		add(box1);
		add(box2);
		add(box3);
		add(box4);
	}

	void framesetting() {
		setLayout(null);
		setVisible(true);
		setSize(640, 480);
		getContentPane().setBackground(Color.getHSBColor(44, 35, 50));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void setBackground() {
		box1.setIcon(new ImageIcon("Dairy_Products.jpg"));
		box2.setIcon(new ImageIcon("fruit and vegetables.jpg"));
		box3.setIcon(new ImageIcon("snacks_and_sweets.jpg"));
		box4.setIcon(new ImageIcon("Ready_to_Cook2.png"));
	}

	public opt() {
		menu = new JLabel("Menu");
		box1 = new JButton("Dairy_Products");
		box2 = new JButton("Fruits_and_Vegetables");
		box3 = new JButton("Snacks_and_Sweets");
		box4 = new JButton("Ready_to_Cook");
		setBound();
		setBackground();
		addonframe();
		framesetting();
		registerbutton();
	}

	void registerbutton() {
		box1.addActionListener(this);
		box2.addActionListener(this);
		box3.addActionListener(this);
		box4.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		new Tab2(e.getActionCommand());
		dispose();
	}
}

public class MENU {

	public static void main(String[] args) {

	}

}
