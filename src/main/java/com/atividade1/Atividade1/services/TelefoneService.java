package com.atividade1.Atividade1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade1.Atividade1.entities.Telefone;
import com.atividade1.Atividade1.repositories.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;

	public List<Telefone> getAllTelefones() { 
		return telefoneRepository.findAll();
	}
	
	public Telefone getTelefoneById(Integer id) {
		return telefoneRepository.findById(id).orElse(null);
	}
	
	public Telefone saveTelefone(Telefone telefone) { 
		return telefoneRepository.save(telefone); 
	}
	
	public Telefone updateTelefone(Telefone telefone, Integer id) { 
		return telefoneRepository.save(telefone);
	}

	public Boolean delTelefone(Integer id) {
		Telefone telefone = telefoneRepository.findById(id).orElse(null);
		
		if (telefone != null) {
			telefoneRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
