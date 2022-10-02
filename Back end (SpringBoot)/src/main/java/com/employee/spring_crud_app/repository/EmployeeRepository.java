package com.employee.spring_crud_app.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.spring_crud_app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee getByName(String name);

    Employee findByName(String name);
    
    // JPQL Queries
    @Query("select e from Employee e")
    public List<Employee> getAllEmpUsingJPQL();
    
    @Query("select e from Employee e where e.name=:n")
    public List<Employee> getEmpByNameUsingJPQL(@Param("n") String name);
    
    @Query("select e from Employee e where e.name=:n or e.email=:em")
    public List<Employee> getEmpByNameOrEmailUsingJPQL(@Param("n") String name, @Param("em") String email);
    
//    // Native Queries
    @Query(value="select * from employee" , nativeQuery= true)
    public List<Employee> getAllEmpUsingNativeQuery();
    
}
