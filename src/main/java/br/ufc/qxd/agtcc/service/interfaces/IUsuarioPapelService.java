package br.ufc.qxd.agtcc.service.interfaces;

import java.util.List;

import br.ufc.qxd.agtcc.model.entities.UsuarioPapel;


public interface IUsuarioPapelService {
	
	public UsuarioPapel save(UsuarioPapel usuarioPapel);

	public UsuarioPapel update(UsuarioPapel usuarioPapel);

	public void delete(Long id);

	public List<UsuarioPapel> findAll();

	public UsuarioPapel findOne(Long id);
}
