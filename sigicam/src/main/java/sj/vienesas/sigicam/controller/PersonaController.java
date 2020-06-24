package sj.vienesas.sigicam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sj.vienesas.sigicam.model.Persona;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	private PersonaServiceAPI personaServiceAPI;
	
	@GetMapping("/all")
	public List<Persona> getAll(){
		return personaServiceAPI.getAll();
	}
	
	@GetMapping("/find/{id}")
	public Persona find(@PathVariable Long id) {
		return personaServiceAPI.get(id);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Persona> save(@RequestBody Persona persona){
		Persona obj = personaServiceAPI.save(persona);  // Almacena persona en BD.
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<Persona> save(@PathVariable Persona persona){
		Persona persona = personaServiceAPI.get(id);
		if(persona != null)
			personaServiceAPI.delete(id);
		else
			return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	} 	
	
	
}
