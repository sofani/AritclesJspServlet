<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>
</head>
<body>
      <p>${message}</p>
      <form method="post" action="<c:url value='/user/logInUser'/> ">
         <table>
            <tr>
               <td>User Name:</td>
                <td><input type="text" name="userName"  value="${user.userName}"></td>
            </tr>
               
             <tr>
               <td>Password:</td>
               <td><input type="password" name="password"></td>
             </tr>
             <tr>
               <td><input type="submit" value="save"></td>
             </tr>
         </table>
          
    </form>
        <a href="<c:url value='/article/Register.jsp'/>">Sign Up</a>
</body>
</html>