package com.capita.source;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EmployeeRegistrationSource {

	String EMPLOYEE_REGISTRATION_OUTPUT = "employeeRegistrationChannel";
	String EMPLOYEE_REGISTRATION_INPUT = "employeeRegistrationChannelInput";
	
	@Output(EMPLOYEE_REGISTRATION_OUTPUT)
	MessageChannel employeeRegistration();
	
	@Input(EMPLOYEE_REGISTRATION_INPUT)
	MessageChannel employeeRegistrationInput();

}
