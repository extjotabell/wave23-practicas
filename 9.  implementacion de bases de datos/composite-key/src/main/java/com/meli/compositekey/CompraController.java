package com.meli.compositekey;

import com.meli.compositekey.entities.Compra;
import com.meli.compositekey.services.CompraService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

     private final CompraService compraService;

     public CompraController(CompraService compraService) {
         this.compraService = compraService;
     }

     @PostMapping
        public boolean saveCompras(@RequestBody List<Compra> compras) {
            return compraService.saveCompras(compras);
        }

}
