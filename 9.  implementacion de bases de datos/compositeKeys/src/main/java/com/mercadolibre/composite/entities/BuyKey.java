package com.mercadolibre.composite.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class BuyKey implements Serializable{

    private Long clientId;
    private Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyKey buyKey = (BuyKey) o;
        return Objects.equals(clientId, buyKey.clientId) && Objects.equals(date, buyKey.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, date);
    }
}
