package br.ufc.qxd.agtcc.service.imple;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.qxd.agtcc.model.entities.Usuario;
import br.ufc.qxd.agtcc.repository.UsuarioRepository;
import br.ufc.qxd.agtcc.service.interfaces.IUsuarioService;

@Transactional
@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}
	
	@Override
	public Usuario update(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);;
	}

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	@Override
	public Usuario findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public Usuario findByLogin(String login) {
		return repository.findByLogin(login);
	}
	
}
