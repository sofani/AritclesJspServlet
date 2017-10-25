package sofa.user;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import sofa.data.UserDB;
import sofa.model.User;
@MultipartConfig(maxFileSize = 16177215)
public class UserInsert extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		  
        HttpSession session = request.getSession();
     
        String url = "";
        String message = "";
		InputStream inputStream = null;
		Part filePart = request.getPart("Photo");
		byte [] bytes = new byte[(int) filePart.getSize()];
		inputStream = filePart.getInputStream();
		inputStream.read(bytes);
		inputStream.close();
		User user = new User();
		
		
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setImageBytes(bytes);
		if (UserDB.userNameExists(userName)) {
			message = "This user name already exists. <br>"
                    + "Please enter another user Name.";
            session.setAttribute("message", message);
            session.setAttribute("user", user);
            url = "/article/Register.jsp";
		} else {
			 message = "";
	         session.setAttribute("message", message);
	         session.setAttribute("user", user);
		     UserDB.insert(user);
		     url = "/article/"  + "/LogInForm.jsp";
		}
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	    dispatcher.forward(request, response);

}
}
