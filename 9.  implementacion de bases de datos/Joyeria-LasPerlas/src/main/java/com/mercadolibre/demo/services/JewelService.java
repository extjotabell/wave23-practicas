package com.mercadolibre.demo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.demo.dtos.JewelDTO;
import com.mercadolibre.demo.dtos.MessageDTO;
import com.mercadolibre.demo.models.Jewel;
import com.mercadolibre.demo.repositories.IJewelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JewelService implements IJewelService {
    @Autowired
    IJewelRepository repo;
    @Override
    public MessageDTO saveJewel(Jewel jewel) {
        Jewel created = repo.save(jewel);
        return new MessageDTO("Joya creada correctamente",
                new ObjectMapper().convertValue(created, JewelDTO.class));
    }

    @Override
    public List<JewelDTO> getAll() {
       return repo.findAll().stream().filter(Jewel::isVenta_o_no)
               .map(jewel -> new ObjectMapper().convertValue(jewel, JewelDTO.class))
               .toList();
    }

    @Override
    @Transactional
    public MessageDTO deleteJewel(Long id){
        Jewel jewel = repo.findById(id).orElse(null);
        assert jewel != null;
        jewel.setVenta_o_no(false);
        repo.save(jewel);
        return new MessageDTO("Joya eliminada correctamente.Id: " + id.toString(),null);
    }

    @Override
    public MessageDTO updateJewel(Long id, JewelDTO jewel) {
        Jewel currentJewel = repo.findById(id).orElse(null);
        assert currentJewel != null;

        currentJewel.setMaterial(jewel.getMaterial());
        currentJewel.setPeso(jewel.getPeso());
        currentJewel.setNombre(jewel.getNombre());
        currentJewel.setParticularidad(jewel.getParticularidad());
        currentJewel.setVenta_o_no(jewel.isVenta_o_no());
        currentJewel.setPosee_piedra(jewel.isPosee_piedra());

        repo.save(currentJewel);
        return new MessageDTO("Joya actualizada correctamente", new ObjectMapper().convertValue(currentJewel, JewelDTO.class));
    }
}
