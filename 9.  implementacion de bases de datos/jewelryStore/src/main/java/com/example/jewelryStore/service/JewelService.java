package com.example.jewelryStore.service;

import com.example.jewelryStore.dto.JewelDTO;
import com.example.jewelryStore.dto.MessageDTO;
import com.example.jewelryStore.entity.Jewel;
import com.example.jewelryStore.repository.IJewelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JewelService implements IJewelService{
    @Autowired
    IJewelRepository repository;

    @Override
    public MessageDTO addJewel(JewelDTO dto) {
        Jewel jewel = mapToEntity(dto);
        repository.save(jewel);
        return new MessageDTO("Jewel add successfully. Identify number: " + jewel.getId());
    }

    @Override
    public List<JewelDTO> getJewels() {
        List<Jewel> jewels = repository.findAll();
        return jewels.stream()
                .filter(Jewel::getSaleOrNot)
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDTO deleteJewel(Long id) {
        Jewel jewel = validateJewel(id);
        jewel.setSaleOrNot(false);
        repository.save(jewel);
        return new MessageDTO("Jewel with identification number " + id + " was delete successfully.");
    }

    @Override
    public JewelDTO updateJewel(Long id, JewelDTO jewel) {
        Jewel jewelFind = validateJewel(id);
        jewelFind.setName(jewel.getName());
        jewelFind.setMaterial(jewel.getMaterial());
        jewelFind.setWeight(jewel.getWeight());
        jewelFind.setParticularity(jewel.getParticularity());
        jewelFind.setHasStone(jewel.getHasStone());
        jewelFind.setSaleOrNot(jewel.getSaleOrNot());
        repository.save(jewelFind);
        return mapToDTO(jewelFind);
    }

    private Jewel validateJewel(Long id) {
        Jewel jewel = repository.findById(id).orElse(null);

        if(jewel == null){
            throw new RuntimeException("Jewel with identification numer " + id + " not exists.");
        }
        return jewel;
    }

    private JewelDTO mapToDTO(Jewel jewel) {
        JewelDTO jewelDTO = new JewelDTO();
        jewelDTO.setId(jewel.getId());
        jewelDTO.setName(jewel.getName());
        jewelDTO.setWeight(jewel.getWeight());
        jewelDTO.setMaterial(jewel.getMaterial());
        jewelDTO.setParticularity(jewel.getParticularity());
        jewelDTO.setHasStone(jewel.getHasStone());
        jewelDTO.setSaleOrNot(jewel.getSaleOrNot());
        return jewelDTO;
    }

    private Jewel mapToEntity(JewelDTO dto) {
        Jewel jewel = new Jewel();
        jewel.setId(dto.getId());
        jewel.setName(dto.getName());
        jewel.setMaterial(dto.getMaterial());
        jewel.setWeight(dto.getWeight());
        jewel.setParticularity(dto.getParticularity());
        jewel.setHasStone(dto.getHasStone());
        jewel.setSaleOrNot(true);
        return jewel;
    }

}
