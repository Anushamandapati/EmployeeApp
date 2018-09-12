<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employee Details</title>
</head>
<body>
	<h1>Employee Details</h1>
	<hr><br>
	<table border="1">
		<tr>
		     <th>Employee Id</th>
		     <th>Employee Name</th>
		     <th>Employee Salary</th>
		     <th>Employee Department</th>
		     <th>Update Employee</th>
		     <th>Delete Employee</th>
		</tr>
		<c:forEach var="employee" items="${requestScope.employeesList}">
			<tr>
			    <td>${employee.employeeId}</td>
			    <td>${employee.employeeName}</td>
			    <td>${employee.employeeSalary}</td>
			    <td>${employee.employeeDepartment}</td>
			    <td><a style="color: green" href="update?id=${employee.employeeId}">Update</a></td>
			    <td><a style="color: red" href="delete?id=${employee.employeeId}">Delete</a></td>
					    
			</tr>
		</c:forEach>		
	</table>
	<br>
	<a href="addEmployee.jsp"><button type="button">Add another Employee</button></a>	

</body>
</html>