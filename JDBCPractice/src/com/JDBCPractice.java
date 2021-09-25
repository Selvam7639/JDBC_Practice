package com;
import java.sql.*;//Import the package

public class JDBCPractice {

	public static void main(String[] args)
	{

		try {
			//Class.forName("com.mysql.jdbc.Driver");//Register Driver --> This will be automatically loaded. Manual loading not required
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp","root", "Ranjith@8");//Establish Connection
			
			//Example 1
			String query = "delete from student where id = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,3);
			boolean rs2 = pst.execute();
			System.out.println("Record deleted status "+ rs2);
			
			//Example 2
			Statement st1 = con.createStatement();
			int rs1 = st1.executeUpdate("insert into student (id,name,marks) values(3,'Balaji',100)");
			System.out.println(rs1 + " row(s) affected/n");
			
			//Example 3
			PreparedStatement pst1 = con.prepareStatement("update student set marks = ? where id = ?");
			pst1.setDouble(1, 99);
			pst1.setInt(2, 1);
			int rs3 = pst1.executeUpdate();
			System.out.println(rs3 +" row(s) updated");
			
			//Example 4
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from student");		
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3));
			}
			
			st.close();
			con.close();
			
		}catch (SQLException e) {
			System.out.println("SQL Exception");
			e.printStackTrace();
		}

	}

}
