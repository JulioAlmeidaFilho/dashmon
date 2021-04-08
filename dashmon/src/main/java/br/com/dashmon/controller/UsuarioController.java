package br.com.dashmon.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dashmon.dao.UsuarioDAO;
import br.com.dashmon.model.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {

	@Autowired 			//permite injetar a dependencia da interface dao
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios")
	public List<Usuario> getAll(){
		
		return (List<Usuario>)dao.findAll();
		
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> fazerLogin(@RequestBody Usuario dadosLogin) {
	
		Usuario resultado = dao.findByEmailOrRacf(dadosLogin.getEmail(), dadosLogin.getRacf());
		
		System.out.println(resultado);
		System.out.println("Teste");
		
		if (resultado != null) {
			if(resultado.getSenha().equals(dadosLogin.getSenha())) {
				return ResponseEntity.ok(resultado);
			}else {
				return ResponseEntity.status(403).build();
			}
			} else {
				return ResponseEntity.status(403).build();
			}
				
		}
			
		
	}
