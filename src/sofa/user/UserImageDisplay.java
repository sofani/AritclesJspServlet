package sofa.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sofa.data.UserDB;
import sofa.model.User;



public class UserImageDisplay extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("UserName");
        User user = UserDB.selectUser(userName);
        byte [] image = user.getImageBytes();
        response.setContentType("image/jpg");
        response.getOutputStream().write(image);;
        response.getOutputStream().flush();
        response.getOutputStream().close();
      
	}
}
