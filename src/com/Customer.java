package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer {
		
	//A common method to connect to the DB
	private Connection connect(){
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/buyer2", "root", "12345");
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return con;
	}
			
		
		
		//Insert Project Details
		public String insertCustomer(String customerID, String name, String address, String mobile,String email,String username, String password){
			String output = "";
			try{
				Connection con = connect();
					if (con == null){
						return "Error while connecting to the database for inserting."; 
				}
				
					
					// create a prepared statement
					String query = "INSERT INTO `customer`(`customerID`, `name`, `address`, `mobile`, `email`, `username`, `password`) VALUES (?,?,?,?,?,?,?)";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					
					
					 // binding values
					 preparedStmt.setInt(1, 0);
					 preparedStmt.setString(2, name);
					 preparedStmt.setString(3, address);
					 preparedStmt.setString(4, mobile);
					 preparedStmt.setString(5, email);
					 preparedStmt.setString(6, username);
					 preparedStmt.setString(7, password);
				
					 // execute the statement
					 preparedStmt.execute();
					 con.close();
					 
					 String newCustomer = readCustomer(); 
					 output = "{\"status\":\"success\", \"data\": \"" + newCustomer + "\"}";
					 
					 }catch (Exception e)
					 {
						 
						 output = "{\"status\":\"error\", \"data\":\"Error while inserting the customer to system.\"}"; 
						 System.err.println(e.getMessage());
					 }
			 return output;
		 }
		
		public String readCustomer(){
			String output = "";
			try{
				Connection con = connect();
					if (con == null){
						return "Error while connecting to the database for reading."; 
			}
					
				// Prepare the html table to be displayed
				output = 
						"<table border='1' class='table table-info table-bordered table-striped table-hover table-warning'>"+ 
	
						"<tr >" +
							 "<th >Customer Name</th>" +
							 "<th >Address</th>" +
							 "<th>Mobile</th>" +
							 "<th>Email</th>" +
							 "<th>User Name</th>" +
							 "<th>Password</th>" +
							 "<th>Update</th>" +
							 "<th>Remove</th>" +
						
						 "</tr>";
	
				 String query = "select * from `customer`";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(query);
				 
				 
				 // iterate through the rows in the result set
				 while (rs.next()){
					 
					 
					 String customerId =  Integer.toString(rs.getInt("customerId"));
					 String name = rs.getString("name");
					 String address = rs.getString("address");
					 String mobile = rs.getString("mobile");
					 String email = rs.getString("email");
					 String username =  rs.getString("username");
					 String password =  rs.getString("password");
					 
					 // Add into the html table
					 
					 //output += "<tr><td>" + customer_id + "</td>";
					 output += "<td>" + name + "</td>";
					 output += "<td>" + address+ "</td>";
					 output += "<td>" + mobile + "</td>";
					 output += "<td>" + email+ "</td>";
					 output += "<td>" + username + "</td>";
					 output += "<td>" + password + "</td>";
					 
	
					 
					 // buttons
					
					 output += "<td><input name='btnUpdate' type='button' value='update' "
								+ "class='btnUpdate btn btn-secondary' data-userid='" + customerId + "'></td>"
								+ "<td><input name='btnRemove' type='button' value='remove'"
								+ "class='btnRemove btn btn-danger' data-userid='" + customerId + "'></td></tr>"; 
				 }
			 con.close();
			 
			 // Complete the html table
			 output += "</table>";
			 
			 
			 }catch (Exception e){
				 
				 output = "Error while reading the customers.";
				 System.err.println(e.getMessage());
			 }
			 return output;
			 
		}
		
		
		
		public String updateCustomer(String customerId, String name, String address, String mobile,String email, String username, String password){ 
			String output = ""; 
			try{
				Connection con = connect();
				if (con == null){
					return "Error while connecting to the database for updating."; 
				} 
				
				 // create a prepared statement
				String query = "UPDATE `customer` SET `name`=?,`address`=?,`mobile`=?,`email`=?,`username`=?,`password`=? WHERE `customerId`=?";
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 
				 // binding values
				  
				 preparedStmt.setString(1, name);
				 preparedStmt.setString(2, address);
				 preparedStmt.setString(3, mobile);
				 preparedStmt.setString(4, email);
				 preparedStmt.setString(5, username);
				 preparedStmt.setString(6, password);
				 preparedStmt.setString(7, customerId);
				
				 
				// preparedStmt.setString(4, sector);
				
				 
 
				 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 
				 String newCustomer = readCustomer(); 
				 output = "{\"status\":\"success\", \"data\": \"" + newCustomer + "\"}";
				 
		
				 } catch (Exception e) {
					 
					 output = "{\"status\":\"error\", \"data\": \"Error while updating the customer.\"}";
					 System.err.println(e.getMessage()); 
				 } 
				 return output; 
		 }
		
		
		public String deleteCustomer(String customerId) { 
			String output = ""; 
			try{ 
				Connection con = connect();
				if (con == null) { 
					return "Error while connecting to the database for deleting."; 
				} 
					// create a prepared statement
				    String query ="DELETE FROM `customer` WHERE customerId=?";
					PreparedStatement preparedStmt = con.prepareStatement(query); 
					
					// binding values
					preparedStmt.setInt(1, Integer.parseInt(customerId)); 
					
					// execute the statement
					preparedStmt.execute(); 
					con.close(); 
					
					String newCustomer = readCustomer(); 
					output = "{\"status\":\"success\", \"data\": \"" + newCustomer+ "\"}"; 
					
			} catch (Exception e) { 
				output = "{\"status\":\"error\", \"data\": \"Error while deleting the customer.\"}"; 
				System.err.println(e.getMessage()); 
			} 
			return output; 
		}
		
}