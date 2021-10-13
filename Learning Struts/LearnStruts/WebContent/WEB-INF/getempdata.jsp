<%@page import="com.learnstruts.controller.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
		List<Employee> empl = (List<Employee>) request.getAttribute("empList");
		for(Employee emp : empl){
			//System.out.println(emp.getId());
			out.write(Integer.toString(emp.getId()) +" ");
			out.write(emp.getName());
			out.write(emp.getAddress());
		}
		
		
		out.write("<table width='40%' border ='1'>");
		for(Employee emp : empl){
			//System.out.println(emp.getId());
			out.write("<tr>");
				out.write("<td>"+Integer.toString(emp.getId()) +"</td> ");
				out.write("<td>"+emp.getName() +"</td> ");
				out.write("<td>"+emp.getAddress() +"</td> ");
			out.write("</tr>");
		}
		out.write("</table>");
		
		
		
		out.write("<br>");out.write("<br>");

		%>
		
		
		
		
		
				<table width="40%" border ="1">  
				<s:iterator value="empList">  
						<tr>
							<td><s:property value="id"/></td>  
							<td><s:property value="name"/></td>  
							<td><s:property value="address"/></td>
						</tr>
				</s:iterator>  
				</table>  
				<br><br>
<a href="/LearnStruts/"> Homepage</a>
	 

</body>
</html>