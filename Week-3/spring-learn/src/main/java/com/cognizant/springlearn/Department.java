package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Department {

	private static final Logger LOGGER = LoggerFactory.getLogger(Department.class);

	@NotNull
	private Integer id;

	@NotNull
	@NotBlank
	@Size(min = 1, max = 30)
	private String name;

	public Department() {
		LOGGER.debug("Inside Department Constructor");
	}

	public Integer getId() {
		LOGGER.debug("Inside getDepartmentId()");
		return id;
	}

	public void setId(Integer id) {
		LOGGER.debug("Inside setDepartmentId()");
		this.id = id;
	}

	public String getName() {
		LOGGER.debug("Inside getDepartmentName()");
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("Inside setDepartmentName()");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}
