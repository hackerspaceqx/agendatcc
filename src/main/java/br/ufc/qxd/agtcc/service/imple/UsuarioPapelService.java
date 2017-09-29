package br.ufc.qxd.agtcc.service.imple;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.qxd.agtcc.model.entities.UsuarioPapel;
import br.ufc.qxd.agtcc.repository.UsuarioPapelRepository;
import br.ufc.qxd.agtcc.service.interfaces.IUsuarioPapelService;

@Transactional
@Service
public class UsuarioPapelService implements IUsuarioPapelService{

	@Autowired
	private UsuarioPapelRepository repository;

	@Override
	public UsuarioPapel save(UsuarioPapel usuario) {
		return repository.save(usuario);
	}
	
	@Override
	public UsuarioPapel update(UsuarioPapel usuario) {
		return repository.save(usuario);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}
	
	@Override
	public List<UsuarioPapel> findAll() {
		return repository.findAll();
	}

	@Override
	public UsuarioPapel findOne(Long id) {
		return repository.findOne(id);
	}	
}
