package cts_maven.jdbc;

import java.sql.*;
public class App
{
public static void main(String[] args) throws ClassNotFoundException, SQLException  {

	//Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Driver class loaded");
	String url="jdbc:mysql://localhost:3306/sabhya";
	String username="root";
	String password="sabhya";

Connection connection=DriverManager.getConnection(url,username,password);
//connection.setAutoCommit(true);
System.out.println("connected..to mysql");

DatabaseMetaData dbmd=connection.getMetaData();
//System.out.println(dbmd.getDatabaseMajorVersion());
System.out.println(dbmd.getDatabaseProductName()+"\n");

String sql="Select * from emp where empno=0";
Statement st=connection.createStatement();
ResultSet rs=st.executeQuery(sql);
ResultSetMetaData rsmd=rs.getMetaData();
System.out.println(rsmd.getColumnCount());
System.out.println(rsmd.getColumnTypeName(3));
System.out.println(rsmd.getTableName(2));
System.out.println(rsmd.getColumnDisplaySize(2));
System.out.println(rsmd.getColumnLabel(3)+"\n");

//System.out.println(rsmd.getColumnName(3));

if(rs.next()) {
System.out.println(rs.getString(6));
}
else
{System.out.println("no record found..");
}
	
}

}
