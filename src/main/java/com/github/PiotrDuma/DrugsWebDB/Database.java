package com.github.PiotrDuma.DrugsWebDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {
	
	public static void main(String[] args) {
		long barcode = 5909990061716L;
		System.out.println(getDrugByBarcode(barcode));
		
		System.out.println("List: ");
		ArrayList<Drug> list = getDrugByName("ABAKTAL");
		for(Drug d: list) {
			System.out.println(d);
		}
	}
	
    public static Drug getDrugByBarcode(long number) {
    	Drug drug = null;
    	Connection connection = null;
    	try {
    	connection = getConnection();
    	String statement = "SELECT drugs.Nazwa_handlowa, drugs.Producent, drugs.Dawka, drugs.Opakowanie FROM drugs WHERE drugs.Kod_kreskowy_GTIN="+ number;
    	PreparedStatement preparedStatement = connection.prepareStatement(statement);
    	ResultSet resultSet = preparedStatement.executeQuery();
    	
    	while(resultSet.next()) {
    		drug = new Drug.Builder().setName(resultSet.getString("drugs.Nazwa_handlowa"))
    				.setProducent(resultSet.getString("drugs.Producent"))
    				.setDose(resultSet.getString("drugs.Dawka"))
    				.setContents(resultSet.getString("drugs.Opakowanie")).build();
    		}
    	}catch(Exception e) {
    		System.out.print(e);
    	}
    	return drug;
    }
    
    public static ArrayList<Drug> getDrugByName(String name) {
    	ArrayList<Drug> arrayList = new ArrayList<>();
    	Connection connection = null;
    	try {
    	connection = getConnection();
    	String statement = "SELECT drugs.Nazwa_handlowa, drugs.Producent, drugs.Dawka, drugs.Opakowanie FROM drugs WHERE drugs.Nazwa_handlowa LIKE '%"+ name+ "%'";
    	System.out.println(statement);
    	PreparedStatement preparedStatement = connection.prepareStatement(statement);
    	ResultSet resultSet = preparedStatement.executeQuery();
    	
    	while(resultSet.next()) {
    		Drug drug = new Drug.Builder().setName(resultSet.getString("drugs.Nazwa_handlowa"))
    				.setProducent(resultSet.getString("drugs.Producent"))
    				.setDose(resultSet.getString("drugs.Dawka"))
    				.setContents(resultSet.getString("drugs.Opakowanie")).build();
    		
    		arrayList.add(drug);
    	}
    	}catch(Exception e) {
    		System.out.print(e);
    	}
    	return arrayList;
    }
    
    private static Connection getConnection(){
    	
    	try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	
	    	String databaseURL ="jdbc:mysql://localhost:3306/drugdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=ECT";
//    		String databaseURL ="jdbc:mysql://localhost:3306/drugdatabase";
	    	String userName = "root";
	    	String passwd = "password123";
	    	Connection connection = DriverManager.getConnection(databaseURL, userName, passwd);
	    	System.out.println("Successfully connected.");
	    	return connection;
    	}catch(ClassNotFoundException | SQLException e) {
    		System.out.print(e);
    	}
    	return null;
    }
}
