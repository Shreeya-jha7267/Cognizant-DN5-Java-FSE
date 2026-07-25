package com.cognizant.springlearn;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Employee {

	private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);

	@NotNull
	private Integer id;

	@NotNull
	@NotBlank
	@Size(min = 1, max = 30)
	private String name;

	@NotNull
	@Min(0)
	private Double salary;

	@NotNull
	private Boolean permanent;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateOfBirth;

	@Valid
	private Department department;

	@Valid
	private List<Skill> skills;

	public Employee() {
		LOGGER.debug("Inside Employee Constructor");
	}

	public Integer getId() {
		LOGGER.debug("Inside getEmployeeId()");
		return id;
	}

	public void setId(Integer id) {
		LOGGER.debug("Inside setEmployeeId()");
		this.id = id;
	}

	public String getName() {
		LOGGER.debug("Inside getEmployeeName()");
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("Inside setEmployeeName()");
		this.name = name;
	}

	public Double getSalary() {
		LOGGER.debug("Inside getSalary()");
		return salary;
	}

	public void setSalary(Double salary) {
		LOGGER.debug("Inside setSalary()");
		this.salary = salary;
	}

	public Boolean getPermanent() {
		LOGGER.debug("Inside getPermanent()");
		return permanent;
	}

	public void setPermanent(Boolean permanent) {
		LOGGER.debug("Inside setPermanent()");
		this.permanent = permanent;
	}

	public Date getDateOfBirth() {
		LOGGER.debug("Inside getDateOfBirth()");
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		LOGGER.debug("Inside setDateOfBirth()");
		this.dateOfBirth = dateOfBirth;
	}

	public Department getDepartment() {
		LOGGER.debug("Inside getDepartment()");
		return department;
	}

	public void setDepartment(Department department) {
		LOGGER.debug("Inside setDepartment()");
		this.department = department;
	}

	public List<Skill> getSkills() {
		LOGGER.debug("Inside getSkills()");
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		LOGGER.debug("Inside setSkills()");
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + ", department=" + department + ", skills=" + skills + "]";
	}
}
