package com.example.showroom.service;

import com.example.showroom.model.Clothes;
import com.example.showroom.model.Sale;
import com.example.showroom.repository.ISaleRepository;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerTemplateAvailabilityProvider;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
  private final ISaleRepository saleRepository;

  public SaleService(ISaleRepository saleRepository) {
    this.saleRepository = saleRepository;
  }

  public int createSale(Sale sale){
    return saleRepository.save(sale).getNumber();
  }

  public List<Sale> getSales() {
    return saleRepository.findAll();
  }

  public Sale getSaleById(int id){
    return saleRepository.findById(id).orElse(null);
  }

  public Sale updateSale(int id, Sale sale){
    sale.setNumber(id);
    saleRepository.save(sale);
    return sale;
  }

  public String deleteSale(int id){
    saleRepository.deleteById(id);
    return "Se ha eliminado el sale correctamente";
  }

  public List<Sale> findAllByDate(LocalDate date){
    return saleRepository.findAllByDate(date);
  }

  public List<Clothes> findClothesFromSale(int id){
      return getSaleById(id).getClothesList();
  }
}
