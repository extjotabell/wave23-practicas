package calculadoracalorias.calculadoracalorias.controller;

import calculadoracalorias.calculadoracalorias.dto.InformeCaloricoDTO;
import calculadoracalorias.calculadoracalorias.dto.InformeCaloricoListaDTO;
import calculadoracalorias.calculadoracalorias.service.CalculadoraDeCaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calculadora-calorias")
public class CalculadoraDeCaloriasController {
    @Autowired
    CalculadoraDeCaloriasService caloriasService;

    @GetMapping("/calcular/{nombre}/{peso}")
    public ResponseEntity<InformeCaloricoDTO> calcularCalorias(@PathVariable String nombre, @PathVariable Integer peso){
        InformeCaloricoDTO informeDTO = caloriasService.obtenerInformacionCalorica(nombre, peso);
        return new ResponseEntity<>(informeDTO, HttpStatus.OK);
    }

    @GetMapping("/calcular")
    public ResponseEntity<InformeCaloricoListaDTO> calcularCaloriasListaDePlatos(@RequestParam String[] platillos){
        InformeCaloricoListaDTO  informeDTO = caloriasService.obtenerInformacionCalorica(platillos);
        return new ResponseEntity<>(informeDTO, HttpStatus.OK);
    }
}
