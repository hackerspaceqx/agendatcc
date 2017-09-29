package br.ufc.qxd.agtcc.service.interfaces;

import java.util.List;

import br.ufc.qxd.agtcc.model.entities.Usuario;

public interface IUsuarioService {
	
	public Usuario save(Usuario usuario);

	public Usuario update(Usuario usuario);

	public void delete(long id);

	public List<Usuario> findAll();

	public Usuario findOne(long id);
	
	public Usuario findByLogin(String login);
}
