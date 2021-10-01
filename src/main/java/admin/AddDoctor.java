package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConnection.DatabaseConnection;
@WebServlet(name = "AddDoctor", urlPatterns = {"/AddDoctor"})
public class AddDoctor extends HttpServlet {

	
	

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	        	 String u= request.getParameter("Name");
	             String p= request.getParameter("Password");
	             String q= request.getParameter("Reg_id");
	             String t= request.getParameter("Department");
	             String s= request.getParameter("Email");
	             
	          DatabaseConnection d= new DatabaseConnection();
	           RequestDispatcher r;
	           PreparedStatement p1;

	           try{
	           Connection c=d.getConnection();
	           p1= c.prepareStatement("insert into doctor values(?,?,?,?,?)");
	           p1.setString(1,u);
	           p1.setString(2,p);
	           p1.setString(3,q);
	           p1.setString(4,t);
	           p1.setString(5,s);
	           
	           p1.execute();
	           r= request.getRequestDispatcher("HomePageAdmin.html");
	           r.forward(request,response);
	           
	        }  catch(Exception e)
	           {System.out.println(e);}
	               }}}
