package doctor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "viewdoctorprofile", urlPatterns = {"/viewdoctorprofile"})
public class viewdoctorprofile extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            HttpSession s= request.getSession();
            String id=request.getParameter("Reg_id");
            String na=request.getParameter("Name");
            DatabaseConnection c= new DatabaseConnection();
            Connection c1= c.getConnection();
            PreparedStatement p1= c1.prepareStatement("select * from doctor where Reg_id=? and Name=?");
            p1.setString(1,id);
            p1.setString(2,na);
            ResultSet rs= p1.executeQuery();
        
            while(rs.next())
            {   out.println("<body style=\"background-color:lightblue;\" >\n" +"");
                        

            out.println("<style>\n"+".borders{\n" +""
                    + "border: 2px solid black;\n" +" }\n" + " label {\n"+"width: 200px;\n" +
"            display: inline-block;\n"+" }\n"+"</style>");
                out.println("<div style=\"padding:100px; padding-left: 100px; padding-right: 100px;\" align=\"center\" class=\"borders\">\n" +"");
                out.println(" <h1 style=\"background-color:DodgerBlue;\" align=\"center\"> Form to View Profile</h1>\n" +"");
                out.println("<table border=2>");
                out.println("<tr><td>"+ rs.getString(1)+"<td>"+rs.getString(2)+"<td>"+rs.getString(3)+"<td>"+rs.getString(4)+"<td>"+rs.getString(5));
                out.println("</body>");}
        }catch(Exception e){}
    
    }
 
}
