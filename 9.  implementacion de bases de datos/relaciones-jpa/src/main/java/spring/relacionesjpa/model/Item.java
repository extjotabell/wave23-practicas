package spring.relacionesjpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
}
