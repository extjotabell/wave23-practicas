package com.example.showroom.service.sale;

import com.example.showroom.dto.clothe.ClotheResponseDTO;
import com.example.showroom.dto.sale.SaleRequestDTO;
import com.example.showroom.dto.sale.SaleResponseDTO;
import com.example.showroom.model.Clothe;
import com.example.showroom.repository.ClotheRepository;
import com.example.showroom.repository.SaleRepository;
import com.example.showroom.util.ClotheDTOMapper;
import com.example.showroom.util.SaleDTOMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final ClotheRepository clotheRepository;

    public SaleServiceImpl(SaleRepository saleRepository, ClotheRepository clotheRepository) {
        this.saleRepository = saleRepository;
        this.clotheRepository = clotheRepository;
    }

    @Override
    public void save(SaleRequestDTO saleRequestDTO) {
        List<Clothe> clothes = clotheRepository.findAllById(saleRequestDTO.getClothesById());
        Double saleTotal = clothes.stream().mapToDouble(Clothe::getSalePrice).sum();
        saleRepository.save(SaleDTOMapper.mapToSale(saleRequestDTO, LocalDate.now(), saleTotal, clothes));
    }

    @Override
    public List<SaleResponseDTO> findAll(LocalDate date) {
        if (date == null)
            return saleRepository.findAll()
                    .stream().map(SaleDTOMapper::mapToSaleResponseDTO).toList();

        return saleRepository.findSalesByDate(date)
                .stream().map(SaleDTOMapper::mapToSaleResponseDTO).toList();
    }

    @Override
    public SaleResponseDTO findById(Long id) {
        return saleRepository.findById(id)
                .map(SaleDTOMapper::mapToSaleResponseDTO).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        saleRepository.delete(saleRepository.findById(id).orElseThrow());
    }

    @Override
    public List<ClotheResponseDTO> findClothesBySale(Long id) {
        return saleRepository.findById(id).orElseThrow()
                .getClothes().stream().map(ClotheDTOMapper::mapToClotheResponseDTO).toList();
    }
}
