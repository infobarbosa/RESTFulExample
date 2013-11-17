package com.barbosa.dao;

import junit.framework.TestCase;

import com.barbosa.dao.Conexao;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConexaoTest extends TestCase {
	private static final Logger logger = Logger.getLogger(ConexaoTest.class);
	
	public void testConnection(){
		try{
			
			logger.info("executando testConnection...");
			
			Connection connection = Conexao.getConnection();
			
			assertNotNull(connection);
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select 'test'");
			resultSet.next();
			String s1 = resultSet.getString(1);
			
			assertEquals(s1, "test");

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
