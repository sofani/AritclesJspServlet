package sofa.user;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import sofa.data.UserDB;
import sofa.model.User;

public class LogInServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password"); 
        
        String url = null;
        String message = "";
		
	    User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		
		if (UserDB.logIn(userName, password)) {
			session.setAttribute("userName", userName);
            url =  "/articleList";
		} else {
			 message = "userName or password is wrong if you are new press sign up plz";
	         session.setAttribute("message", message);
		   
		     url = "/article/"  + "/LogInForm.jsp";
		}
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	    dispatcher.forward(request, response);

}
}



