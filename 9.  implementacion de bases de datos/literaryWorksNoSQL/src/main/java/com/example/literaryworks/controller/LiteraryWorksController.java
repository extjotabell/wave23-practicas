package com.example.literaryworks.controller;

import com.example.literaryworks.model.dto.LiteraryWorksDTO;
import com.example.literaryworks.service.ILiteraryWorksService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/literary")
public class LiteraryWorksController {

    private final ILiteraryWorksService literaryWorksService;

    public LiteraryWorksController(ILiteraryWorksService literaryWorksService) {
        this.literaryWorksService = literaryWorksService;
    }

    @PostMapping("/create")
    public ResponseEntity<LiteraryWorksDTO> saveLiteraryWork(@RequestBody LiteraryWorksDTO literaryWorksDTO){
        return ResponseEntity.ok(literaryWorksService.saveLiteraryWork(literaryWorksDTO));
    }

    @PostMapping("/creates")
    public ResponseEntity<List<LiteraryWorksDTO>> saveLiteraryWorks(@RequestBody List<LiteraryWorksDTO> literaryWorksDTOList){
        return ResponseEntity.ok(literaryWorksService.saveLiteraryWorks(literaryWorksDTOList));
    }

    @PutMapping("/update")
    public ResponseEntity<LiteraryWorksDTO> updateLiteraryWork(@RequestBody LiteraryWorksDTO literaryWorksDTO){
        return ResponseEntity.ok(literaryWorksService.updateLiteraryWork(literaryWorksDTO));
    }

    @GetMapping("/works")
    public ResponseEntity<List<LiteraryWorksDTO>> getAllLiteraryWorks(){
        return ResponseEntity.ok(literaryWorksService.getAllLiteraryWorks());
    }

    @GetMapping("/find/author")
    public ResponseEntity<List<LiteraryWorksDTO>> findByAuthorLiteraryWorks(@RequestParam("name") String authorLiteraryWorks){
        return ResponseEntity.ok(literaryWorksService.findByAuthorLiteraryWorks(authorLiteraryWorks));
    }


    @GetMapping("/find/title")
    public ResponseEntity<List<LiteraryWorksDTO>> findByNameLiteraryWorks(@RequestParam ("name")String nameLiteraryWorks){
        return ResponseEntity.ok(literaryWorksService.findByNameLiteraryWorks(nameLiteraryWorks));
    }


    @GetMapping("/find/pages")
    public ResponseEntity<List<LiteraryWorksDTO>> findByQuantityPagesLiteraryWorksByRange(@RequestParam ("quantity")Integer quantityPagesLiteraryWorks){
        return ResponseEntity.ok(literaryWorksService.findByQuantityPagesLiteraryWorksByRange(quantityPagesLiteraryWorks));
    }

    @GetMapping("/find/before")
    public ResponseEntity<List<LiteraryWorksDTO>> findByYearBeforeFirstEditionLiteraryWorksByRange2(
                                                                        @RequestParam ("year") Integer yearFirstEditionLiteraryWorks){

        return ResponseEntity.ok(literaryWorksService.findByYearBeforeFirstEditionLiteraryWorksByRange(yearFirstEditionLiteraryWorks));
    }

    @GetMapping("/find/after")
    public ResponseEntity<List<LiteraryWorksDTO>> findByYearAfterFirstEditionLiteraryWorksByRange(
                                                                        @RequestParam ("year") Integer yearFirstEditionLiteraryWorks){

        return ResponseEntity.ok(literaryWorksService.findByYearAfterFirstEditionLiteraryWorksByRange(yearFirstEditionLiteraryWorks));
    }

    @GetMapping("/find/editorial")
    public ResponseEntity<List<LiteraryWorksDTO>> findByEditorialLiteraryWorks(@RequestParam ("name")String editorialLiteraryWorks){
        return ResponseEntity.ok(literaryWorksService.findByEditorialLiteraryWorks(editorialLiteraryWorks));
    }
}
