package com.employee.spring_crud_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employee.spring_crud_app.model.Employee;
import com.employee.spring_crud_app.services.EmployeeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Add new employee
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // Add more than 1 employee
    @PostMapping("/addEmployees")
    public List<Employee> addAllEmployees(@RequestBody List<Employee> employees) {
        return employeeService.addAllEmployees(employees);
    }

    // Get employee by Id
    @GetMapping("/getEmployeeByID/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeByID(id);
    }

    // Get employee by name
    @GetMapping("/getEmployeeByName/{name}")
    public  Employee getEmployeeByName(@PathVariable String name) {
        return  employeeService.getEmployeeByName(name);
    }

    // Update employee
    @PutMapping("/updateEmployee")
    public Employee updateEMployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    // Delete employee
    @DeleteMapping("/deleteEmployeeById/{id}")
    public boolean deleteEmployeeByID(@PathVariable int id) {
        return employeeService.deleteEmployeeByID(id);
    }

    // Get all employee
    @GetMapping("/getAll")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }
    
 // Get all employee using JPQL Query
    @GetMapping("/getAllEmpUsingJPQLQuery")
    public List<Employee> getAllEmpUsingJPQL() {
        return employeeService.getAllEmpUsingJPQL();
    }
    
 // Get  Employee By Name using JPQL Query
    @GetMapping("/getEmpByNameUsingJPQL/{name}")
    public List<Employee> getEmpByNameUsingJPQL(@PathVariable String name) {
        return employeeService.getEmpByNameUsingJPQL(name);
    }
    
 // Get  Employee By Name Or Email using JPQL Query
    @GetMapping("/getEmpByNameOrEmailUsingJPQL/{name}/{email}")
    public List<Employee> getEmpByNameOrEmailUsingJPQL(@PathVariable String name, @PathVariable String email) {
        return employeeService.getEmpByNameOrEmailUsingJPQL(name, email);
    }
   
 // Get all employee using Native Query
    @GetMapping("/getAllEmpUsingNativeQuery")
    public List<Employee> getAllEmpUsingNativeQuery() {
        return employeeService.getAllEmpUsingNativeQuery();
    }
}
