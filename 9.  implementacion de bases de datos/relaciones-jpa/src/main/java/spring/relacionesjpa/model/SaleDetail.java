package spring.relacionesjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
