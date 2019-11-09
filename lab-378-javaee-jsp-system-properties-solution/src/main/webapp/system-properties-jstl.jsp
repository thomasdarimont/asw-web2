<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- http://localhost:8080/lab-378-javaee-jsp-system-properties-solution/system-properties-jstl.jsp -->
<html>
<h1>Table with JSP JSTL Expressions</h1>
<body>
<% request.setAttribute("systemProperties", java.lang.System.getProperties()); %>
 <table>
  <tr>
   <th>Key</th>
   <th>Value</th>
  </tr>
  <c:forEach var="entry" items="${systemProperties}">
   <tr>
    <td>
     <c:out value="${entry.key}" />
    </td>
    <td>
     <c:out value="${entry.value}" />
    </td>
   </tr>
  </c:forEach>
 </table>
</body>
</html>