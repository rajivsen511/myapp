
package com.candid;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String age = request.getParameter("age");
        String id = request.getParameter("id");
       

        // validate given input
        if (name.isEmpty() || address.isEmpty() || age.isEmpty()) {
            RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
            out.println("<font color=blue>Please fill all the fields</font>");
            rd.include(request, response);
           
        } else {
            // inserting data into mysql database
            // create a test database and student table before running this to create table
            //create table student(name varchar(100), userName varchar(100), pass varchar(100), addr varchar(100), age int, qual varchar(100), percent varchar(100), year varchar(100));
        	
        	
        	try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
                // loads mysql driver
            	Connection con = null;
         
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");

                String query = "INSERT INTO EMPLOYEE (NAME,USERNAME,PASSWORD,ADDRESS,AGE,ID) VALUES (?,?,?,?,?,?)";
                
                PreparedStatement ps = con.prepareStatement(query); // generates sql query
               
                ps.setString(1, name);
                ps.setString(2, username);
                ps.setString(3, password);
                ps.setString(4, address);
                ps.setInt(5, Integer.parseInt(age));
             
                ps.setInt(6, Integer.parseInt(id));
               

                ps.executeUpdate();// execute it on test database
              
                System.out.println("successfully inserted");
                
                ps.close();
                con.close();
            } catch (ClassNotFoundException | SQLException e)
        	{
                e.printStackTrace();
            }
            	
            		
            	catch(Exception e) {
            		System.out.println("SQLException");
            		
            	}
            	
            }
          
            RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
   
            rd.forward(request, response);
           
            
            
         
            
        }
    }
