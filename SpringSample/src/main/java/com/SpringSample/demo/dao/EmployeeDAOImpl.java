package com.SpringSample.demo.dao;
import java.util.ArrayList;
import java.util.List;
import com.SpringSample.demo.model.EmployeeVO;
import org.springframework.stereotype.Repository;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    public EmployeeDAOImpl()
    {
        setUp();
    }
     List<EmployeeVO> employees = new ArrayList<EmployeeVO>();
     void setUp()
     {
        EmployeeVO vo1 = new EmployeeVO();
        vo1.setId(1);
        vo1.setFirstName("Lokesh");
        vo1.setLastName("Gupta");
        employees.add(vo1);
        EmployeeVO vo2 = new EmployeeVO();
        vo2.setId(2);
        vo2.setFirstName("Raj");
        vo2.setLastName("Kishore");
        employees.add(vo2);
     }
    public List<EmployeeVO> getAllEmployees()
    {
        //  setUp();
        return employees;
    }
    @Override
	public EmployeeVO getEmployee(Integer id) {
        EmployeeVO em=new EmployeeVO();
        for (EmployeeVO e : employees) {
            if (e.getId().equals(id)) {
               em=e;  
            }
        }
        return em;
    }
	@Override
	public EmployeeVO updateEmployee(Integer id, EmployeeVO e) {
		EmployeeVO emp=new EmployeeVO();
        for (EmployeeVO em : employees) {
            if (em.getId().equals(id)) {
                em.setFirstName(e.getFirstName());
                em.setLastName(e.getLastName()); 
                emp=em; 
            }
        }
        return emp;
	}
	@Override
	public List<EmployeeVO> deleteEmployee(Integer id) {
        for (EmployeeVO e : employees) {
            if (e.getId().equals(id)) {
               employees.remove(e);  
            }
        }
        return employees;
	}
	@Override
	public List<EmployeeVO> addEmployee(Integer id, String firstname, String lastname) {
        EmployeeVO eo=new EmployeeVO();
        eo.setId(id);eo.setFirstName(firstname);eo.setLastName(lastname);
        employees.add(eo);
        return employees;
	}
}