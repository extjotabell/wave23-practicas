package com.ospina.joyeria.servicio;

import com.ospina.joyeria.excepcion.NotFoundException;
import com.ospina.joyeria.modelo.entidad.Joya;
import com.ospina.joyeria.modelo.request.JoyaCompletaRequestDTO;
import com.ospina.joyeria.modelo.request.JoyaRequestDTO;
import com.ospina.joyeria.repositorio.JoyaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaServicioImpl implements JoyaServicio {

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
        Joya joya = joyaRepositorio
                .findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró una joya con el id proporcionado: " + id));
        joya.setVentaONo(false);
        joyaRepositorio.save(joya);
    }

    @Override
    public Joya actualizarJoya(Long id, JoyaCompletaRequestDTO joyaCompletaRequestDTO) {
        Joya joya = joyaRepositorio
                .findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró una joya con el id proporcionado: " + id));
        joya.setNombre(joyaCompletaRequestDTO.getNombre());
        joya.setMaterial(joyaCompletaRequestDTO.getMaterial());
        joya.setPeso(joyaCompletaRequestDTO.getPeso());
        joya.setParticularidad(joyaCompletaRequestDTO.getParticularidad());
        joya.setPoseePiedra(joyaCompletaRequestDTO.getPoseePiedra());
        joya.setVentaONo(joyaCompletaRequestDTO.getVentaONo());
        joyaRepositorio.save(joya);
        return joya;
    }

    private Joya convertirJoyaRequestDTOAJoya(JoyaRequestDTO joyaRequestDTO) {
        Joya joya = new Joya();
        joya.setNombre(joyaRequestDTO.getNombre());
        joya.setMaterial(joyaRequestDTO.getMaterial());
        joya.setPeso(joyaRequestDTO.getPeso());
        joya.setParticularidad(joyaRequestDTO.getParticularidad());
        joya.setPoseePiedra(joyaRequestDTO.getPoseePiedra());
        joya.setVentaONo(true);
        return joya;
    }
}
