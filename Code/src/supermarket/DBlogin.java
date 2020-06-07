package supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBlogin {

	DBlogin() {
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
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {

	}

}
