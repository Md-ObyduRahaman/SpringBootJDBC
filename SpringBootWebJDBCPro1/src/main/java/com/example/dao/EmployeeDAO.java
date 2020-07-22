package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.example.bean.Employee;

@Repository
public class EmployeeDAO 
{
	@Autowired
	private JdbcTemplate jdbctemplate;

	public EmployeeDAO(JdbcTemplate jdbctemplate) {
		super();
		this.jdbctemplate = jdbctemplate;
	}
											//Insert Record
	public void save(Employee e)
	{
		String str = "insert into employeedata values('"+e.getEmpid()+"', '"+e.getEmpname()+"', '"+e.getAddress()+"')";
		jdbctemplate.update(str);
	}
											//Display Record
	public List display()
	{
		List list = new ArrayList();
		String str = "select * from employeedata ORDER BY empid ASC";
		jdbctemplate.query(str, new ResultSetExtractor<Employee>() {

			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next())
				{
					Employee emp = new Employee();
					emp.setEmpid(rs.getInt(1));
					emp.setEmpname(rs.getString(2));
					emp.setAddress(rs.getString(3));
					list.add(emp);
				}
				return null;
			}});
		
		return list;
	}
											//Update Record
	public List update(final Employee emp)
	{
		List list = new ArrayList();
		String str="update employeedata set empname=?, address=? where empid=?";
		jdbctemplate.execute(str, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, emp.getEmpname());
				ps.setString(2, emp.getAddress());
				ps.setInt(3, emp.getEmpid());
				return ps.execute();
			}
		});
		list = display();
		return list;
	}
											//Delete Record
	public List delete(Employee emp)
	{
		List list = new ArrayList();
		String str ="delete from employeedata where empid = '"+emp.getEmpid()+"' ";
		jdbctemplate.update(str);
		list = display();
		return list;
	}
	
	public List search(Employee obj)
	{
		List list = new ArrayList();
		String str ="select * from employeedata where empid= '"+obj.getEmpid()+"' or empname= '"+obj.getEmpname()+"' or address= '"+obj.getAddress()+"' ";
		jdbctemplate.query(str, new ResultSetExtractor<Employee>() {

			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next())
				{
					Employee ee = new Employee();
					ee.setEmpid(rs.getInt(1));
					ee.setEmpname(rs.getString(2));
					ee.setAddress(rs.getString(3));
					list.add(ee);
				}
				return null;
			}});
		return list;
	}
}
