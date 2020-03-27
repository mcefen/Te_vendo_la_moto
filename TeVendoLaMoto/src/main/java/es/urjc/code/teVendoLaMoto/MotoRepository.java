package es.urjc.code.teVendoLaMoto;


import org.springframework.data.repository.CrudRepository;

public interface MotoRepository extends CrudRepository<Moto, Long> {
	
	Moto findByMatricula(String matricula);
	Moto findByMarca(String marca);
	Moto findById(long id);
	Moto findByCilindrada( int cilindrada);

}
