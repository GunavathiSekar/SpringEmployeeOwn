package com.SpringSample.demo.controller;
import java.util.Collection;

import com.SpringSample.demo.model.EmployeeVO;
import com.SpringSample.demo.service.EmployeeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/employees")
public class EmployeeController
{
    @Autowired
    EmployeeManager manager;
    //Get all employees
    @RequestMapping (method =  RequestMethod.GET)
    public String getAllEmployees(Model model)
    {
        model.addAttribute("employees", manager.getAllEmployees());
        return "employeesListDisplay";
    }
    //Get single employee
    @RequestMapping (value="/one/{id}",method =  RequestMethod.GET)
    public String getSingleEmployee(@PathVariable(value="id") Integer id,Model model)
    
    {
        System.out.println("Id"+id);
        System.out.println(manager.getEmployee(id));
        model.addAttribute("employee", manager.getEmployee(id));
        return "employeesListDisplay";
    }
    //Update Employee Details
    @RequestMapping (value="/update/{id}",method =RequestMethod.PUT)
    public String updateEmployee(@PathVariable(value="id") Integer id,@PathVariable(value="obj") EmployeeVO obj,Model model)
    {   obj.setFirstName("Krishna");obj.setLastName("murthy");
        model.addAttribute("employee", manager.updateEmployee(id, obj));
        return "employeesListDisplay";
    } 
    //Delete Employee
    @RequestMapping (value="/delete/{id}",method =  RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable(value="id") Integer id,Model model)
    {
        model.addAttribute("employee", manager.deleteEmployee(id));
        return "employeesListDisplay";
    }
    //Add New Employee
    @RequestMapping (value="/insert/{id}/{firstname}/{lastname}",method =  RequestMethod.POST)
    public String addEmployee(@PathVariable(value="id") Integer id,@PathVariable(value="firstanme") String firstname,@PathVariable(value="lastname") String lastname,Model model)
    {
        model.addAttribute("employee", manager.addEmployee(id, firstname, lastname));
        return "employeesListDisplay";
    }
}