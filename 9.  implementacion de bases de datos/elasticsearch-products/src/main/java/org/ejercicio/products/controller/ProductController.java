package org.ejercicio.products.controller;

import org.ejercicio.products.model.dto.ProductDto;
import org.ejercicio.products.service.IProductService;
import org.ejercicio.products.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService service;

    public ProductController(ProductServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/find/{search}")
    public ResponseEntity<?> getFindByAnyMatch(@PathVariable String search) {
        return new ResponseEntity<>(service.getFindByAnyMatch(search), HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDTO) {
        return new ResponseEntity<>(service.saveProduct(productDTO), HttpStatus.OK);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<?> saveProducts(@RequestBody List<ProductDto> productDtos) {
        return new ResponseEntity<>(service.saveProducts(productDtos), HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId) {
        service.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
