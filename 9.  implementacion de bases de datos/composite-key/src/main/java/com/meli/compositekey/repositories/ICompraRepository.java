package com.meli.compositekey.repositories;

import com.meli.compositekey.entities.Compra;
import com.meli.compositekey.entities.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompraRepository  extends JpaRepository<Compra, CompraKey> {
}
