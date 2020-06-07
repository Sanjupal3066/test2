package supermarket;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CFront extends JFrame implements ActionListener {
	JLabel top;
	static JTextField username;
	static JTextField pass;
	JButton login;
	JButton signup;

	void setBound() {
		top.setBounds(250, 40, 300, 40);
		top.setFont(new Font("Serif", Font.PLAIN, 30));
		username.setBounds(200, 100, 200, 40);
		pass.setBounds(200, 150, 200, 40);
		login.setBounds(200, 200, 100, 40);
		signup.setBounds(310, 200, 90, 40);
	}

	void addonframe() {
		add(top);
		add(username);
		add(pass);
		add(login);
		add(signup);
	}

	void framesetting() {
		setLayout(null);
		setVisible(true);
		setSize(640, 480);
		getContentPane().setBackground(Color.getHSBColor(44, 35, 50));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public CFront() {
		top = new JLabel("Client Side");
		username = new JTextField("Enter your Username here", 20);
		pass = new JTextField("Enter your Password here", 20);
		login = new JButton("Login");
		signup = new JButton("Sign Up");
		setBound();
		addonframe();
		framesetting();
		registerbutton();
	}

	void registerbutton() {
		login.addActionListener(this);
		signup.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		new Login(e.getActionCommand());
		dispose();
	}
}
