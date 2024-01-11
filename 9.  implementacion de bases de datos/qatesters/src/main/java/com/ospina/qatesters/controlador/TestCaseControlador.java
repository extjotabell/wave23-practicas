package com.ospina.qatesters.controlador;

import com.ospina.qatesters.modelo.dto.request.TestCaseRequestDTO;
import com.ospina.qatesters.modelo.entidad.TestCase;
import com.ospina.qatesters.servicio.TestCaseServicio;
import com.ospina.qatesters.util.FechaUtilidad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<TestCase>> obtenerTestCases(@RequestParam(required = false) String last_update) {
        LocalDate lastUpdateDate = null;
        if (last_update != null) {
            lastUpdateDate = FechaUtilidad.convertirFecha(last_update);
        }
        return ResponseEntity.ok(testCaseServicio.obtenerTestCases(lastUpdateDate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> obtenerTestCasePorId(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseServicio.obtenerTestCasePorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCase> actualizarTestCase(@PathVariable Long id, @RequestBody TestCaseRequestDTO testCaseRequestDTO) {
        return ResponseEntity.ok(testCaseServicio.actualizarTestCase(id, testCaseRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarTestCase(@PathVariable Long id) {
        testCaseServicio.borrarTestCase(id);
        return ResponseEntity.ok("TestCase borrado con el ID: " + id);
    }

}
