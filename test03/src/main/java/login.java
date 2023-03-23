import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public login() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html"); 
	    PrintWriter pw = res.getWriter();  
		String un = req.getParameter("userName");
		String up = req.getParameter("userPass");
		
		if(un.equals("admin") && up.equals("123")) {
			RequestDispatcher rd=req.getRequestDispatcher("welcome");  
	        rd.forward(req, res);
		}else {
			pw.println("<h2>Please enter right username or password</h2>");
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
		}
	}

}
