package com.employee.spring_crud_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.spring_crud_app.model.Employee;
import com.employee.spring_crud_app.repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> addAllEmployees(List<Employee> employees) {
        return  employeeRepository.saveAll(employees);
    }

    public Employee getEmployeeByID(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee getEmployeeByName(String name) {
        return  employeeRepository.findByName(name);
    }

    public Employee updateEmployee(Employee employee) {
        Employee existingEMP = employeeRepository.findById(employee.getId()).orElse(null);
        System.out.println(employee);
        if(existingEMP == null) {
            System.out.println("Emp not found");
            return  employeeRepository.save(employee);
        }else  {
            existingEMP.setName(employee.getName());
            existingEMP.setEmail(employee.getEmail());
            existingEMP.setSalary(employee.getSalary());
            existingEMP.setPrimary_mobile_number(employee.getPrimary_mobile_number());
            existingEMP.setSecondary_mobile_number(employee.getSecondary_mobile_number());
            existingEMP.setProject(employee.getProject());
            existingEMP.setReporting_To(employee.getReporting_To());
            employeeRepository.save(existingEMP);
        }
        return employee;
    }

    public boolean deleteEmployeeByID(int id) {
        Employee existingEMP = employeeRepository.getById(id);
        if(existingEMP != null) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    public List<Employee> getAllEmpUsingJPQL(){
		return employeeRepository.getAllEmpUsingJPQL();	
    }
    
    public List<Employee> getEmpByNameUsingJPQL(String name){
		return employeeRepository.getEmpByNameUsingJPQL(name);	
    }
    
    public List<Employee> getEmpByNameOrEmailUsingJPQL(String name, String email){
		return employeeRepository.getEmpByNameOrEmailUsingJPQL(name, email);	
    }
    
    public List<Employee> getAllEmpUsingNativeQuery(){
		return employeeRepository.getAllEmpUsingNativeQuery();	
    }
}
