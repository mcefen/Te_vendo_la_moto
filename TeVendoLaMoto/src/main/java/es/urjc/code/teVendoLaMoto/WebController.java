package es.urjc.code.teVendoLaMoto;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	
	

	@GetMapping("/login")
    public String login() {
    	return "login";
    }
	//No funciona este método
	/*@RequestMapping (value="/login", method={RequestMethod.GET})
	public String login(Model model, HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		return "login";
	}*/
	
	
	@GetMapping("/nuevoUsuario")
    public String getUsuario(Model model, HttpServletRequest request,Pageable page) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
    	return "nuevoUsuario";
    }
    
	
	@GetMapping("/nuevoAnuncio")
    public String getAnuncio(Model model, HttpServletRequest request, Pageable page) {
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
		return "nuevoAnuncio";
    }
	
	@GetMapping("/eliminarUsuario")
    public String eliminarUsuario(Model model, HttpServletRequest request, Pageable page) {
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
		return "eliminarUsuario";
    }
	
	@GetMapping("/borrar_anuncio")
    public String borraranuncio(Model model, HttpServletRequest request, Pageable page) {
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
		return "borrar_anuncio";
    }
	/*@GetMapping("/verofertas")
    public String verofertas(Model model, HttpServletRequest request, Pageable page) {
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
		return "ver_ofertas";
    }*/
	
    @GetMapping("/errorlogin")
    public String loginerror() {
    	return "errorlogin";
    }

    @GetMapping("/bienvenidalogin")
    public String bienvenidalogin() {
    	return "bienvenidalogin";
    }
    
    @GetMapping("/logout")
    public String logout() {
    	return "logout";
    }
    
    
    
    
    @GetMapping("/admin")
	public String index(Model model, HttpServletRequest request,Pageable page) { 
		
    	//String nombre = request.getUserPrincipal().getName();
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
    	model.addAttribute("anuncios", repository.findAll(page));
		model.addAttribute("anunciosCount", repository.count());
		model.addAttribute("usuariosCount", usuarioRepository.count());
		//model.addAttribute("usuarios",usuarioRepository.findByName(nombre));
		model.addAttribute("motos", motoRepository.count());
		model.addAttribute("ofertaCompra", ofertaCompraRepository.count());
		model.addAttribute("venta", ventaRepository.count());
		return "admin";
	
	}
}
