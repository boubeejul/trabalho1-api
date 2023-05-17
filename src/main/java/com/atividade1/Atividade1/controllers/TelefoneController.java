package com.atividade1.Atividade1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade1.Atividade1.entities.Telefone;
import com.atividade1.Atividade1.services.TelefoneService;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

	@Autowired
	TelefoneService telefoneService;
	
	@GetMapping 
	public ResponseEntity<List<Telefone>> getAllTelefones() {
		return new ResponseEntity<>(telefoneService.getAllTelefones(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Telefone> getTelefoneById(@PathVariable Integer id) {
		Telefone telefoneResponse = telefoneService.getTelefoneById(id);
		if (telefoneResponse == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(telefoneResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Telefone> saveTelefone(@RequestBody Telefone telefone) {
		return new ResponseEntity<>(telefoneService.saveTelefone(telefone), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Telefone> updateTelefone(@RequestBody Telefone telefone, Integer id) {
		return new ResponseEntity<>(telefoneService.updateTelefone(telefone, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delTelefone(@PathVariable Integer id) {
		Boolean telefoneResponse = telefoneService.delTelefone(id);
		if (telefoneResponse)
			return new ResponseEntity<>(telefoneResponse, HttpStatus.OK);
		else
			return new ResponseEntity<>(telefoneResponse, HttpStatus.NOT_MODIFIED);
	}
}
