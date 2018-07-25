package com.SpringSample.demo.service;
import java.util.List;
import com.SpringSample.demo.dao.EmployeeDAO;
import com.SpringSample.demo.model.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManagerImpl implements EmployeeManager {
    @Autowired
    EmployeeDAO dao;
    public List<EmployeeVO> getAllEmployees()
    {
        return dao.getAllEmployees();
    }
	@Override
    public EmployeeVO getEmployee(Integer id) 
    {
        System.out.println("EmployeeManagerImpl "+id);
		return dao.getEmployee(id);
	}
	@Override
	public EmployeeVO updateEmployee(Integer id, EmployeeVO e) {
        System.out.println(id);
		return dao.updateEmployee(id, e);
	}
	@Override
	public List<EmployeeVO> deleteEmployee(Integer id) {
        return dao.deleteEmployee(id);
		
	}
	@Override
	public List<EmployeeVO> addEmployee(Integer id, String firstname, String lastname) {
		return dao.addEmployee(id, firstname, lastname);
	}
}