package com.mercadolibre.composite.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "buys")
@IdClass(BuyKey.class)
public class Buy{

    @Id
    @Column(name = "client_id")
    @JsonProperty("client_id")
    private Long clientId;

    @Id
    @Column(name = "date")
    private Date date;

}
