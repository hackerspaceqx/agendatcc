package br.ufc.qxd.agtcc.service.interfaces;

import java.util.List;

import br.ufc.qxd.agtcc.model.entities.Defesa;


public interface IDefesaService {

	public Defesa save(Defesa defesa);

	public Defesa update(Defesa defesa);

	public void delete(Long id);

	public List<Defesa> findAll();

	public Defesa findOne(Long id);
	
}
