package com.meli.bootcamp.oneToOne.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    private String username;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="address_id",referencedColumnName = "id")
    private Address address;

}
