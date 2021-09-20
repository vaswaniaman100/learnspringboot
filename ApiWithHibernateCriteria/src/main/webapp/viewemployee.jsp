<%@page import="java.util.ArrayList"%>
<%@page import="com.example.demo.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
List<Employee> emp= (List<Employee>)request.getAttribute("employeedata");
int empcount = emp.size();
%>

<table border="1" style="width: 100%;text-align: center;">
<tr>
    <th>id</th>
    <th>name</th>
    <th>address</th>
</tr>
<% for(Employee empl:emp){ %>
<tr>
    <td><%=empl.getId() %></td>
    <td><%=empl.getName() %></td>
    <td><%=empl.getAddress() %></td>
</tr>
<%} %>

</table>


</body>
</html>