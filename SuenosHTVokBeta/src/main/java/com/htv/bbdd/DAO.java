package com.htv.bbdd;

public class DAO {
	
	protected static String url = "jdbc:mysql://localhost/suenoshtv?user=root&password=root";
	
	protected DAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	}
	
}
