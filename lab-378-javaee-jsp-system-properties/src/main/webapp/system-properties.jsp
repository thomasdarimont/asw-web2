<!DOCTYPE HTML>
<%@page import="java.util.Map"%>
<html>
<!-- http://localhost:8080/lab-378-javaee-jsp-system-properties/system-properties.jsp -->
<body>
<h1>Table with JSP Scriptlets</h1>
 <table>
  <tr>
   <th>Key</th>
   <th>Value</th>
  </tr>
  <%
  //loop over all entries of the System.getProperties().entrySet()
  %>
  <tr>
    <!-- Output the keys and values as separate <td> elements  -->
  </tr>
  <%
  // close the loop...
  %>
 </table>
</body>
</html>