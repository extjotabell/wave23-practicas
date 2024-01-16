package spring.apiclothing.service;

import spring.apiclothing.dto.ClothingDto;
import spring.apiclothing.dto.SalesDto;
import spring.apiclothing.dto.SalesDtoResponse;


import java.time.LocalDate;
import java.util.List;

public interface IClothingService {

    ClothingDto saveNewPrenda(ClothingDto prenda);

    ClothingDto getById(Long id);

    List<ClothingDto> getAll();

    ClothingDto updatePrenda(Long id, ClothingDto
            prenda);

    ClothingDto deletePrenda(Long id);

    List<ClothingDto> getByTalle(Integer talle);

    List<ClothingDto> getByNombre(String nombre);

    SalesDtoResponse saveNewVenta(SalesDto venta);

    SalesDtoResponse getVentaById(Long id);

    List<SalesDtoResponse> getAllVentas();

    SalesDtoResponse updateVenta(Long id, SalesDto venta);

    SalesDtoResponse deleteVenta(Long id);

    List<SalesDtoResponse> getByDate(LocalDate date);

    List<ClothingDto> getPrendasByVenta(Long id);
}
