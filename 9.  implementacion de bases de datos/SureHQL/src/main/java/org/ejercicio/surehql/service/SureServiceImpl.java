package org.ejercicio.surehql.service;

import org.ejercicio.surehql.model.dto.BrandDTO;
import org.ejercicio.surehql.model.dto.ModelDTO;
import org.ejercicio.surehql.model.dto.PatentDTO;
import org.ejercicio.surehql.model.dto.SinisterDTO;
import org.ejercicio.surehql.model.entity.Vehicle;
import org.ejercicio.surehql.repository.ISureRespository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Service
public class SureServiceImpl implements ISureService {

    private final ISureRespository respository;

    public SureServiceImpl(ISureRespository respository) {
        this.respository = respository;
    }

    @Override
    public List<PatentDTO> getPatents() {
        return respository.getPatents().stream().map(vehicle -> new PatentDTO(vehicle.getPatent())).toList();
    }

    @Override
    public List<BrandDTO> getPatentsAndBrand() {
        return respository.getPatentsAndBrand().stream().map(vehicle -> new BrandDTO(vehicle.getPatent(), vehicle.getBrand())).toList();
    }

    @Override
    public List<PatentDTO> getPatentsFilter() {
        LocalDate dateStart = LocalDate.parse("2024-01-01");
        LocalDate dateEnd = LocalDate.parse("2024-12-31");
        return respository.getPatentsFilter(dateStart, dateEnd).stream().map(vehicle -> new PatentDTO(vehicle.getPatent())).toList();
    }

    @Override
    public List<ModelDTO> getModelFilteredSinister() {
        return respository.getModelFilteredSinister().stream().map(vehicle -> new ModelDTO(vehicle.getPatent(), vehicle.getBrand(), vehicle.getModel())).toList();
    }

    @Override
    public SinisterDTO getModelFilteredSinisterSum() {
        List<Vehicle> vehicles = respository.getModelFilteredSinister();
        Double totalLost = respository.getTotalLostSinister();
        return new SinisterDTO(totalLost,
                vehicles.stream()
                        .map(vehicle -> new ModelDTO(vehicle.getPatent(), vehicle.getBrand(), vehicle
                                .getModel())).toList());
    }
}
