package com.company.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import com.company.utils.EmployeeConstants;

public interface EmployeeSource {
	@Output(EmployeeConstants.ADD_EMPLOYEE_OUTPUT)
	MessageChannel addEmployee();
}
