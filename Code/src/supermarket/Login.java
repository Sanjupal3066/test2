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

public class Login extends JFrame implements ActionListener {

	JLabel signup_top;
	JTextField signup_uname;
	JTextField signup_pass;
	JTextField signup_repass;
	JTextField signup_mobile;
	JButton signup_submit;

	void framesetting() {
		setLayout(null);
		setVisible(true);
		setSize(640, 480);
		getContentPane().setBackground(Color.getHSBColor(44, 35, 50));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void component() {
		signup_top = new JLabel("Signup Form");
		signup_uname = new JTextField("Enter Your Username here", 20);
		signup_pass = new JTextField("Enter Your password here", 20);
		signup_repass = new JTextField("Re-enter Your Password", 20);
		signup_mobile = new JTextField("Enter Your Mobile Number here", 20);
		signup_submit = new JButton("Submit");
	}

	void setBound() {
		signup_top.setBounds(250, 40, 300, 40);
		signup_top.setFont(new Font("Serif", Font.PLAIN, 30));
		signup_uname.setBounds(200, 100, 200, 40);
		signup_pass.setBounds(200, 150, 200, 40);
		signup_repass.setBounds(200, 200, 200, 40);
		signup_mobile.setBounds(200, 250, 200, 40);
		signup_submit.setBounds(250, 300, 100, 40);

	}

	void addtoFrame() {
		add(signup_top);
		add(signup_uname);
		add(signup_pass);
		add(signup_repass);
		add(signup_mobile);
		add(signup_submit);
	}

	void registerbutton() {
		signup_submit.addActionListener(this);
	}

	boolean mobilecheck() {
		String umobile = signup_mobile.getText();
		if (isEmpty(umobile)) {
			JOptionPane.showMessageDialog(this, "Enter Mobile Number");
			return false;
		}
		if (umobile.length() != 10) {
			JOptionPane.showMessageDialog(this, "Enter Valid Number(Digit Should be 10)");
			return false;
		}
		char temp;
		for (int i = 0; i < umobile.length(); i++) {
			temp = umobile.charAt(i);
			if (temp < '0' || temp > '9') {
				JOptionPane.showMessageDialog(this, "Enter Valid Number");
				return false;
			}
		}
		return true;
	}

	boolean isEmpty(String str) {
		int len = str.length();
		if (len == 0) {
			return true;
		} else
			return false;
	}

	Login(String button) {

		framesetting();
		if ((button.compareTo("Login") == 0)) {
			if (DB.DBlogincheck() == 1) {
				JOptionPane.showMessageDialog(this, "Login Successfull");
				new opt();
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "User Not Found");
				new CFront();
				dispose();
			}
		} else {
			component();
			setBound();
			addtoFrame();
			registerbutton();
		}
	}

	public boolean passchecker() {
		String upass = signup_pass.getText();
		String urepass = signup_repass.getText();
		if (isEmpty(upass)) {
			JOptionPane.showMessageDialog(this, "Password Field can't be Empty");
			return false;
		}
		if (isEmpty(urepass)) {
			JOptionPane.showMessageDialog(this, "Password Field can't be Empty");
			return false;
		}
		if (upass.length() < 8) {
			JOptionPane.showMessageDialog(this, "Password Length Should be 8");
			return false;
		}
		if (upass.compareTo(urepass) == 0) {
			return true;
		} else {
			JOptionPane.showMessageDialog(this, "Password Not Matched");
			return false;

		}
	}

	public void actionPerformed(ActionEvent e) {
		if (passchecker() && mobilecheck()) {
			DB.signup(signup_uname.getText(), signup_pass.getText(), signup_mobile.getText());
		} else {
			System.out.println("Failed");
		}
	}

	public static void main(String[] args) throws Exception {
	}

}
