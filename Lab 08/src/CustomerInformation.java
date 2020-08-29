import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class CustomerInformation {
	JFrame f;
	JPanel p1,p2,p3,p4;
	JTabbedPane tp;
	JLabel namelabel1,emaillabel1,countrylabel1,genderlabel1,deletelabel,idlabel2,namelabel2,emaillabel2,countrylabel2,genderlabel2,label4,results;
	JTextField name1,email1,gender1,delete_id,name2,email2,gender2,id2;
	JTextArea query;
	JButton savebtn,resetbtn,editbtn1,editbtn2,deletebtn,execbtn;
	JComboBox country1,country2;
	
	CustomerInformation(){
		f=new JFrame("Customer Form");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1=new JPanel(new GridLayout(5,2));
		p2=new JPanel(new GridLayout(6,2));
		p3=new JPanel(new GridLayout(2,2));
		p4=new JPanel(new GridLayout(4,1));
		tp=new JTabbedPane();
		
		namelabel1=new JLabel("Customer Name:");
		emaillabel1=new JLabel("Customer email:");
		countrylabel1=new JLabel("Customer Country:");
		genderlabel1=new JLabel("Customer Gender:");
		
		deletelabel=new JLabel("Customer Name:");
		
		idlabel2=new JLabel("Customer ID:");
		namelabel2=new JLabel("Customer Name:");
		emaillabel2=new JLabel("Customer email:");
		countrylabel2=new JLabel("Customer Country:");
		genderlabel2=new JLabel("Customer Gender:");
		
		label4=new JLabel("Enter SQL Query:");
		results=new JLabel("");
		
		name1=new JTextField(12);
		email1=new JTextField(12);
		gender1=new JTextField(12);
		
		delete_id=new JTextField(12);
		
		name2=new JTextField(12);
		email2=new JTextField(12);
		gender2=new JTextField(12);
		id2=new JTextField(12);
		
		query=new JTextArea();
		
		country1 = new JComboBox();
		country1.addItem("INDIA");
		country1.addItem("AMERICA");
		country1.addItem("AUSTRALIA");
		country1.addItem("PHILLIPINES");
		country1.addItem("SPAIN");
		
		country2 = new JComboBox();
		country2.addItem("INDIA");
		country2.addItem("AMERICA");
		country2.addItem("AUSTRALIA");
		country2.addItem("PHILLIPINES");
		country2.addItem("SPAIN");
		
		savebtn=new JButton("Add");
		resetbtn=new JButton("Reset");
		
		editbtn1=new JButton("Edit");
		editbtn2=new JButton("Save");
		
		deletebtn=new JButton("Delete");
		
		execbtn=new JButton("Execute");
		
		p1.add(namelabel1);
		p1.add(name1);
		p1.add(emaillabel1);
		p1.add(email1);
		p1.add(countrylabel1);
		p1.add(country1);
		p1.add(genderlabel1);
		p1.add(gender1);
		p1.add(savebtn);
		p1.add(resetbtn);
		
		p2.add(idlabel2);
		p2.add(id2);
		p2.add(namelabel2);
		p2.add(name2);
		p2.add(emaillabel2);
		p2.add(email2);
		p2.add(countrylabel2);
		p2.add(country2);
		p2.add(genderlabel2);
		p2.add(gender2);
		p2.add(editbtn1);
		p2.add(editbtn2);
		
		p3.add(deletelabel);
		p3.add(delete_id);
		p3.add(deletebtn);
		
		p4.add(label4);
		p4.add(query);
		p4.add(execbtn);
		p4.add(results);
		
		f.getContentPane().add(tp);
		tp.addTab("Add Record", p1);
		tp.addTab("Edit Record", p2);
		tp.addTab("Delete Record", p3);
		tp.addTab("Execute Query", p4);
			
		f.setSize(600, 400);
		f.setVisible(true);
		f.setResizable(true);
		
		//This code block is for creating database and should be run once only. 
		//Please comment after 1 run.
		try {
			createDatabase();
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				name1.setText("");
				email1.setText("");
				country1.setSelectedIndex(0);
				gender1.setText("");
			}
		});
		
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String value1=name1.getText();
				String value2=email1.getText();
				String value3=(String)country1.getSelectedItem();
				String value4=gender1.getText();
				try {
					Connection con = getConnection();
					int customerid = getCustomerID(con);
					PreparedStatement st=con.prepareStatement(
							"insert into CUSTOMER_INFO(CUSTOMER_ID,CUSTOMER_NAME,CUSTOMER_EMAIL,CUSTOMER_COUNTRY,CUSTOMER_GENDER) values(?,?,?,?,?)");
					st.setInt(1, customerid);
					st.setString(2, value1);
					st.setString(3, value2);
					st.setString(4, value3);
					st.setString(4, value4);
					st.executeUpdate();
					
					JOptionPane.showMessageDialog(p1, "Data is successfully inserted into database.");
				}catch(ClassNotFoundException e) {
					JOptionPane.showMessageDialog(p1, "Error in submitting data!");
				}catch(SQLException ex) {
					Logger.getLogger(CustomerInformation.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		
		editbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int value=Integer.parseInt(id2.getText());
				try {
					Connection con=getConnection();
					PreparedStatement st=con.prepareStatement(
							"select * from CUSTOMER_INFO where CUSTOMER_ID=?");
					st.setInt(1, value);
					ResultSet res=st.executeQuery();
					res.next();
					
					id2.setText(Integer.toString(res.getInt(1)));
					name2.setText(res.getString(2));
					email2.setText(res.getString(3));
					country2.setSelectedItem(res.getString(4));
					gender2.setText(res.getString(5));
					con.close();
				} catch(ClassNotFoundException e) {
					JOptionPane.showMessageDialog(p2, "Can not edit data");
				} catch(SQLException ex) {
					Logger.getLogger(CustomerInformation.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		
		editbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int x = JOptionPane.showConfirmDialog(p2, "Confirm edit? All data will be replaced");
				if(x==0) {
					try {
						int value1=Integer.parseInt(id2.getText());
						String value2=name2.getText();
						String value3=email2.getText();
						String value4=(String)country2.getSelectedItem();
						String value5=gender2.getText();
						Connection con =getConnection();
						Statement st = con.createStatement();
						
						st.executeUpdate("update CUSTOMER_INFO set CUSTOMER_NAME='" + 
								value2 + "', CUSTOMER_EMAIL='" + value3 + "', CUSTOMER_COUNTRY='" + 
								value4 + "', CUSTOMER_GENDER='" + value5 + "' where CUSTOMER_ID=" + 
								value1 + "");
						
						JOptionPane.showMessageDialog(p2, "Updated successfully");
						con.close();
					} catch(ClassNotFoundException e) {
						JOptionPane.showMessageDialog(p2, "Error in updating fields");
					} catch(SQLException ex) {
						Logger.getLogger(CustomerInformation.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		});
		
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int x = JOptionPane.showConfirmDialog(p3, "Confirm delete? ");
				if (x==0) {
					try{
						int val=Integer.parseInt(delete_id.getText());
						Connection con=getConnection();
						Statement st=con.createStatement();
				
						st.executeUpdate("delete from CUSTOMER_INFO where CUSTOMER_ID=" + val);
						JOptionPane.showMessageDialog(p3, "Updated successfully");
						con.close();
					} catch(ClassNotFoundException e) {
						JOptionPane.showMessageDialog(p3, "Error in deleting");
					} catch(SQLException ex) {
						Logger.getLogger(CustomerInformation.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		});
		
		execbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					String q=query.getText();
					Connection con=getConnection();
					Statement st=con.createStatement();
					
					boolean op=st.execute(q);
					if(op) {
						ResultSet rs=st.getResultSet();
						int colno =rs.getMetaData().getColumnCount();
						String text="";
						while(rs.next()) {
							text+=Integer.toString(rs.getInt(1));
							for(int i=2;i<=colno;i++) {
								text+="\t"+rs.getString(i);
							}
						}
						results.setText(text);
					} else {
						results.setText(st.getUpdateCount()+" entries in database updated successfully!");
					}
					con.close();
				} catch(ClassNotFoundException e) {
					JOptionPane.showMessageDialog(p4, "Error in executing query");
				} catch(SQLException ex) {
					Logger.getLogger(CustomerInformation.class.getName()).log(Level.SEVERE, null, ex);
				}
			}			
		});
	}
	
	//This method should be run only once.
	public void createDatabase() throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		
		String createString = "create table CUSTOMER_INFO(CUSTOMER_ID INTEGER PRIMARY KEY,\r\n" +
				"CUSTOMER_NAME VARCHAR(20),\r\n" + 
				"CUSTOMER_EMAIL VARCHAR(50),\r\n" +
				"CUSTOMER_COUNTRY VARCHAR(20),\r\n" + 
				"CUSTOMER_GENDER VARCHAR(20))";
		
		Statement stmt=con.createStatement();
		stmt.executeUpdate(createString);
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con=DriverManager.getConnection("jdbc:derby:cust;create=true;user=app;password=app");
		return con;
	}
	
	private int getCustomerID(Connection con) throws SQLException{
		int value=0;
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select max(CUSTOMER_ID) from CUSTOMER_INFO");
		if(rs.next()) rs.getInt(1);
		return value+1;
	}
	
	public static void main(String[] args) {
		CustomerInformation pro = new CustomerInformation();
	}

}
