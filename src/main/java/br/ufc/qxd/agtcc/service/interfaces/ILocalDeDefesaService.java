package br.ufc.qxd.agtcc.service.interfaces;

import java.util.List;

import br.ufc.qxd.agtcc.model.entities.LocalDeDefesa;


public interface ILocalDeDefesaService {

	public LocalDeDefesa save(LocalDeDefesa localDeDefesa);

	public LocalDeDefesa update(LocalDeDefesa localDeDefesa);

	public void delete(Long id);

	public List<LocalDeDefesa> findAll();

	public LocalDeDefesa findOne(Long id);
	
}
