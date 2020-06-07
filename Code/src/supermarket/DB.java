package supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class DB{
	JFrame frame = new JFrame();

	void usercreation() {
		JOptionPane.showMessageDialog(frame, "User Created");
		new CFront();
		
	}
	

	static int DBlogincheck() {
		try {
			String DBuname = "root";
			String url = "jdbc:mysql://" + Client.IP + "/SE?autoReconnect=true&useSSL=false";
			String DBpass = "root";
			String query = "Select * from login_info";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, DBuname, DBpass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString(1);
				String pwd = rs.getString(2);
				String uname = CFront.username.getText();
				String pass = CFront.pass.getText();
				if ((name.compareTo(uname) == 0) && (pwd.compareTo(pass) == 0)) {
					System.out.println("Login Successfull");
					return 1;
				}
			}
			con.close();
			st.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;

	}

	void DBError(MySQLIntegrityConstraintViolationException e) {
		String str = e.toString();

		if (str.contains("uname")) {
			JOptionPane.showMessageDialog(frame, "Username Already Registered");
		}
		if (str.contains("Mobile")) {
			JOptionPane.showMessageDialog(frame, "Mobile Number Already Registered");
		}

	}

	static void signup(String uname, String pass, String Mobile) {
		try {
			String DBuname = "root";
			String url = "jdbc:mysql://" + Client.IP + "/SE?autoReconnect=true&useSSL=false";
			String DBpass = "root";
			String query = "Insert into login_info values (?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, DBuname, DBpass);
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, uname);
			st.setString(2, pass);
			st.setString(3, Mobile);
			int count = 0;
			DB d = new DB();

			try {
				count = st.executeUpdate();
			} catch (MySQLIntegrityConstraintViolationException e) {
				d.DBError(e);
			}
			con.close();
			st.close();
			if (count != 0) {
				d.usercreation();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {

	}

}
