<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Article List</title>
</head>
<body>
  <div>
 <c:forEach var="article" items="${articles}">
         <a href="<c:url value='/articleDisplay?Id=${article.id}'/>"> 
         
           ${article.id} 
           ${article.description}
           
           <img width="100px" height="100px" src="<c:url value='/articleImage?Id=${article.id}'/>"/>
           
          
         </a>
         
        
        
 
        
  </c:forEach>

  </div>
</body>
</html>