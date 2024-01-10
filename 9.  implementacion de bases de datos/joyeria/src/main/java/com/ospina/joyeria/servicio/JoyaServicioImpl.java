package com.ospina.joyeria.servicio;

import com.ospina.joyeria.modelo.entidad.Joya;
import com.ospina.joyeria.modelo.request.JoyaRequestDTO;
import com.ospina.joyeria.repositorio.JoyaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaServicioImpl implements JoyaServicio{

    private final JoyaRepositorio joyaRepositorio;

    public JoyaServicioImpl(JoyaRepositorio joyaRepositorio) {
        this.joyaRepositorio = joyaRepositorio;
    }

    @Override
    @Transactional
    public List<Joya> obtenerJoyas() {
        return joyaRepositorio.findAll();
    }

    @Override
    public Long guardarJoya(JoyaRequestDTO joyaRequestDTO) {
        joyaRepositorio.save(convertirJoyaRequestDTOAJoya(joyaRequestDTO));
        return joyaRepositorio.count();
    }

    @Override
    public void borrarJoya(Long id) {
        joyaRepositorio.deleteById(id);
    }

    @Override
    @Transactional
    public Joya buscarJoyaPorId(Long id) {
        return joyaRepositorio.findById(id).orElse(null);
    }

    private Joya convertirJoyaRequestDTOAJoya(JoyaRequestDTO joyaRequestDTO) {
        Joya joya = new Joya();
        joya.setNombre(joyaRequestDTO.getNombre());
        joya.setMaterial(joyaRequestDTO.getMaterial());
        joya.setPeso(joyaRequestDTO.getPeso());
        joya.setParticularidad(joyaRequestDTO.getParticularidad());
        joya.setPoseePiedra(joyaRequestDTO.getPoseePiedra());
        joya.setVentaONo(joyaRequestDTO.getVentaONo());
        return joya;
    }
}
