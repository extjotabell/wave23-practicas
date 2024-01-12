package com.ospina.elasticempleados.repositorio;

import com.ospina.elasticempleados.dominio.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmpleadoRepositorio extends ElasticsearchRepository<Empleado, String> {
}
