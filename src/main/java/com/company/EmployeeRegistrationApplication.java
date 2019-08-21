package com.company;

import static com.company.source.EmployeeRegistrationSource.EMPLOYEE_REGISTRATION_INPUT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.company.source.EmployeeRegistrationSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableBinding({Sink.class, EmployeeRegistrationSource.class})
@SpringBootApplication
public class EmployeeRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRegistrationApplication.class, args);
	}
	
	@StreamListener(target = Sink.INPUT)
	public void processRegisterEmployees(String employee) {
		log.debug("Employees Registered by Client " + employee);
	}
	
	@StreamListener(target = EMPLOYEE_REGISTRATION_INPUT)
	public void processRegisterEmployeesWithoutSink(String employee) {
		log.debug("Employees Registered by Client " + employee);
	}
}
