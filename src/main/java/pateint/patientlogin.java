package pateint;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;

import dbConnection.DatabaseConnection;

@WebServlet(name = "patientlogin", urlPatterns = {"/patientlogin"})
public class patientlogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String u= request.getParameter("Patient_id");
           String p= request.getParameter("Password");
                    
          DatabaseConnection d= new DatabaseConnection();
           RequestDispatcher r;
           PreparedStatement p1;

           try{
          
           Connection c=d.getConnection();
           p1= c.prepareStatement("select * from patient where Patient_id=? and Password=?");
           p1.setString(1,u);
           p1.setString(2,p);
                      
           ResultSet rs= p1.executeQuery();
           if(rs.next())
           {
               r= request.getRequestDispatcher("patienthomepage.html");
               r.forward(request,response);
           }
           else{
               r= request.getRequestDispatcher("Invalid.html");
            
               r.forward(request,response);
           }
        }  catch(Exception e)
           {System.out.println(e);}
               }}}
