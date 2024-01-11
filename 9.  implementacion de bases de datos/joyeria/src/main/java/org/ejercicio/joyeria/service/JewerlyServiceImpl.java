package org.ejercicio.joyeria.service;

import org.ejercicio.joyeria.DTO.JewerlyDTO;
import org.ejercicio.joyeria.DTO.response.SimpleMessageDTO;
import org.ejercicio.joyeria.model.Jewerly;
import org.ejercicio.joyeria.repository.IJewerlyRepository;
import org.ejercicio.joyeria.utils.JewerlyMapper;
import org.ejercicio.joyeria.utils.Verification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewerlyServiceImpl implements IJewerlyService {

    private final IJewerlyRepository repository;

    public JewerlyServiceImpl(IJewerlyRepository studentRepository) {
        this.repository = studentRepository;
    }

    @Override
    public List<JewerlyDTO> getJewels() {
        List<Jewerly> jewels = repository.findAll();
        return jewels.stream().map(JewerlyMapper::jewerlyMap).toList();
    }

    @Override
    public SimpleMessageDTO saveJewerly(JewerlyDTO jewerly) {
        Verification.jewelIsSaleOnTrue(jewerly);
        Jewerly jewerlySaved = repository.save(JewerlyMapper.jewerlyMap(jewerly));
        return new SimpleMessageDTO("La joya se a creado correctamente y su número identidicatorio es: " + jewerlySaved.getNroIdentification());
    }

    @Override
    public List<JewerlyDTO> deleteJewerly(Long id) {
        Jewerly jewerly = repository.findById(id).orElse(null);
        Verification.jewerlyExists(jewerly, id);
        Verification.jewelIsSaleOnFalse(jewerly);
        repository.deleteById(id);
        return getJewels();
    }

    @Override
    public SimpleMessageDTO updateJewerly(Long id, JewerlyDTO jewerlyDTO) {
        Jewerly jewerly = repository.findById(id).orElse(null);
        Verification.jewerlyExists(jewerly, id);
        jewerly.setName(jewerlyDTO.getName());
        jewerly.setMaterial(jewerlyDTO.getMaterial());
        jewerly.setWeight(jewerlyDTO.getWeight());
        jewerly.setParticularity(jewerlyDTO.getParticularity());
        jewerly.setHasStone(jewerlyDTO.getHasStone());
        jewerly.setSaleOrNot(jewerlyDTO.getSaleOrNot());
        repository.save(jewerly);
        return new SimpleMessageDTO("La joya se actualizo exitosamente.");
    }

}
