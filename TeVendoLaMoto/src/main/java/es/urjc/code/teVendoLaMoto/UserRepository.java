package es.urjc.code.teVendoLaMoto;

//import java.util.List;

//import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	User findById(long id);
	//List<User> findByDni(String dni);
	User findByName(String name);
	//User findByNombre_completo (String nombre_completo);
	User findByEmail (String email);
	
}
