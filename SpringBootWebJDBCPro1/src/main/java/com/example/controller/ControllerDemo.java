package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bean.Employee;
import com.example.dao.EmployeeDAO;

@Controller
public class ControllerDemo 
{
	@Autowired
	private EmployeeDAO employeedao;
									//Goto index page
	@RequestMapping("home")
	public String view()
	{
		return "index";
	}
									//Goto insert_page
	@RequestMapping("insert")
	public String view2()
	{
		return "insert_page";
	}
									//Save Record
	@RequestMapping("add")
	public String view3(Employee emp, Model m)
	{
		employeedao.save(emp);
		m.addAttribute("msg","Record insert Successfully...");
		return "insert_page";
	}
										//Display Record
	@RequestMapping("display")
	public String view4(Model m)
	{
		List list = employeedao.display();
		if(!list.isEmpty())
		{
			m.addAttribute("data",list);
		}
		else
		{
			m.addAttribute("msg","Oops! Record not found");
		}
		return "display_page";
	}
	
											//Update Record
	@RequestMapping("update")
	public String view5(Employee e, Model m)
	{
		List list = employeedao.update(e);
		m.addAttribute("data",list);
		m.addAttribute("msg","Record update successfully...");
		return "display_page";
	}
	
										//Delete Record
	@RequestMapping("delete")
	public String view6(Employee e, Model m)
	{
		List list = employeedao.delete(e);
		m.addAttribute("data", list);
		m.addAttribute("msg","Record deleted!");
		return "display_page";
	}
										//Goto search_page
	@RequestMapping("search")
	public String view7()
	{
		return "search_page";
	}
										//Search Record
	@RequestMapping("find")
	public String view8(HttpServletRequest request, Model m)
	{
		Employee e = new Employee();
		String empid = request.getParameter("empid");
		if(empid !="")
		{
			e.setEmpid(Integer.valueOf(empid));
		}
		String empname = request.getParameter("empname");
		String address = request.getParameter("address");
		e.setEmpname(empname);
		e.setAddress(address);

		List list = employeedao.search(e);
		if(!list.isEmpty())
		{
			m.addAttribute("data", list);
		}
		else
		{
			m.addAttribute("msg","Oops Record not found !");
		}
		return "search_page";
	}
}
