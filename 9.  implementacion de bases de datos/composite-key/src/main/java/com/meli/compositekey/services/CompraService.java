package com.meli.compositekey.services;

import com.meli.compositekey.entities.Compra;
import com.meli.compositekey.repositories.ICompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompraService {

    private ICompraRepository compraRepository;

    public CompraService(ICompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public boolean saveCompras(List<Compra> compras) {
        try {
            for (Compra c : compras)
                compraRepository.save(c);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}
