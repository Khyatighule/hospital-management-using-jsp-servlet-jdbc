package pateint;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Resultset;

import dbConnection.DatabaseConnection;

@WebServlet(name = "ChangePpass", urlPatterns = {"/ChangePpass"})

public class ChangePpass extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().append("Served at: ").append(request.getContextPath());
        
        try (PrintWriter out = response.getWriter()) {
           HttpSession s= request.getSession();

           String u= request.getParameter("Patient_id");
           String p= request.getParameter("Password");
           String n = request.getParameter("new");
          
           DatabaseConnection d= new DatabaseConnection();
           RequestDispatcher r;
           PreparedStatement p2;

           try{
           Connection c=d.getConnection();
           
           p2= c.prepareStatement("update `patient` set `Password`=? where `Patient_id`=?");
           p2.setString(1,n);
           p2.setString(2,u);
           
           p2.execute();
           
               r= request.getRequestDispatcher("afterchangePpass.html");
               r.forward(request,response);
           }
           catch(Exception e) {
               System.out.println(e);
           }
        }
    }
}
