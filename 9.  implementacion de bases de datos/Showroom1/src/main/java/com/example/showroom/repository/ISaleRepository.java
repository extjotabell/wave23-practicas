package com.example.showroom.repository;

import com.example.showroom.model.Clothes;
import com.example.showroom.model.Sale;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Integer> {

  @Query("select sale from Sale sale where sale.date=:date")
  List<Sale> findAllByDate(LocalDate date);

}
