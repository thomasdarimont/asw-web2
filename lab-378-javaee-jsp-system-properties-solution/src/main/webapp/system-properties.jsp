<!DOCTYPE HTML>
<%@page import="java.util.Map"%>

<!-- http://localhost:8080/lab-378-javaee-jsp-system-properties-solution/system-properties.jsp -->
<html>
<body>

<h1>Table with JSP Scriptlets</h1>
 <table>
  <tr>
   <th>Key</th>
   <th>Value</th>
  </tr>
  <%
  	for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
  %>
  <tr>
   <td><%=entry.getKey()%></td>
   <td><%=entry.getValue()%></td>
  </tr>
  <%
  	}
  %>
 </table>
</body>
</html>