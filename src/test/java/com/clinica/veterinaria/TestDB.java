package com.clinica.veterinaria;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.clinica.veterinaria.util.PropertiesConfigurator;

public class TestDB {

	public static void main(String[] args) {
		Properties props = null;
		try {
			props = PropertiesConfigurator.getInstance();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    String dbUrl = props.getProperty("jdbc.url");
    String dbClass = props.getProperty("jdbc.driverClassName");
    String query = "select * from VETERINARIA.REGION";
    String username = props.getProperty("jdbc.username");
    String password = props.getProperty("jdbc.password");
    try {

        Class.forName(dbClass);
        Connection connection = DriverManager.getConnection(dbUrl,
            username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
        String tableName = resultSet.getString(2);
        System.out.println("Table name : " + tableName);
        }
        connection.close();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}

