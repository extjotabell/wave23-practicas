package com.meli.JoyeriaLasPerlas.service;

import com.meli.JoyeriaLasPerlas.dto.request.JewelRequestDTO;
import com.meli.JoyeriaLasPerlas.dto.response.JewelResponseDTO;
import com.meli.JoyeriaLasPerlas.dto.response.JewerlyResponseDTO;
import com.meli.JoyeriaLasPerlas.dto.response.ResponseDTO;
import com.meli.JoyeriaLasPerlas.entity.Jewel;
import com.meli.JoyeriaLasPerlas.repository.JewelRepository;
import com.meli.JoyeriaLasPerlas.util.JewelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelServiceImpl implements JewelService{

    private final JewelRepository jewelRepository;

    public JewelServiceImpl(JewelRepository jewelRepository){
        this.jewelRepository = jewelRepository;
    }

    @Override
    public ResponseDTO createJewel(JewelRequestDTO jewelRequestDTO) {
        Jewel jewelSave = jewelRepository.save(JewelMapper.mapToJewel(jewelRequestDTO));
        return new ResponseDTO("Se ha guardado la joya con el siguiente numero identificatorio: " + jewelSave.getNroIdentification());
    }

    @Override
    public JewerlyResponseDTO getJewerly() {
        return JewelMapper.mapToJewerlyResponseDTO(jewelRepository.findAll());
    }

    @Override
    public ResponseDTO deleteJewel(Long id) {
        Jewel jewel = jewelRepository.findById(id).orElse(null);
        jewel.setSaleOrNot(false);
        jewelRepository.save(jewel);
        return new ResponseDTO("The jewel has been successfully removed.");
    }

    @Override
    public JewelResponseDTO modifyJewel(Long id, JewelRequestDTO jewelRequestDTO) {
        Jewel jewelSearch = jewelRepository.findById(id).orElse(null);

        Jewel jewel = JewelMapper.mapToJewel(jewelRequestDTO);
        jewel.setNroIdentification(jewelSearch.getNroIdentification());

        return JewelMapper.mapToJewelResponseDTO(jewelRepository.save(jewel));
    }
}
