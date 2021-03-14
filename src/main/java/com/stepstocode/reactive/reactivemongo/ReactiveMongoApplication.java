package com.stepstocode.reactive.reactivemongo;

import com.stepstocode.reactive.reactivemongo.model.Employee;
import com.stepstocode.reactive.reactivemongo.repository.EmployeeRepository;
import java.util.UUID;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveMongoApplication {

    @Bean
    CommandLineRunner employees(EmployeeRepository employeeRepository) {

        return args -> {
            employeeRepository
                .deleteAll()
                .subscribe(null, null, () -> {

                    Stream.of(new Employee(UUID.randomUUID().toString(),
                        "Petru", 23000L), new Employee(UUID.randomUUID().toString(),
                        "Samu", 13000L), new Employee(UUID.randomUUID().toString(),
                        "Ryanu", 20000L), new Employee(UUID.randomUUID().toString(),
                        "Chrisu", 53000L)
                    )
                        .forEach(employee -> {
                            employeeRepository
                                .save(employee)
                                .subscribe(System.out::println);

                        });

                })
            ;
        };

    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveMongoApplication.class, args);
    }

}
