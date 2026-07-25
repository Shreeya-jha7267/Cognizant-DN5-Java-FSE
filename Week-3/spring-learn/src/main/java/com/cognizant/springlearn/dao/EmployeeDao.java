package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.cognizant.springlearn.Department;
import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.Skill;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Repository
public class EmployeeDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

	private static final List<Employee> EMPLOYEE_LIST = new ArrayList<>();

	static {
		// Initialize mock employees
		Department dept = new Department();
		dept.setId(1);
		dept.setName("IT");

		Skill skill1 = new Skill();
		skill1.setId(101);
		skill1.setName("Java");

		List<Skill> skills = new ArrayList<>();
		skills.add(skill1);

		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("John Doe");
		emp1.setSalary(50000.0);
		emp1.setPermanent(true);
		emp1.setDateOfBirth(new Date());
		emp1.setDepartment(dept);
		emp1.setSkills(skills);

		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setName("Jane Doe");
		emp2.setSalary(60000.0);
		emp2.setPermanent(false);
		emp2.setDateOfBirth(new Date());
		emp2.setDepartment(dept);
		emp2.setSkills(skills);

		EMPLOYEE_LIST.add(emp1);
		EMPLOYEE_LIST.add(emp2);
	}

	public EmployeeDao() {
		LOGGER.debug("Inside EmployeeDao Constructor");
	}

	public List<Employee> getAllEmployees() {
		LOGGER.info("START");
		LOGGER.info("END");
		return EMPLOYEE_LIST;
	}

	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("START");
		boolean found = false;
		for (Employee emp : EMPLOYEE_LIST) {
			if (emp.getId().equals(employee.getId())) {
				emp.setName(employee.getName());
				emp.setSalary(employee.getSalary());
				emp.setPermanent(employee.getPermanent());
				emp.setDateOfBirth(employee.getDateOfBirth());
				emp.setDepartment(employee.getDepartment());
				emp.setSkills(employee.getSkills());
				found = true;
				break;
			}
		}
		if (!found) {
			throw new EmployeeNotFoundException("Employee not found");
		}
		LOGGER.info("END");
	}

	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		LOGGER.info("START");
		boolean removed = false;
		Iterator<Employee> iterator = EMPLOYEE_LIST.iterator();
		while (iterator.hasNext()) {
			Employee emp = iterator.next();
			if (emp.getId() == id) {
				iterator.remove();
				removed = true;
				break;
			}
		}
		if (!removed) {
			throw new EmployeeNotFoundException("Employee not found");
		}
		LOGGER.info("END");
	}
}
