
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Article</title>
</head>
<body>
     <form method="post" action="<c:url value='/articleInsert'/> " enctype="multipart/form-data">
           <table>
              <tr>
                <td>User Name:</td>
                <td><input type="text" name="UserName"></td>
              </tr>
              <tr>
                <td>Description:</td>
                <td><input type="text" name="Description"></td>
              </tr>  
              <tr>
                <td>Portrait Photo: </td>
                <td><input type="file" name="Photo" size="50"/></td>
              </tr>
              <tr>
               <td><input type="submit" value="Save"></td>
              </tr>
            </table>
     </form>
   </body>
   </html>