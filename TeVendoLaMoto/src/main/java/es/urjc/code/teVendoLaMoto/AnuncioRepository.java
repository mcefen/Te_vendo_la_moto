package es.urjc.code.teVendoLaMoto;


import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.cache.annotation.Cacheable;


//@CacheConfig(cacheNames="anuncios")
public interface AnuncioRepository extends CrudRepository<Anuncio, Long> {

	//@CacheEvict(allEntries=true)
	//Anuncio save(Anuncio anuncio);
	@Cacheable
	Anuncio findByNombre(String nombre);
	@Cacheable
	Anuncio findById(long id);
	Anuncio findByAsunto(String asunto);
	Anuncio findByNombreAndAsunto(String nombre, String asunto);
	Anuncio findByMoto(Moto moto);
	Object findAll(Pageable page);
}
