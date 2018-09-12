<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update Employee Details</title>
</head>
<body bgcolor="lavander">
	<h1>Add New Employee</h1>
	<hr>
	<form action="updateEmployee" method="post">
		<label>Employee Id :</label>
		<input type="number" name="empId" value="${employeeDao.employeeId}" readonly required/>
		<br>
		
		<label>Employee Name :</label>
		<input type="text" name="empName" value="${employeeDao.employeeName}"required/>
		<br>
		
		
		<label>Employee Salary :</label>
		<input type="text" name="empSalary" value="${employeeDao.employeeSalary}"required/>
		<br>
		
		
		<label>EmployeeDept:</label>
		<select name="empDepartment" required>
			<option value="${employeeDao.employeeDepartment}">${employeeDao.employeeDepartment}</option>
			<option value="IT">IT</option>
			<option value="HR">HR</option>
			<option value="ADMIN">Admin</option>
			<option value="System">System</option>
		</select>
		<br>
		
		<input type="submit" value="SUBMIT">
	</form>
	</body>
</html>