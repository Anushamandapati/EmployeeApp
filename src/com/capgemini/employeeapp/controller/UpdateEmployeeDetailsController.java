package com.capgemini.employeeapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.employeeapp.dao.EmployeeDao;
import com.capgemini.employeeapp.model.Employee;


@WebServlet("/update")
public class UpdateEmployeeDetailsController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao;
	private ServletContext context;
       
   public UpdateEmployeeDetailsController() 
    {
        super();
    }
    @Override
    public void init(ServletConfig config) throws ServletException 
    {
    	super.init(config);
    }
    
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int empId=Integer.parseInt(request.getParameter("id"));
		String empName = request.getParameter("empName");
		double empSalary=Double.parseDouble(request.getParameter("empSalary"));
		String empDept= request.getParameter("empDepartment");
		
		employeeDao = (EmployeeDao) context.getAttribute("employeeDao");
		employeeDao.updateEmployee(new Employee(empId, empName, empSalary, empDept));
		
		
		List<Employee> employeesList = new ArrayList<Employee>();
		employeesList=employeeDao.findAllEmployees();
		request.setAttribute("employeesList", employeesList);
		
		
		context.setAttribute("employeeDao", employeeDao);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("displayAllEmployeeDetails.jsp");
		dispatcher.forward(request, response);
		
		
	
	}

}
