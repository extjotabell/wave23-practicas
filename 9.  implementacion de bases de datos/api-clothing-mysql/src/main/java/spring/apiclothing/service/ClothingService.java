package spring.apiclothing.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.apiclothing.dto.ClothingDto;
import spring.apiclothing.dto.SalesDto;
import spring.apiclothing.dto.SalesDtoResponse;
import spring.apiclothing.model.Prenda;
import spring.apiclothing.model.Venta;
import spring.apiclothing.repository.IClothingRepository;
import spring.apiclothing.repository.ISalesRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClothingService implements IClothingService{

    @Autowired
    IClothingRepository clothingRepository;
    @Autowired
    ISalesRepository salesRepository;
    private static final String UNFOUND = "No se encontraron elementos con este id: ";

    private final ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional
    public ClothingDto saveNewPrenda(ClothingDto prendaDto) {
        Prenda createdPrenda = clothingRepository.save(map(prendaDto, Prenda.class));
        return map(createdPrenda, ClothingDto.class);
    }

    @Override
    public ClothingDto getById(Long id) {
        return map(clothingRepository.findById(id).orElseThrow(()->new RuntimeException(UNFOUND + id)), ClothingDto.class);}

    @Override
    public List<ClothingDto> getAll() {
        return clothingRepository.findAll().stream().map(c -> map(c, ClothingDto.class)).toList();
    }

    @Override
    public ClothingDto updatePrenda(Long id, ClothingDto prenda) {
        Prenda prendaAActualizar = clothingRepository.findById(id).orElseThrow(()->new RuntimeException(UNFOUND + id));
        prendaAActualizar.setCantidad(prenda.getCantidad());
        prendaAActualizar.setColor(prenda.getColor());
        prendaAActualizar.setNombre(prenda.getNombre());
        prendaAActualizar.setMarca(prenda.getMarca());
        prendaAActualizar.setPrecio_venta(prenda.getPrecio_venta());
        prendaAActualizar.setTipo(prenda.getTipo());
        return map(clothingRepository.save(prendaAActualizar), ClothingDto.class);
    }

    @Override
    @Transactional
    public ClothingDto deletePrenda(Long id) {
        Prenda prendaABorrar = clothingRepository.findById(id).orElseThrow(()->new RuntimeException(UNFOUND + id));
        clothingRepository.deleteByCodigo(id);
        return map(prendaABorrar, ClothingDto.class);
    }

    @Override
    public List<ClothingDto> getByTalle(Integer talle) {
        return clothingRepository.findByTalle(talle).stream().map(c -> map(c, ClothingDto.class)).toList();
    }

    @Override
    public List<ClothingDto> getByNombre(String nombre) {
        return clothingRepository.findByNombreContaining(nombre).stream().map(c -> map(c, ClothingDto.class)).toList();
    }

    @Override
    @Transactional
    public SalesDtoResponse saveNewVenta(SalesDto ventaDto) {
        Venta venta = new Venta();
        venta.setFecha(ventaDto.getFecha());
        venta.setMedioDePago(ventaDto.getMedioDePago());
        for (Long prenda: ventaDto.getListaDePrendas()) {
            Optional<Prenda> prendaOptional = clothingRepository.findByCodigo(prenda);
            prendaOptional.ifPresent(venta::addPrenda);
        }
        venta.setTotal(venta.calcularTotal());
        Venta createdVenta = salesRepository.save(venta);
        return map(createdVenta, SalesDtoResponse.class);
    }

    @Override
    public SalesDtoResponse getVentaById(Long id) {
        return map(salesRepository.findById(id).orElseThrow(()->new RuntimeException(UNFOUND + id)), SalesDtoResponse.class);
    }

    @Override
    public List<SalesDtoResponse> getAllVentas() {
        return salesRepository.findAll().stream().map(sale -> map(sale, SalesDtoResponse.class)).toList();
    }

    @Override
    public SalesDtoResponse updateVenta(Long id, SalesDto venta) {
        Venta ventaAActualizar = salesRepository.findById(id).orElseThrow(()->new RuntimeException("No se encontraron ventas con este id: " + id));
        ventaAActualizar.setFecha(venta.getFecha());
        ventaAActualizar.setListaDePrendas(
                venta.getListaDePrendas().stream()
                        .map(prenda ->  clothingRepository.findById(prenda))
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .toList()
        );
        ventaAActualizar.setTotal(ventaAActualizar.calcularTotal());
        ventaAActualizar.setMedioDePago(venta.getMedioDePago());
        return map(salesRepository.save(ventaAActualizar), SalesDtoResponse.class);
    }

    @Override
    @Transactional
    public SalesDtoResponse deleteVenta(Long id) {
        Venta ventaABorrar = salesRepository.findById(id).orElseThrow(()->new RuntimeException("No se encontraron prendas con este id: " + id));
        salesRepository.deleteById(id);
        return map(ventaABorrar, SalesDtoResponse.class);
    }

    @Override
    public List<SalesDtoResponse> getByDate(LocalDate date) {
        return salesRepository.findByFecha(date).stream().map(sale -> map(sale, SalesDtoResponse.class)).toList();
    }

    @Override
    public List<ClothingDto> getPrendasByVenta(Long id) {
        return salesRepository.findPrendasByNumero(id).stream().map(c -> map(c, ClothingDto.class)).toList();
    }

    private <Origin,Destination> Destination map(Origin origin, Class<Destination> destination){
        return mapper.map(origin, destination);
    }
}
