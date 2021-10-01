package doctor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="doctorlogout",urlPatterns={"/doctorlogout"})

public class doctorlogout extends HttpServlet {

    private static final long serialVersionUID = 1L;
  
    public doctorlogout() {
        super();
            }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            response.getWriter().append("Served at: ").append(request.getContextPath());
		try(PrintWriter out=response.getWriter())
		{
			HttpSession s=request.getSession();
		s.getAttribute("Reg_id");
			s.removeAttribute("Password");
			s.invalidate();
			
		response.sendRedirect("doctotlogin.html");
	}
	}
}
