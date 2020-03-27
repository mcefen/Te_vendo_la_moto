package es.urjc.code.teVendoLaMoto;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController{
	@Autowired
	private AnuncioRepository repository;
    
	@Autowired
	private MotoRepository motoRepository;
	
	@Autowired
	private UserRepository usuarioRepository;
	
	@Autowired
	private OfertaCompraRepository ofertaCompraRepository;
	
	
	@Autowired
	private VentaRepository ventaRepository;

	
	

	/*@GetMapping("/login")
    public String login() {
    	return "login";
    }
	
	
	@GetMapping("/nuevoUsuario")
    public String getUsuario(Model model, HttpServletRequest request,Pageable page) {
		
    	return "nuevoUsuario";
    }
    
	
	@GetMapping("/anuncioNuevo")
    public String getAnuncio() {
    	return "anuncioNuevo";
    }
    
	
    @GetMapping("/loginerror")
    public String loginerror() {
    	return "loginerror";
    }*/

  
    
    
    @GetMapping("/index")
	public String index(Model model, HttpServletRequest request,Pageable page) { 
		
    	String nombre = request.getUserPrincipal().getName();
    	
    	model.addAttribute("anuncios", repository.findAll(page));
		model.addAttribute("anunciosCount", repository.count());
		model.addAttribute("usuarios", usuarioRepository.count());
	
		model.addAttribute("usuarios",usuarioRepository.findByName(nombre));
		model.addAttribute("motos", motoRepository.count());
		
		return "index";
	
	}
}
