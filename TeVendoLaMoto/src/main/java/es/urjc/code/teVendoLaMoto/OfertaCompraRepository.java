package es.urjc.code.teVendoLaMoto;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface OfertaCompraRepository extends CrudRepository<OfertaCompra, Long> {
	
	OfertaCompra findById(long id);
	
	List<OfertaCompra> findByfOferta(String fOferta);
	List<OfertaCompra> findByMoto(Moto moto);
	void deleteByMoto(Moto moto);
	OfertaCompra findByComprador(User comprador);
	List<OfertaCompra> findByVendedor(User vendedor);

	//Object findByFecha(String string);
}
