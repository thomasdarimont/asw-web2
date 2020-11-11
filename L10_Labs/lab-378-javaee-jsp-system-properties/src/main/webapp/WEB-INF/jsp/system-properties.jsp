<!DOCTYPE HTML>
<%@page import="java.util.Map"%>
<html>
<!-- http://localhost:8080/system-properties -->
<body>
<h1>Java System Properties</h1>
 <table>
  <tr>
   <th>Key</th>
   <th>Value</th>
  </tr>
  <%
  //loop over all entries of the System.getProperties().entrySet()
  for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
  %>
  <tr>
    <!-- Output the keys and values as separate <td> elements  -->
    <td><%= entry.???Key() %></td>
    <td><%= entry.???Value() %></td>
  </tr>
  <%
  } // end for loop
  %>
 </table>
</body>
</html>