package com.mercadolibre.jeweler.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.jeweler.dto.request.JewerlyRequestDTO;
import com.mercadolibre.jeweler.dto.response.JewerlyEditedDTO;
import com.mercadolibre.jeweler.dto.response.JewerlyResponseDTO;
import com.mercadolibre.jeweler.dto.response.MessageDTO;
import com.mercadolibre.jeweler.exception.NotFoundException;
import com.mercadolibre.jeweler.model.Jewerly;
import com.mercadolibre.jeweler.repository.IJewelerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JewelerService implements IJewelerService {

    private final IJewelerRepository jewRepo;

    public JewelerService (IJewelerRepository jewRepo) {
        this.jewRepo = jewRepo;
    }

    ObjectMapper mapper = new ObjectMapper();


    @Override
    public MessageDTO addJewerly(JewerlyRequestDTO jewerlyRequestDTO) {
        Jewerly jewerly = mapper.convertValue(jewerlyRequestDTO, Jewerly.class);
        jewRepo.save(jewerly);
        return new MessageDTO("The jewerly was created with id " + jewerly.getNro_identificatorio());

    }

    @Override
    public List<JewerlyResponseDTO> getJewerlys() {
        List<Jewerly> jewerlys = jewRepo.findAll().stream()
                .filter(j -> j.getVentaONo() == true)
                .toList();

        return jewerlys.stream()
                .map(j -> mapper.convertValue(j, JewerlyResponseDTO.class))
                .toList();
    }

    @Override
    public JewerlyEditedDTO updateJewerly(Long id, JewerlyRequestDTO jewerlyRequestDTO) {
        Jewerly jewerly = findJewerly(id);
        jewerly.setNombre(jewerlyRequestDTO.getNombre());
        jewerly.setMaterial(jewerlyRequestDTO.getMaterial());
        jewerly.setPeso(jewerlyRequestDTO.getPeso());
        jewerly.setParticularidad(jewerlyRequestDTO.getParticularidad());
        jewerly.setPosee_piedra(jewerlyRequestDTO.getPosee_piedra());
        jewerly.setVentaONo(jewerlyRequestDTO.getVentaONo());

        jewRepo.save(jewerly);

        JewerlyResponseDTO jewerlyResponseDTO = mapper.convertValue(jewerly, JewerlyResponseDTO.class);

        return new JewerlyEditedDTO("The jeweryly was edited", jewerlyResponseDTO);
    }

    @Override
    public MessageDTO deleteJewerly(long id) {
        Optional<Jewerly> jewerly = jewRepo.findById(id);
        if (jewerly.isEmpty()) {
            throw new NotFoundException("The id " + id + " does not exist");
        }
        jewerly.get().setVentaONo(false);
        jewRepo.save(jewerly.get());
        return new MessageDTO("The jewerly with id " + jewerly.get().getNro_identificatorio() + " was deleted");
    }

    @Override
    public Jewerly findJewerly(long id) {
        Optional<Jewerly> jewerly = jewRepo.findById(id);
        if (jewerly.isEmpty()) {
            throw new NotFoundException("The id " + id + " does not exist");
        }

        return jewerly.get();
    }


}
