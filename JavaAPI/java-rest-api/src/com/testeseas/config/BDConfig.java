package com.testeseas.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConfig {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		//return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgresql", "teste", "seas");
	}
	
}
