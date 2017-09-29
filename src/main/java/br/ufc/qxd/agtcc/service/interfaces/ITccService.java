package br.ufc.qxd.agtcc.service.interfaces;

import java.util.List;

import br.ufc.qxd.agtcc.model.entities.Tcc;


public interface ITccService {

	public Tcc save(Tcc tcc);

	public Tcc update(Tcc tcc);

	public void delete(Long id);

	public List<Tcc> findAll();

	public Tcc findOne(Long id);
	
}
