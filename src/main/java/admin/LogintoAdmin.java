package admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "LogintoAdmin", urlPatterns = {"/LogintoAdmin"})
public class LogintoAdmin extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
           String t= request.getParameter("Admin_id");
           String p= request.getParameter("Password");
           
          DatabaseConnection d= new DatabaseConnection();
           RequestDispatcher r;
           PreparedStatement p1;

           try{
           Connection c=d.getConnection();
           p1= c.prepareStatement("select * from Hadmin where Admin_id=? and Password=?");
           p1.setString(1,t);
           p1.setString(2,p);
           ResultSet rs= p1.executeQuery();
           if(rs.next())
           {
               r= request.getRequestDispatcher("HomePageAdmin.html");
               r.forward(request,response);
           }
           else{
               r= request.getRequestDispatcher("Invalid.html");
            
               r.forward(request,response);
           }
        } catch(Exception e)
           {System.out.println(e);}
               }}}
