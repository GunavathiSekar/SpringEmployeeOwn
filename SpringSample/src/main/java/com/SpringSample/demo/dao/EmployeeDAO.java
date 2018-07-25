package com.SpringSample.demo.dao;
import java.util.List;
import com.SpringSample.demo.model.EmployeeVO;
public interface EmployeeDAO
{
    public List<EmployeeVO> getAllEmployees();
    public EmployeeVO getEmployee(Integer id);
    public EmployeeVO updateEmployee(Integer id,EmployeeVO e);
    public List<EmployeeVO> deleteEmployee(Integer id);
    public List<EmployeeVO> addEmployee(Integer id,String firstname,String lastname);

}