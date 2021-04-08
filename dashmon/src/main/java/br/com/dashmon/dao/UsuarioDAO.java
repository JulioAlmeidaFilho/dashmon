package br.com.dashmon.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.dashmon.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	
	public Usuario findByEmailOrRacf(String email, String racf);
	
}