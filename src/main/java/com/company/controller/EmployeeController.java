package com.company.controller;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Employee;
import com.company.source.EmployeeSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@EnableBinding(EmployeeSource.class)
public class EmployeeController {

	@Autowired
	private EmployeeSource employeeSource;

	@PostMapping(path = "/register", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public String register(@Valid @RequestBody Employee employee) {
		employeeSource.addEmployee().send(MessageBuilder.withPayload(employee).build());
		log.debug(employee.toString());
		return "Employee Registered";
	}
}
