package co.edu.unbosque.NamelessBack.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.NamelessBack.dao.IngresosDAO;
import co.edu.unbosque.NamelessBack.model.Ingresos;

@RestController //esta es una clase REST
@RequestMapping("ingresos")
public class IngresosAPI {
	
	@Autowired //inyecta la dependencia de todos los métodos del JPA para usuarioDAO
	private IngresosDAO ingresosDAO;

	@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody Ingresos ingresos) {
		ingresosDAO.save(ingresos);
	}
	
	@GetMapping("/listar")
	public List<Ingresos> listar(){
		return ingresosDAO.findAll();
	}
	
}

