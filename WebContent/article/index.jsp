<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <link rel="stylesheet" type="text/css" href="/Aritcles/utlities/article.css"/>
      <script type="text/javascript" src="/Aritcles/utlities/article.js"></script> 
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>article</title>
</head>
<body>
     
      <div>
        <p>${article.id} ${article.userName} ${article.description}  </p>
        
        
        <img width="100px" height="100px" src="<c:url value='/articleImage?Id=${article.id}'/>"/>
        
      </div>
       <p><strong>Comments</strong></p>
     
       <c:if test="${!empty article.comments}">
         
           <c:forEach var="comment" items="${article.comments}">
                 <br>
                   <c:if test="${!empty comment.userName}">
                  <img width="50px" height="50px" src="<c:url value='/user/displayImageUser?UserName=${comment.userName}'/>"/> 
                  </c:if>
                  ${comment.userName}
                  ${comment.comment}
                  <a href="<c:url value='/commentDisplay?cId=${comment.cId}'/>">replies</a>
                  <c:if test="${!empty commentR.replies}">
                     <c:forEach var="reply" items="${commentR.replies}">
                         <c:if test="${comment.cId == commentR.cId}"> 
                            <br> 
                            <div style="padding-left: 30px;">
                                <c:if test="${!empty reply.userName}">
                                  <img width="50px" height="50px" src="<c:url value='/user/displayImageUser?UserName=${reply.userName}'/>"/>
                               </c:if>
                               ${reply.reply}
                               ${reply.userName}
                            </div>
                         </c:if> 
               
                     </c:forEach> 
                  </c:if>
                  <br>
          
          <div style="padding-left: 30px;">  
             <button onclick="toggle(${comment.cId})" >New Reply</button>
          </div>
         <div id="${comment.cId}" class="r"> 
           <form method="post" action="<c:url value='/reply/insertReply'/>">
                  <table>
                     <tr>
                       <!--  <td>Comment Id:</td> -->
                        <td><input type="hidden" name="cid" value="${comment.cId}"></td>
                       </tr>
                       <tr>
                         <td>Reply:</td>
                         <td><input type="text" name="reply"></td>
                       </tr>
                    
                       <tr>
                          <td><input type="submit" value="RepSave"></td>
                       </tr>
                    </table>
           </form>
           </div> 
 </c:forEach> 
      
     </c:if>
         <br><br>
        <button onclick="toggle('comm')" id="commentButton">New Comment</button>
        <div id="comm" class="c" >
        <form method="post" action="<c:url value='/commentInsert'/>" >
        <table>
           <tr>
           <!--   <td>Article Id:</td> -->
             <td><input type="hidden" name="id" value="${article.id}"></td>
          </tr>
       
          <tr>
            <td>Comment:</td>
            <td><input type="text" name="comment"></td>
          </tr>
      
          <tr>
            <td><input type="submit" value="Save"></td>
          </tr>
          
       </table>
     </form>
     </div>  
</body>
</html>