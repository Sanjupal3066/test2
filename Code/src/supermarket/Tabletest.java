package supermarket;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

class Tab2 extends JFrame implements ActionListener {
	DefaultTableModel model = new DefaultTableModel();
	Container cnt = this.getContentPane();

	JButton back = new JButton("Back");
	JLabel l1, bottom;

	JTable jtbl = new JTable(model) {
		public boolean isCellEditable(int rowIndex, int vColIndex) {
			return false;
		}
	};

	public Tab2(String l) {
		l1 = new JLabel(l + " List");
		l1.setFont(new Font("Serif", Font.PLAIN, 30));

		bottom = new JLabel(
				"NOTE: Our Home delivery service is not working now. For purchasing you need to visit respective My market store.");

		cnt.setLayout(new FlowLayout(FlowLayout.CENTER));

		model.addColumn("Product Name");
		model.addColumn("Quantity");

		model.addColumn("Original Price");
		model.addColumn("Offer Price");
		model.addColumn("Location");
		int[] columnsWidth = { 200, 80, 80, 80, 140 };
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://" + Client.IP + "/SE?autoReconnect=true&useSSL=false", "root", "root");
			PreparedStatement pstm = con.prepareStatement("SELECT Product_Name,Quantity,Org_price_INR,Location FROM "
					+ l + " where DATEDIFF(Expiry_date,CURDATE())<=30 && DATEDIFF(Expiry_date,CURDATE())>=5");
			ResultSet Rs = pstm.executeQuery();
			while (Rs.next()) {
				model.addRow(new Object[] { Rs.getString(1), Rs.getInt(2), Rs.getString(3),
						Math.round(Rs.getInt(3) * 0.7), Rs.getString(4) });
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		int gapWidth = 10;
		int gapHeight = 4;
		jtbl.setIntercellSpacing(new Dimension(gapWidth, gapHeight));
		jtbl.setRowHeight(jtbl.getRowHeight() + 30);

		int i = 0;
		for (int width : columnsWidth) {
			TableColumn column = jtbl.getColumnModel().getColumn(i++);
			column.setMinWidth(width);
			column.setMaxWidth(width);
			column.setPreferredWidth(width);
		}
		JScrollPane pg = new JScrollPane(jtbl);
		pg.setPreferredSize(new Dimension(600, 340));
		cnt.add(l1);
		cnt.add(pg);
		cnt.add(back);
		cnt.add(bottom);
		back.addActionListener(this);
		getContentPane().setBackground(Color.getHSBColor(44, 35, 50));
		this.pack();
		setTitle("Swing Example");
		setSize(660, 500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		new opt();
		dispose();
	}
}

public class Tabletest {
	public static void main(String args[]) {

	}
}