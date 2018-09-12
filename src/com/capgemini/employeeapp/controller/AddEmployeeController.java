package com.capgemini.employeeapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.employeeapp.dao.EmployeeDao;
import com.capgemini.employeeapp.dao.impl.EmployeeDaoImpl;
import com.capgemini.employeeapp.model.Employee;


@WebServlet("/addEmployee")
public class AddEmployeeController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao;
	private ServletContext context;
 
    public AddEmployeeController() 
    {
        super();
    	employeeDao = new EmployeeDaoImpl(); 
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException
    {
    	context = config.getServletContext();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		int empId=Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		double empSalary=Double.parseDouble(request.getParameter("empSalary"));
		String empDept= request.getParameter("empDept");
		
		context.setAttribute("employeeDao", employeeDao);
		RequestDispatcher dispatcher = null;

		
		Employee employee = new Employee(empId, empName, empSalary, empDept);
		
		if(employeeDao.addEmployee(employee))
		{
			 response.sendRedirect("getAllEmployees");
		}
		else
		{
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			
		}
	

}
}