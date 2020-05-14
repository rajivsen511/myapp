package com.candid;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Remove")
public class Remove extends HttpServlet
{
private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   // response.setContentType("text/html");
   // PrintWriter out = response.getWriter();
    

   // String name = request.getParameter("name");
  //  if (name.isEmpty())
   // 		{
   // RequestDispatcher rd = request.getRequestDispatcher("View.jsp");
  //  out.println("<font color=red>Please fill all the fields</font>");
 //   rd.include(request, response);

    try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String query = "DELETE FROM EMPLOYEE WHERE NAME=?";
       
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);

        ps.executeUpdate();
        

       
            System.out.println("USER SUCCESSFULLY REMOVED...");
            ps.close();
            con.close();


    } catch (Exception e) {
        System.out.println(e);
    }
    RequestDispatcher rd1 = request.getRequestDispatcher("Home2.jsp");
    
    rd1.forward(request, response);
   
    }  
}









