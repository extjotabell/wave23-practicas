package com.ospina.qatesters.controlador;

import com.ospina.qatesters.modelo.dto.request.TestCaseRequestDTO;
import com.ospina.qatesters.servicio.TestCaseServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/testcases")
public class TestCaseControlador {

    private final TestCaseServicio testCaseServicio;

    public TestCaseControlador(TestCaseServicio testCaseServicio) {
        this.testCaseServicio = testCaseServicio;
    }

    @PostMapping("/new")
    public ResponseEntity<String> crearTestCase(@RequestBody TestCaseRequestDTO testCaseRequestDTO) {
        Long id = testCaseServicio.guardarTestCase(testCaseRequestDTO);
        return ResponseEntity.ok("TestCase creado con el ID: " + id);
    }
}
