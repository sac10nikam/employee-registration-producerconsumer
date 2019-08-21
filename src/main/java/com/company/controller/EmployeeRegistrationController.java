package com.company.controller;
import static com.company.source.EmployeeRegistrationSource.EMPLOYEE_REGISTRATION_INPUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Employee;
import com.company.source.EmployeeRegistrationSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@EnableBinding(EmployeeRegistrationSource.class)
public class EmployeeRegistrationController {

	@Autowired
	EmployeeRegistrationSource employeeRegistrationSource;

	@RequestMapping("/register")
	@ResponseBody
	public String orderFood(@RequestBody Employee employee) {
		employeeRegistrationSource.employeeRegistration().send(MessageBuilder.withPayload(employee).build());
		log.debug(employee.toString());
		return "Employee Registered";
	}
	
	@StreamListener(target = EMPLOYEE_REGISTRATION_INPUT)
	public void processEmployeeRegistrationInput(String msg) {
		log.debug(msg);
	}
}
