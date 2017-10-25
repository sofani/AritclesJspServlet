package sofa.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ArticleProjectContextListner implements ServletContextListener {

	

	public void contextInitialized(ServletContextEvent event) {
		
		ServletContext sc = event.getServletContext();
	 // initialize the customer service email address that's used throughout the web site
       String custServEmail = sc.getInitParameter("custServEmail");
       sc.setAttribute("custServEmail", custServEmail);

    // initialize the current year that's used in the copyright notice
      GregorianCalendar currentDate = new GregorianCalendar();
      int currentYear = currentDate.get(Calendar.YEAR);
      sc.setAttribute("currentYear", currentYear);
		
	}
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
