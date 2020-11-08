package com.cognizant.hibernateTest.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.hibernateTest.entity.Employee;
import com.cognizant.hibernateTest.repo.EmployeeRepository;
@RestController
public class EmployeeResource {
	@Autowired
	EmployeeRepository repo;
	
	@GetMapping("getEmployee")
	public List<Employee> getEmployees(){
		List<Employee> list=repo.findAll();
		return list;
	}
	
	@PostMapping("addEmployee")
	public void addEmployees() {
		
		Employee emp=new Employee();
		emp.setEmpId(101);
		emp.setFirstName("Iron");
		emp.setLastName("Man");
		emp.setSkill("Machine Learning");
		repo.save(emp);
	}
	
	@PutMapping("updateEmployee")
	public void updateEmployee() {
		Optional<Employee> emp=repo.findById( 101);
		if(emp.isPresent()) {
			Employee e=emp.get();
			e.setFirstName("Spider");
			repo.save(e);
		}
	}
	
	@DeleteMapping("deleteEmployee")
	public void deleteEmployee() {
		if(repo.existsById(101))
			repo.deleteById( 101);
	}
	
	
}
