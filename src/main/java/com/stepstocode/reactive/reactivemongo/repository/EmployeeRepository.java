package com.stepstocode.reactive.reactivemongo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.stepstocode.reactive.reactivemongo.model.Employee;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

}
