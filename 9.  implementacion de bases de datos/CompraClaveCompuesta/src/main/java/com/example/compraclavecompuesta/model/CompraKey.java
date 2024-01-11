package com.example.compraclavecompuesta.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class CompraKey implements Serializable {

  private Integer clientId;
  private Date date;
}
