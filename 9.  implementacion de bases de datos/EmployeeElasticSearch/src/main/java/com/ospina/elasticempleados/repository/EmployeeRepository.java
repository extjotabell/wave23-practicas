package com.ospina.elasticempleados.repository;

import com.ospina.elasticempleados.domain.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {
}
