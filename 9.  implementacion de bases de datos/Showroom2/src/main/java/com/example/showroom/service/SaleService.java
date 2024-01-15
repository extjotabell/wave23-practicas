package com.example.showroom.service;

import com.example.showroom.model.Clothes;
import com.example.showroom.model.Sale;
import com.example.showroom.repository.ISaleRepository;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerTemplateAvailabilityProvider;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
  private final ISaleRepository saleRepository;

  public SaleService(ISaleRepository saleRepository) {
    this.saleRepository = saleRepository;
  }

  public String createSale(Sale sale){
    return saleRepository.save(sale).getNumber();
  }

  public List<Sale> getSales() {
    return StreamSupport.stream(saleRepository.findAll().spliterator(),false).collect(Collectors.toList());
  }

  public Sale getSaleById(String id){
    return saleRepository.findById(id).orElse(null);
  }

  public Sale updateSale(String id, Sale sale){
    sale.setNumber(id);
    saleRepository.save(sale);
    return sale;
  }

  public String deleteSale(String id){
    saleRepository.deleteById(id);
    return "Se ha eliminado el sale correctamente";
  }

  public List<Sale> findAllByDate(LocalDate date){
    return saleRepository.findAllByDate(date);
  }

  public List<Clothes> findClothesFromSale(String id){
      return getSaleById(id).getClothesList();
  }
}
