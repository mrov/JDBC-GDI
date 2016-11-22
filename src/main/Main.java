package main;

import java.sql.*;

import GUI.Telaprincipal;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		try{

			String driverName = "oracle.jdbc.driver.OracleDriver";  
			Class.forName(driverName);
			

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "SYSTEM", "moabe153");
			
			Telaprincipal tp = new Telaprincipal(con);
			tp.setVisible(true);
			
			/*
			//Statement que executam comandos sql no BD
			Statement stmt = con.createStatement();
			String comando = "CREATE TABLE Pessoa(nome varchar2(255), idade int)";
			//Execute update sempre é para DML - INSERT, UPDATE e DELETE - ou DDL - CREATE, DROP,
			stmt.executeUpdate(comando);
			stmt.close();
			/* Como o nome ja sugere é só para consultas SQL
			Statement stmt2 = con.createStatement();
			stmt2.executeQuery(sql);
			 */
			
			System.out.println("Rodou");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

}
