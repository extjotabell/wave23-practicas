package com.jpa_crud.jewerly.service;

import com.jpa_crud.jewerly.dto.response.ListaJoya;
import com.jpa_crud.jewerly.dto.response.NoIdentificatorioJoya;
import com.jpa_crud.jewerly.model.Joya;
import com.jpa_crud.jewerly.repository.IJoyaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    private IJoyaRepository iJoyaRepository;

    @PersistenceContext
    EntityManager em;

    public JoyaService(IJoyaRepository iJoyaRepository) {
        this.iJoyaRepository = iJoyaRepository;
    }

    @Override
    public NoIdentificatorioJoya createJewel(Joya joya) {
        Joya result = iJoyaRepository.save(joya);
        return new NoIdentificatorioJoya(result.getNroIdentificatorio());
    }

    @Override
    public ListaJoya getAllJewelLogical() {
        return new ListaJoya(iJoyaRepository.findAll().stream().filter(Joya::getVentaONo).toList());
    }

    @Override
    public String deleteJewelLogical(Long id) {
        // This should be handle as an exception!
        Joya joya = iJoyaRepository.findById(id).orElse(null);
        joya.setVentaONo(false);
        iJoyaRepository.save(joya);

        return "Joya dada de baja para la venta correctamente";
    }

    @Override
    public Joya updateJewel(Long id,Joya joya) {
        Joya joyaOriginal = iJoyaRepository.findById(id).orElse(null);

        joyaOriginal.setNombre(joya.getNombre());
        joyaOriginal.setMaterial(joya.getMaterial());
        joyaOriginal.setPeso(joya.getPeso());
        joyaOriginal.setParticularidad(joya.getParticularidad());
        joyaOriginal.setPoseePiedra(joya.getPoseePiedra());
        joyaOriginal.setVentaONo(joya.getVentaONo());

        this.createJewel(joyaOriginal);
        return iJoyaRepository.findById(id).orElse(null);

    }
}
