package com.capita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.capita.source.EmployeeRegistrationSource;

@EnableBinding({Sink.class, EmployeeRegistrationSource.class})
@SpringBootApplication
public class EmployeeRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRegistrationApplication.class, args);
	}
	
	@StreamListener(target = Sink.INPUT)
	public void processRegisterEmployees(String employee) {
		System.out.println("Employees Registered by Client " + employee);
	}
	
	@StreamListener(target = EmployeeRegistrationSource.EMPLOYEE_REGISTRATION_INPUT)
	public void processRegisterEmployeesWithoutSink(String employee) {
		System.out.println("Employees Registered by Client " + employee);
	}
}
