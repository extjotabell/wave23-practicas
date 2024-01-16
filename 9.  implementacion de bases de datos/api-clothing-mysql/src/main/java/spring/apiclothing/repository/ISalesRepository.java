package spring.apiclothing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.apiclothing.model.Prenda;
import spring.apiclothing.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface ISalesRepository extends JpaRepository<Venta, Long> {

    List<Venta> findByFecha(LocalDate date);

    Venta findByNumero(Long numeroDeVenta);

    default
    List<Prenda> findPrendasByNumero (Long numeroDeVenta){
        return findByNumero(numeroDeVenta).getListaDePrendas();
    }
}
