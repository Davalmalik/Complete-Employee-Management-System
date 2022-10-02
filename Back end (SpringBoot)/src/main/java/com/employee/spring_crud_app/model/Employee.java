package com.employee.spring_crud_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String salary;
    private String primary_mobile_number;
    private String secondary_mobile_number;
    private String project;
    private String reporting_To;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getPrimary_mobile_number() {
		return primary_mobile_number;
	}
	public void setPrimary_mobile_number(String primary_mobile_number) {
		this.primary_mobile_number = primary_mobile_number;
	}
	public String getSecondary_mobile_number() {
		return secondary_mobile_number;
	}
	public void setSecondary_mobile_number(String secondary_mobile_number) {
		this.secondary_mobile_number = secondary_mobile_number;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getReporting_To() {
		return reporting_To;
	}
	public void setReporting_To(String reporting_To) {
		this.reporting_To = reporting_To;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary
				+ ", primary_mobile_number=" + primary_mobile_number + ", secondary_mobile_number="
				+ secondary_mobile_number + ", project=" + project + ", reporting_To=" + reporting_To + "]";
	}
	
    
   
}
