package com.example.joyeria.service;

import com.example.joyeria.dto.JoyaRequestDTO;
import com.example.joyeria.dto.JoyaResponseDTO;
import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.JoyaRepository;
import com.example.joyeria.util.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoyaService implements IJoyaService{
    private final JoyaRepository joyaRepository;

    public JoyaService(JoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public Long nuevaJoya(JoyaRequestDTO joyaRequestDTO) {
        return joyaRepository.save(DTOMapper.mapToJoya(joyaRequestDTO)).getId();
    }

    @Override
    public List<JoyaResponseDTO> joyas() {
        return joyaRepository.findAll().stream()
                .filter(joya -> !joya.isVendida()).map(DTOMapper::mapToJoyaResponseDTO).toList();
    }

    @Override
    public void eliminarJoya(Long id) {
        Optional<Joya> optionalJoya = joyaRepository.findById(id);

        if (optionalJoya.isPresent()) {
            Joya joya = optionalJoya.get();

            joya.setVendida(true);

            joyaRepository.save(joya);
        }
    }

    @Override
    public JoyaResponseDTO actualizarJoya(Long id, JoyaRequestDTO joyaRequestDTO) {
        Optional<Joya> optionalJoya = joyaRepository.findById(id);

        if (optionalJoya.isPresent()) {
            Joya joya = optionalJoya.get();

            joya.setNombre(joyaRequestDTO.getNombre());
            joya.setMaterial(joyaRequestDTO.getMaterial());
            joya.setPeso(joyaRequestDTO.getPeso());
            joya.setParticularidad(joyaRequestDTO.getParticularidad());
            joya.setPoseePiedra(joyaRequestDTO.isPoseePiedra());
            joya.setVendida(joyaRequestDTO.isVendida());

            joyaRepository.save(joya);

            return DTOMapper.mapToJoyaResponseDTO(joya);
        }

        return null;
    }
}
